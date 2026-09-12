package org.example;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MovieBookingApplication {
    public static void main(String[] args) throws Exception {
        MovieBookingFacade facade = MovieBookingFacade.createDefault();

        // Admin setup
        facade.registerMovie("movie-1", "Interstellar", 169);

        facade.registerTheater(
                "theater-1", "Central Cinema", "Bengaluru", "screen-1", "IMAX");
        facade.registerSeat("theater-1", "screen-1", "A1", "A", 1, SeatType.REGULAR);
        facade.registerSeat("theater-1", "screen-1", "A2", "A", 2, SeatType.REGULAR);
        facade.registerSeat("theater-1", "screen-1", "B1", "B", 1, SeatType.PREMIUM);
        facade.registerSeat("theater-1", "screen-1", "B2", "B", 2, SeatType.PREMIUM);
        facade.scheduleShow(
                "show-1", "movie-1", "theater-1", "screen-1",
                LocalDateTime.now().plusHours(2),
                new BigDecimal("250.00"));

        // Customer flow
        System.out.println("Movies: " + facade.getMovies());
        System.out.println("Theaters: " + facade.getTheaters("movie-1"));
        System.out.println("Shows: " + facade.getShows("movie-1", "theater-1"));
        System.out.println("Seats before booking: " + facade.getSeats("show-1"));

        Booking booking = facade.bookTickets(
                "show-1", Arrays.asList("A1", "B1"), PaymentMethod.UPI,
                "user-1", "Alice", "alice@example.com");
        System.out.println("Booking: " + booking);
        System.out.println("Seats after booking: " + facade.getSeats("show-1"));

        // Double-booking prevention demo
        demonstrateConcurrentBooking(facade, "show-1");

        // Cancel booking
        facade.cancelBooking(booking.id());
        Booking cancelledBooking = facade.getBooking(booking.id()).orElse(null);
        if (cancelledBooking == null) {
            throw new NotFoundException("Booking not found: " + booking.id());
        }
        System.out.println("Cancelled booking: " + cancelledBooking);
        System.out.println("Seats after cancellation: " + facade.getSeats("show-1"));
    }

    private static void demonstrateConcurrentBooking(
            MovieBookingFacade facade, String showId) throws InterruptedException {
        CountDownLatch ready = new CountDownLatch(2);
        CountDownLatch start = new CountDownLatch(1);
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(new Runnable() {
            @Override
            public void run() {
                bookSameSeat(facade, showId, "user-2", "Bob", ready, start);
            }
        });
        executor.submit(new Runnable() {
            @Override
            public void run() {
                bookSameSeat(facade, showId, "user-3", "Carol", ready, start);
            }
        });

        ready.await();
        System.out.println("Both users are ready. Starting booking...");
        start.countDown();

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
    }

    private static void bookSameSeat(
            MovieBookingFacade facade,
            String showId,
            String userId,
            String userName,
            CountDownLatch ready,
            CountDownLatch start) {
        try {
            ready.countDown();
            start.await();
            Booking booking = facade.bookTickets(
                    showId,
                    Collections.singletonList("A2"),
                    PaymentMethod.CARD,
                    userId,
                    userName,
                    userName.toLowerCase() + "@example.com");
            System.out.println(userName + " booked A2: " + booking.id());
        } catch (BookingException exception) {
            System.out.println(userName + " failed: " + exception.getMessage());
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }
}

enum SeatType {
    REGULAR,
    PREMIUM
}

enum SeatStatus {
    AVAILABLE,
    BOOKED
}

enum BookingStatus {
    CONFIRMED,
    CANCELLED
}

enum PaymentMethod {
    CARD,
    UPI,
    NET_BANKING
}

enum PaymentStatus {
    SUCCESS,
    FAILED,
    REFUNDED
}

final class Movie {
    private final String id;
    private final String title;
    private final Duration duration;

    Movie(String id, String title, Duration duration) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Movie id is required");
        }
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Movie title is required");
        }
        this.id = id;
        this.title = title;
        this.duration = Objects.requireNonNull(duration, "Movie duration is required");
    }

    String id() { return id; }
    String title() { return title; }
    Duration duration() { return duration; }

    @Override
    public String toString() {
        return "Movie[id=" + id + ", title=" + title + ", duration=" + duration + "]";
    }
}

final class User {
    private final String id;
    private final String name;
    private final String email;

    User(String id, String name, String email) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("User id is required");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("User name is required");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("User email is required");
        }
        this.id = id;
        this.name = name;
        this.email = email;
    }

    String id() { return id; }
    String name() { return name; }
    String email() { return email; }
}

final class Seat {
    private final String id;
    private final String row;
    private final int number;
    private final SeatType type;

    Seat(String id, String row, int number, SeatType type) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Seat id is required");
        }
        if (row == null || row.trim().isEmpty()) {
            throw new IllegalArgumentException("Seat row is required");
        }
        if (number <= 0) {
            throw new IllegalArgumentException("Seat number must be positive");
        }
        this.id = id;
        this.row = row;
        this.number = number;
        this.type = Objects.requireNonNull(type, "Seat type is required");
    }

    String id() { return id; }
    String row() { return row; }
    int number() { return number; }
    SeatType type() { return type; }

    @Override
    public String toString() {
        return "Seat[id=" + id + ", row=" + row + ", number=" + number + ", type=" + type + "]";
    }
}

final class Screen {
    private final String id;
    private final String name;
    private final Map<String, Seat> seats;
    private final Map<String, Show> shows;
    private volatile Theater theater;

    Screen(String id, String name, List<Seat> seats) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Screen id is required");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Screen name is required");
        }
        this.id = id;
        this.name = name;
        this.seats = new LinkedHashMap<String, Seat>();
        this.shows = new LinkedHashMap<String, Show>();

        for (Seat seat : seats) {
            if (this.seats.put(seat.id(), seat) != null) {
                throw new IllegalArgumentException("Duplicate seat id: " + seat.id());
            }
        }
    }

    String id() { return id; }
    String name() { return name; }
    List<Seat> seats() {
        return new ArrayList<Seat>(seats.values());
    }

    List<Show> shows() {
        return new ArrayList<Show>(shows.values());
    }

    void addShow(Show show) {
        if (shows.putIfAbsent(show.id(), show) != null) {
            throw new IllegalArgumentException("Show already exists: " + show.id());
        }
    }

    void removeShow(String showId) {
        if (shows.remove(showId) == null) {
            throw new NotFoundException("Show not found: " + showId);
        }
    }
    Theater theater() {
        if (theater == null) {
            throw new IllegalStateException("Screen " + id + " is not assigned to a theater");
        }
        return theater;
    }

    void assignTo(Theater theater) {
        this.theater = theater;
    }

    void addSeat(Seat seat) {
        if (seats.putIfAbsent(seat.id(), seat) != null) {
            throw new IllegalArgumentException("Seat already exists: " + seat.id());
        }
    }

    void updateSeat(Seat seat) {
        if (!seats.containsKey(seat.id())) {
            throw new NotFoundException("Seat not found: " + seat.id());
        }
        seats.put(seat.id(), seat);
    }

    void removeSeat(String seatId) {
        if (seats.remove(seatId) == null) {
            throw new NotFoundException("Seat not found: " + seatId);
        }
    }

    @Override
    public String toString() {
        return "Screen[id=" + id + ", name=" + name + ", seats=" + seats.values() + "]";
    }
}

final class Theater {
    private final String id;
    private final String name;
    private final String city;
    private final List<Screen> screens;

    Theater(String id, String name, String city, List<Screen> screens) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Theater id is required");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Theater name is required");
        }
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("Theater city is required");
        }
        this.id = id;
        this.name = name;
        this.city = city;
        this.screens = new ArrayList<Screen>(screens);
        for (Screen screen : this.screens) {
            screen.assignTo(this);
        }
    }

    String id() { return id; }
    String name() { return name; }
    String city() { return city; }
    List<Screen> screens() { return screens; }

    @Override
    public String toString() {
        return "Theater[id=" + id + ", name=" + name + ", city=" + city + ", screens=" + screens + "]";
    }
}

final class ShowSeat {
    private final Seat seat;
    private final ReentrantLock lock = new ReentrantLock();
    private volatile SeatStatus status = SeatStatus.AVAILABLE;

    ShowSeat(Seat seat) {
        this.seat = Objects.requireNonNull(seat);
    }

    Seat seat() {
        return seat;
    }

    SeatStatus status() {
        return status;
    }

    ReentrantLock lock() {
        return lock;
    }

    void book() {
        if (status != SeatStatus.AVAILABLE) {
            throw new BookingException("Seat " + seat.id() + " is not available");
        }
        status = SeatStatus.BOOKED;
    }

    void release() {
        status = SeatStatus.AVAILABLE;
    }

    @Override
    public String toString() {
        return seat.id() + "(" + seat.type() + ", " + status + ")";
    }
}

final class Show {
    private final String id;
    private final String movieId;
    private final Screen screen;
    private final LocalDateTime startTime;
    private final BigDecimal basePrice;
    private final ConcurrentHashMap<String, ShowSeat> showSeats;

    private Show(
            String id,
            String movieId,
            Screen screen,
            LocalDateTime startTime,
            BigDecimal basePrice,
            ConcurrentHashMap<String, ShowSeat> showSeats) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Show id is required");
        }
        if (movieId == null || movieId.trim().isEmpty()) {
            throw new IllegalArgumentException("Movie id is required");
        }
        this.id = id;
        this.movieId = movieId;
        this.screen = Objects.requireNonNull(screen);
        screen.theater();
        this.startTime = Objects.requireNonNull(startTime);
        this.basePrice = Objects.requireNonNull(basePrice);
        if (basePrice.signum() < 0) {
            throw new IllegalArgumentException("Base price cannot be negative");
        }
        this.showSeats = showSeats;
    }

    static Show create(
            String id,
            String movieId,
            Screen screen,
            LocalDateTime startTime,
            BigDecimal basePrice) {
        ConcurrentHashMap<String, ShowSeat> showSeats = new ConcurrentHashMap<>();
        for (Seat seat : screen.seats()) {
            showSeats.put(seat.id(), new ShowSeat(seat));
        }
        return new Show(id, movieId, screen, startTime, basePrice, showSeats);
    }

    String id() {
        return id;
    }

    String movieId() {
        return movieId;
    }

    String theaterId() {
        return screen.theater().id();
    }

    Screen screen() {
        return screen;
    }

    LocalDateTime startTime() {
        return startTime;
    }

    BigDecimal basePrice() {
        return basePrice;
    }

    Collection<ShowSeat> showSeats() {
        return new ArrayList<ShowSeat>(showSeats.values());
    }

    ShowSeat requireSeat(String seatId) {
        ShowSeat showSeat = showSeats.get(seatId);
        if (showSeat == null) {
            throw new BookingException("Seat " + seatId + " does not exist for show " + id);
        }
        return showSeat;
    }

    List<ShowSeat> lockAvailableSeats(List<String> seatIds) {
        List<String> uniqueSeatIds = new ArrayList<String>();
        for (String seatId : seatIds) {
            if (!uniqueSeatIds.contains(seatId)) {
                uniqueSeatIds.add(seatId);
            }
        }
        Collections.sort(uniqueSeatIds);
        if (uniqueSeatIds.size() != seatIds.size()) {
            throw new BookingException("Duplicate seat ids are not allowed");
        }
        List<ShowSeat> requestedSeats = new ArrayList<ShowSeat>();
        for (String seatId : uniqueSeatIds) {
            requestedSeats.add(requireSeat(seatId));
        }
        lockAll(requestedSeats);
        try {
            for (ShowSeat showSeat : requestedSeats) {
                if (showSeat.status() != SeatStatus.AVAILABLE) {
                    throw new BookingException("Seat " + showSeat.seat().id() + " is not available");
                }
            }
            return requestedSeats;
        } catch (RuntimeException exception) {
            unlockAllReverse(requestedSeats);
            throw exception;
        }
    }

    void bookSeats(List<ShowSeat> seats) {
        for (ShowSeat showSeat : seats) {
            showSeat.book();
        }
    }

    void unlockSeats(List<ShowSeat> seats) {
        unlockAllReverse(seats);
    }

    void releaseSeats(List<String> seatIds) {
        List<String> sortedSeatIds = new ArrayList<String>(seatIds);
        Collections.sort(sortedSeatIds);
        List<ShowSeat> seats = new ArrayList<ShowSeat>();
        for (String seatId : sortedSeatIds) {
            seats.add(requireSeat(seatId));
        }
        lockAll(seats);
        try {
            for (ShowSeat showSeat : seats) {
                showSeat.release();
            }
        } finally {
            unlockAllReverse(seats);
        }
    }

    private void lockAll(List<ShowSeat> seats) {
        for (ShowSeat showSeat : seats) {
            showSeat.lock().lock();
        }
    }

    private void unlockAllReverse(List<ShowSeat> seats) {
        for (int index = seats.size() - 1; index >= 0; index--) {
            seats.get(index).lock().unlock();
        }
    }

    @Override
    public String toString() {
        return "Show[id=" + id + ", movieId=" + movieId + ", theaterId=" + theaterId()
                + ", screen=" + screen.name() + ", startTime=" + startTime + "]";
    }
}

final class Payment {
    private final String id;
    private final String bookingId;
    private final BigDecimal amount;
    private final PaymentMethod method;
    private volatile PaymentStatus status;

    Payment(String id, String bookingId, BigDecimal amount, PaymentMethod method, PaymentStatus status) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Payment id is required");
        }
        if (bookingId == null || bookingId.trim().isEmpty()) {
            throw new IllegalArgumentException("Booking id is required");
        }
        this.id = id;
        this.bookingId = bookingId;
        this.amount = Objects.requireNonNull(amount);
        this.method = Objects.requireNonNull(method);
        this.status = Objects.requireNonNull(status);
    }

    PaymentStatus status() {
        return status;
    }

    void refund() {
        if (status != PaymentStatus.SUCCESS) {
            throw new PaymentException("Only successful payments can be refunded");
        }
        status = PaymentStatus.REFUNDED;
    }
}

final class Booking {
    private final String id;
    private final String showId;
    private final User user;
    private final List<String> seatIds;
    private final BigDecimal totalAmount;
    private final Payment payment;
    private volatile BookingStatus status;

    Booking(
            String id,
            String showId,
            User user,
            List<String> seatIds,
            BigDecimal totalAmount,
            Payment payment,
            BookingStatus status) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Booking id is required");
        }
        if (showId == null || showId.trim().isEmpty()) {
            throw new IllegalArgumentException("Show id is required");
        }
        this.id = id;
        this.showId = showId;
        this.user = Objects.requireNonNull(user);
        this.seatIds = new ArrayList<String>(seatIds);
        this.totalAmount = Objects.requireNonNull(totalAmount);
        this.payment = Objects.requireNonNull(payment);
        this.status = Objects.requireNonNull(status);
    }

    String id() {
        return id;
    }

    String showId() {
        return showId;
    }

    List<String> seatIds() {
        return seatIds;
    }

    Payment payment() {
        return payment;
    }

    BookingStatus status() {
        return status;
    }

    void cancel() {
        if (status == BookingStatus.CANCELLED) {
            throw new BookingException("Booking " + id + " is already cancelled");
        }
        status = BookingStatus.CANCELLED;
    }

    @Override
    public String toString() {
        return "Booking[id=" + id + ", showId=" + showId + ", user=" + user.name()
                + ", seatIds=" + seatIds + ", totalAmount=" + totalAmount
                + ", paymentStatus=" + payment.status() + ", status=" + status + "]";
    }
}

interface MovieRepository {
    void save(Movie movie);

    Optional<Movie> findById(String id);

    List<Movie> findAll();

    void delete(String id);
}

interface TheaterRepository {
    void save(Theater theater);

    Optional<Theater> findById(String id);

    List<Theater> findAll();
}

interface ShowRepository {
    void save(Show show);

    Optional<Show> findById(String id);

    List<Show> findByMovieId(String movieId);

    List<Show> findByMovieAndTheater(String movieId, String theaterId);

    void delete(String id);
}

interface BookingRepository {
    void save(Booking booking);

    Optional<Booking> findById(String id);
}

final class InMemoryMovieRepository implements MovieRepository {
    private final ConcurrentHashMap<String, Movie> movies = new ConcurrentHashMap<>();

    @Override
    public void save(Movie movie) {
        movies.put(movie.id(), movie);
    }

    @Override
    public Optional<Movie> findById(String id) {
        return Optional.ofNullable(movies.get(id));
    }

    @Override
    public List<Movie> findAll() {
        List<Movie> result = new ArrayList<Movie>(movies.values());
        Collections.sort(result,
                (first, second) -> first.title().compareTo(second.title()));
        return result;
    }

    @Override
    public void delete(String id) {
        movies.remove(id);
    }
}

final class InMemoryTheaterRepository implements TheaterRepository {
    private final ConcurrentHashMap<String, Theater> theaters = new ConcurrentHashMap<>();

    @Override
    public void save(Theater theater) {
        theaters.put(theater.id(), theater);
    }

    @Override
    public Optional<Theater> findById(String id) {
        return Optional.ofNullable(theaters.get(id));
    }

    @Override
    public List<Theater> findAll() {
        List<Theater> result = new ArrayList<Theater>(theaters.values());
        Collections.sort(result, new Comparator<Theater>() {
            public int compare(Theater first, Theater second) {
                return first.name().compareTo(second.name());
            }
        });
        return result;
    }
}

final class InMemoryShowRepository implements ShowRepository {

    private final ConcurrentHashMap<String, Show> shows = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Set<String>> movieShows = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Set<String>> theaterShows = new ConcurrentHashMap<>();

    @Override
    public synchronized void save(Show show) {

        Show previous = shows.put(show.id(), show);

        if (previous != null) {
            removeFromIndexes(previous);
        }

        movieShows
                .computeIfAbsent(show.movieId(), key -> ConcurrentHashMap.newKeySet())
                .add(show.id());

        theaterShows
                .computeIfAbsent(show.theaterId(), key -> ConcurrentHashMap.newKeySet())
                .add(show.id());
    }

    @Override
    public Optional<Show> findById(String id) {
        return Optional.ofNullable(shows.get(id));
    }

    @Override
    public List<Show> findByMovieId(String movieId) {
        return resolve(movieShows.getOrDefault(movieId, Collections.emptySet()));
    }

    @Override
    public List<Show> findByMovieAndTheater(String movieId, String theaterId) {

        Set<String> movieShowIds =
                movieShows.getOrDefault(movieId, Collections.emptySet());

        Set<String> theaterShowIds =
                theaterShows.getOrDefault(theaterId, Collections.emptySet());

        List<Show> result = new ArrayList<>();

        for (String showId : movieShowIds) {
            if (theaterShowIds.contains(showId)) {
                Show show = shows.get(showId);
                if (show != null) {
                    result.add(show);
                }
            }
        }

        result.sort(Comparator.comparing(Show::startTime));

        return result;
    }

    @Override
    public synchronized void delete(String showId) {

        Show show = shows.remove(showId);

        if (show != null) {
            removeFromIndexes(show);
        }
    }

    private List<Show> resolve(Set<String> showIds) {

        List<Show> result = new ArrayList<>();

        for (String showId : showIds) {
            Show show = shows.get(showId);

            if (show != null) {
                result.add(show);
            }
        }

        result.sort(Comparator.comparing(Show::startTime));

        return result;
    }

    private void removeFromIndexes(Show show) {

        remove(movieShows, show.movieId(), show.id());
        remove(theaterShows, show.theaterId(), show.id());
    }

    private void remove(ConcurrentHashMap<String, Set<String>> index,
                        String key,
                        String showId) {

        Set<String> showIds = index.get(key);

        if (showIds == null) {
            return;
        }

        showIds.remove(showId);

        if (showIds.isEmpty()) {
            index.remove(key);
        }
    }
}

final class InMemoryBookingRepository implements BookingRepository {
    private final ConcurrentHashMap<String, Booking> bookings = new ConcurrentHashMap<>();

    @Override
    public void save(Booking booking) {
        bookings.put(booking.id(), booking);
    }

    @Override
    public Optional<Booking> findById(String id) {
        return Optional.ofNullable(bookings.get(id));
    }
}

interface PaymentStrategy {
    PaymentStatus pay(BigDecimal amount);
}

final class CardPaymentStrategy implements PaymentStrategy {
    @Override
    public PaymentStatus pay(BigDecimal amount) {
        return PaymentStatus.SUCCESS;
    }
}

final class UpiPaymentStrategy implements PaymentStrategy {
    @Override
    public PaymentStatus pay(BigDecimal amount) {
        return PaymentStatus.SUCCESS;
    }
}

final class NetBankingPaymentStrategy implements PaymentStrategy {
    @Override
    public PaymentStatus pay(BigDecimal amount) {
        return PaymentStatus.SUCCESS;
    }
}

final class PaymentStrategyFactory {
    private final Map<PaymentMethod, PaymentStrategy> strategies;

    PaymentStrategyFactory() {
        Map<PaymentMethod, PaymentStrategy> configured =
                new EnumMap<PaymentMethod, PaymentStrategy>(PaymentMethod.class);
        configured.put(PaymentMethod.CARD, new CardPaymentStrategy());
        configured.put(PaymentMethod.UPI, new UpiPaymentStrategy());
        configured.put(PaymentMethod.NET_BANKING, new NetBankingPaymentStrategy());
        strategies = configured;
    }

    PaymentStrategy get(PaymentMethod method) {
        PaymentStrategy strategy = strategies.get(method);
        if (strategy == null) {
            throw new PaymentException("Unsupported payment method: " + method);
        }
        return strategy;
    }
}

interface PricingStrategy {
    BigDecimal calculatePrice(Show show, ShowSeat seat);
}

final class RegularPricingStrategy implements PricingStrategy {
    @Override
    public BigDecimal calculatePrice(Show show, ShowSeat seat) {
        return show.basePrice();
    }
}

final class PremiumPricingStrategy implements PricingStrategy {
    private static final BigDecimal MULTIPLIER = new BigDecimal("1.50");

    @Override
    public BigDecimal calculatePrice(Show show, ShowSeat seat) {
        return show.basePrice().multiply(MULTIPLIER);
    }
}

final class PricingStrategyFactory {
    private static final Map<SeatType, PricingStrategy> strategies =new HashMap();

    static {

        strategies.put(SeatType.REGULAR, new RegularPricingStrategy());
        strategies.put(SeatType.PREMIUM, new PremiumPricingStrategy());

    }

    PricingStrategy get(SeatType type) {
        PricingStrategy strategy = strategies.get(type);
        if (strategy == null) {
            throw new BookingException("No pricing strategy for seat type: " + type);
        }
        return strategy;
    }
}

final class MovieService {
    private final MovieRepository movieRepository;

    MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    void updateMovie(Movie movie) {
        if (!movieRepository.findById(movie.id()).isPresent()) {
            throw new NotFoundException("Movie not found: " + movie.id());
        }
        movieRepository.save(movie);
    }

    void removeMovie(String movieId) {
        if (!movieRepository.findById(movieId).isPresent()) {
            throw new NotFoundException("Movie not found: " + movieId);
        }
        movieRepository.delete(movieId);
    }

    List<Movie> getMovies() {
        return movieRepository.findAll();
    }
}

final class TheaterService {
    private final TheaterRepository theaterRepository;

    TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    void addTheater(Theater theater) {
        theaterRepository.save(theater);
    }
}

final class ScreenService {
    private final TheaterRepository theaterRepository;

    ScreenService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    void addSeat(String theaterId, String screenId, Seat seat) {
        requireScreen(theaterId, screenId).addSeat(seat);
    }

    void updateSeat(String theaterId, String screenId, Seat seat) {
        requireScreen(theaterId, screenId).updateSeat(seat);
    }

    void removeSeat(String theaterId, String screenId, String seatId) {
        requireScreen(theaterId, screenId).removeSeat(seatId);
    }

    Screen getScreen(String theaterId, String screenId) {
        return requireScreen(theaterId, screenId);
    }

    private Screen requireScreen(String theaterId, String screenId) {
        Theater theater = theaterRepository.findById(theaterId).orElse(null);
        if (theater == null) {
            throw new NotFoundException("Theater not found: " + theaterId);
        }

        for (Screen screen : theater.screens()) {
            if (screen.id().equals(screenId)) {
                return screen;
            }
        }
        throw new NotFoundException("Screen not found: " + screenId);
    }
}

final class ShowService {
    private final ShowRepository showRepository;
    private final MovieRepository movieRepository;
    private final TheaterRepository theaterRepository;

    ShowService(
            ShowRepository showRepository,
            MovieRepository movieRepository,
            TheaterRepository theaterRepository) {
        this.showRepository = showRepository;
        this.movieRepository = movieRepository;
        this.theaterRepository = theaterRepository;
    }

    void addShow(Show show) {
        validateShow(show);
        Theater theater = theaterRepository.findById(show.theaterId()).orElse(null);
        boolean screenBelongsToTheater = false;
        for (Screen screen : theater.screens()) {
            if (screen.id().equals(show.screen().id())) {
                screenBelongsToTheater = true;
                break;
            }
        }
        if (!screenBelongsToTheater) {
            throw new IllegalArgumentException("Screen does not belong to theater " + theater.id());
        }
        showRepository.save(show);
        show.screen().addShow(show);
    }

    void updateShow(Show show) {
        Show oldShow = requireShow(show.id());
        validateShow(show);
        oldShow.screen().removeShow(oldShow.id());
        showRepository.save(show);
        show.screen().addShow(show);
    }

    void removeShow(String showId) {
        Show show = requireShow(showId);
        show.screen().removeShow(showId);
        showRepository.delete(showId);
    }

    List<Theater> getTheaters(String movieId) {
        if (!movieRepository.findById(movieId).isPresent()) {
            throw new NotFoundException("Movie not found: " + movieId);
        }
        List<Theater> result = new ArrayList<Theater>();
        Set<String> addedTheaterIds = new HashSet<String>();
        for (Show show : showRepository.findByMovieId(movieId)) {
            if (addedTheaterIds.add(show.theaterId())) {
                Theater theater = theaterRepository.findById(show.theaterId()).orElse(null);
                if (theater == null) {
                    throw new NotFoundException("Theater not found: " + show.theaterId());
                }
                result.add(theater);
            }
        }
        Collections.sort(result, new Comparator<Theater>() {
            public int compare(Theater first, Theater second) {
                return first.name().compareTo(second.name());
            }
        });
        return result;
    }

    List<Show> getShows(String movieId, String theaterId) {
        return showRepository.findByMovieAndTheater(movieId, theaterId);
    }

    List<ShowSeat> getSeats(String showId) {
        Show show = requireShow(showId);
        List<ShowSeat> seats = new ArrayList<ShowSeat>(show.showSeats());
        Collections.sort(seats, new Comparator<ShowSeat>() {
            public int compare(ShowSeat first, ShowSeat second) {
                return first.seat().id().compareTo(second.seat().id());
            }
        });
        return seats;
    }

    Show requireShow(String showId) {
        Show show = showRepository.findById(showId).orElse(null);
        if (show == null) {
            throw new NotFoundException("Show not found: " + showId);
        }
        return show;
    }

    private void validateShow(Show show) {
        if (!movieRepository.findById(show.movieId()).isPresent()) {
            throw new NotFoundException("Movie not found: " + show.movieId());
        }
        Theater theater = theaterRepository.findById(show.theaterId()).orElse(null);
        if (theater == null) {
            throw new NotFoundException("Theater not found: " + show.theaterId());
        }
        boolean screenBelongsToTheater = false;
        for (Screen screen : theater.screens()) {
            if (screen.id().equals(show.screen().id())) {
                screenBelongsToTheater = true;
                break;
            }
        }
        if (!screenBelongsToTheater) {
            throw new IllegalArgumentException("Screen does not belong to theater " + theater.id());
        }
    }
}

final class PaymentService {
    private final PaymentStrategyFactory strategyFactory;

    PaymentService(PaymentStrategyFactory strategyFactory) {
        this.strategyFactory = strategyFactory;
    }

    Payment pay(String bookingId, BigDecimal amount, PaymentMethod method) {
        PaymentStatus status = strategyFactory.get(method).pay(amount);
        return new Payment(UUID.randomUUID().toString(), bookingId, amount, method, status);
    }

    void refund(Payment payment) {
        payment.refund();
    }
}

final class BookingService {
    private final ShowRepository showRepository;
    private final BookingRepository bookingRepository;
    private final PaymentService paymentService;
    private final PricingStrategyFactory pricingStrategyFactory;

    BookingService(
            ShowRepository showRepository,
            BookingRepository bookingRepository,
            PaymentService paymentService,
            PricingStrategyFactory pricingStrategyFactory) {
        this.showRepository = showRepository;
        this.bookingRepository = bookingRepository;
        this.paymentService = paymentService;
        this.pricingStrategyFactory = pricingStrategyFactory;
    }

    Booking bookTickets(String showId, List<String> seatIds, PaymentMethod method, User user) {
        if (seatIds == null || seatIds.isEmpty()) {
            throw new BookingException("At least one seat is required");
        }
        Objects.requireNonNull(method, "Payment method is required");
        Objects.requireNonNull(user, "User is required");

        Show show = requireShow(showId);
        List<ShowSeat> requestedSeats = show.lockAvailableSeats(seatIds);
        try {
            BigDecimal total = BigDecimal.ZERO;
            for (ShowSeat showSeat : requestedSeats) {
                BigDecimal seatPrice = pricingStrategyFactory.get(showSeat.seat().type())
                        .calculatePrice(show, showSeat);
                total = total.add(seatPrice);
            }
            String bookingId = UUID.randomUUID().toString();
            Payment payment = paymentService.pay(bookingId, total, method);
            if (payment.status() != PaymentStatus.SUCCESS) {
                throw new PaymentException("Payment failed for booking " + bookingId);
            }

            List<String> uniqueSeatIds = new ArrayList<String>();
            for (ShowSeat showSeat : requestedSeats) {
                uniqueSeatIds.add(showSeat.seat().id());
            }
            Booking booking = new Booking(
                    bookingId,
                    showId,
                    user,
                    uniqueSeatIds,
                    total,
                    payment,
                    BookingStatus.CONFIRMED);
            bookingRepository.save(booking);
            show.bookSeats(requestedSeats);
            return booking;
        } finally {
            show.unlockSeats(requestedSeats);
        }
    }

    void cancelBooking(String bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElse(null);
        if (booking == null) {
            throw new NotFoundException("Booking not found: " + bookingId);
        }
        Show show = requireShow(booking.showId());
        if (booking.status() == BookingStatus.CANCELLED) {
            throw new BookingException("Booking " + bookingId + " is already cancelled");
        }
        paymentService.refund(booking.payment());
        show.releaseSeats(booking.seatIds());
        booking.cancel();
        bookingRepository.save(booking);
    }

    Optional<Booking> getBooking(String bookingId) {
        return bookingRepository.findById(bookingId);
    }

    private Show requireShow(String showId) {
        Show show = showRepository.findById(showId).orElse(null);
        if (show == null) {
            throw new NotFoundException("Show not found: " + showId);
        }
        return show;
    }

}

final class MovieBookingFacade {
    private final MovieService movieService;
    private final TheaterService theaterService;
    private final ScreenService screenService;
    private final ShowService showService;
    private final BookingService bookingService;

    MovieBookingFacade(
            MovieService movieService,
            TheaterService theaterService,
            ScreenService screenService,
            ShowService showService,
            BookingService bookingService) {
        this.movieService = movieService;
        this.theaterService = theaterService;
        this.screenService = screenService;
        this.showService = showService;
        this.bookingService = bookingService;
    }

    static MovieBookingFacade createDefault() {
        MovieRepository movieRepository = new InMemoryMovieRepository();
        TheaterRepository theaterRepository = new InMemoryTheaterRepository();
        ShowRepository showRepository = new InMemoryShowRepository();
        BookingRepository bookingRepository = new InMemoryBookingRepository();

        MovieService movieService = new MovieService(movieRepository);
        TheaterService theaterService = new TheaterService(theaterRepository);
        ScreenService screenService = new ScreenService(theaterRepository);
        ShowService showService = new ShowService(
                showRepository, movieRepository, theaterRepository);
        PaymentService paymentService = new PaymentService(new PaymentStrategyFactory());
        BookingService bookingService = new BookingService(
                showRepository,
                bookingRepository,
                paymentService,
                new PricingStrategyFactory());

        return new MovieBookingFacade(
                movieService, theaterService, screenService, showService, bookingService);
    }

    void registerMovie(String movieId, String title, long durationMinutes) {
        movieService.addMovie(new Movie(movieId, title, Duration.ofMinutes(durationMinutes)));
    }

    void updateMovie(String movieId, String title, long durationMinutes) {
        movieService.updateMovie(new Movie(movieId, title, Duration.ofMinutes(durationMinutes)));
    }

    void removeMovie(String movieId) {
        movieService.removeMovie(movieId);
    }

    void registerTheater(
            String theaterId,
            String theaterName,
            String city,
            String screenId,
            String screenName) {
        Screen screen = new Screen(screenId, screenName, Collections.<Seat>emptyList());
        Theater theater = new Theater(
                theaterId,
                theaterName,
                city,
                Collections.singletonList(screen));
        theaterService.addTheater(theater);
    }

    void registerSeat(
            String theaterId,
            String screenId,
            String seatId,
            String row,
            int number,
            SeatType type) {
        screenService.addSeat(theaterId, screenId, new Seat(seatId, row, number, type));
    }

    void scheduleShow(
            String showId,
            String movieId,
            String theaterId,
            String screenId,
            LocalDateTime startTime,
            BigDecimal basePrice) {
        Screen screen = screenService.getScreen(theaterId, screenId);
        showService.addShow(Show.create(showId, movieId, screen, startTime, basePrice));
    }

    void updateShow(
            String showId,
            String movieId,
            String theaterId,
            String screenId,
            LocalDateTime startTime,
            BigDecimal basePrice) {
        Screen screen = screenService.getScreen(theaterId, screenId);
        showService.updateShow(Show.create(showId, movieId, screen, startTime, basePrice));
    }

    void removeShow(String showId) {
        showService.removeShow(showId);
    }

    void addSeat(String theaterId, String screenId, Seat seat) {
        screenService.addSeat(theaterId, screenId, seat);
    }

    void updateSeat(String theaterId, String screenId, Seat seat) {
        screenService.updateSeat(theaterId, screenId, seat);
    }

    void removeSeat(String theaterId, String screenId, String seatId) {
        screenService.removeSeat(theaterId, screenId, seatId);
    }

    List<Movie> getMovies() {
        return movieService.getMovies();
    }

    List<Theater> getTheaters(String movieId) {
        return showService.getTheaters(movieId);
    }

    List<Show> getShows(String movieId, String theaterId) {
        return showService.getShows(movieId, theaterId);
    }

    List<ShowSeat> getSeats(String showId) {
        return showService.getSeats(showId);
    }

    Booking bookTickets(
            String showId,
            List<String> seatIds,
            PaymentMethod method,
            String userId,
            String userName,
            String email) {
        return bookingService.bookTickets(
                showId, seatIds, method, new User(userId, userName, email));
    }

    void cancelBooking(String bookingId) {
        bookingService.cancelBooking(bookingId);
    }

    Optional<Booking> getBooking(String bookingId) {
        return bookingService.getBooking(bookingId);
    }
}

class MovieBookingException extends RuntimeException {
    MovieBookingException(String message) {
        super(message);
    }
}

final class BookingException extends MovieBookingException {
    BookingException(String message) {
        super(message);
    }
}

final class PaymentException extends MovieBookingException {
    PaymentException(String message) {
        super(message);
    }
}

final class NotFoundException extends MovieBookingException {
    NotFoundException(String message) {
        super(message);
    }
}