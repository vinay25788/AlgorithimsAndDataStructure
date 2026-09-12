package org.example;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class ParkingLotDemo {

    enum VehicleType { MOTORCYCLE, CAR, TRUCK }
    enum SpotType { MOTORCYCLE, COMPACT, LARGE }
    enum GateType { ENTRY, EXIT }
    enum TicketStatus { ACTIVE, CLOSED }

    abstract static class Vehicle {
        private final String licensePlate;
        private final VehicleType type;

        protected Vehicle(String licensePlate, VehicleType type) {
            this.licensePlate = licensePlate;
            this.type = type;
        }

        public String getLicensePlate() { return licensePlate; }
        public VehicleType getType() { return type; }
    }

    static final class Car extends Vehicle {
        Car(String licensePlate) { super(licensePlate, VehicleType.CAR); }
    }

    static final class Motorcycle extends Vehicle {
        Motorcycle(String licensePlate) { super(licensePlate, VehicleType.MOTORCYCLE); }
    }

    static final class Truck extends Vehicle {
        Truck(String licensePlate) { super(licensePlate, VehicleType.TRUCK); }
    }

    static final class Gate {
        private final String id;
        private final GateType type;

        Gate(String id, GateType type) {
            this.id = id;
            this.type = type;
        }

        String getId() { return id; }
        GateType getType() { return type; }
    }

    static final class ParkingSpot {
        private final String id;
        private final SpotType type;
        private final ReentrantLock lock = new ReentrantLock();
        private volatile Vehicle parkedVehicle;

        ParkingSpot(String id, SpotType type) {
            this.id = id;
            this.type = type;
        }

        boolean tryPark(Vehicle vehicle) {
            if (vehicle == null) {
                return false;
            }
            if (!canFit(vehicle.getType()) || !lock.tryLock()) {
                return false;
            }
            try {
                if (parkedVehicle != null) {
                    return false;
                }
                parkedVehicle = vehicle;
                return true;
            } finally {
                lock.unlock();
            }
        }

        void release(String expectedLicensePlate) {
            lock.lock();
            try {
                if (parkedVehicle == null ||
                        !parkedVehicle.getLicensePlate().equals(expectedLicensePlate)) {
                    throw new IllegalStateException(
                            "Spot " + id + " is not occupied by " + expectedLicensePlate);
                }
                parkedVehicle = null;
            } finally {
                lock.unlock();
            }
        }

        boolean canFit(VehicleType vehicleType) {
            if (vehicleType == VehicleType.MOTORCYCLE) {
                return true;
            }
            if (vehicleType == VehicleType.CAR) {
                return type == SpotType.COMPACT || type == SpotType.LARGE;
            }
            return type == SpotType.LARGE;
        }

        boolean isAvailable() { return parkedVehicle == null; }
        String getId() { return id; }
        SpotType getType() { return type; }
    }

    interface AvailabilityObserver {
        void onAvailabilityChanged(ParkingLevel level);
    }

    static final class ParkingLevel {
        private final int number;
        private final List<ParkingSpot> spots;
        private final List<AvailabilityObserver> observers = new CopyOnWriteArrayList<>();

        ParkingLevel(int number, List<ParkingSpot> spots) {
            this.number = number;
            this.spots = List.copyOf(spots);
        }

        void addObserver(AvailabilityObserver observer) {
            if (observer != null) {
                observers.add(observer);
                observer.onAvailabilityChanged(this);
            }
        }

        void notifyAvailabilityChanged() {
            for (AvailabilityObserver observer : observers) {
                observer.onAvailabilityChanged(this);
            }
        }

        long availableCount(SpotType type) {
            long count = 0;
            for (ParkingSpot spot : spots) {
                if (spot.isAvailable() && spot.getType() == type) {
                    count++;
                }
            }
            return count;
        }

        int getNumber() { return number; }
        List<ParkingSpot> getSpots() { return spots; }
    }

    static final class AvailabilityDisplayBoard implements AvailabilityObserver {
        private final Map<Integer, Map<SpotType, Long>> availability = new ConcurrentHashMap<>();

        @Override
        public void onAvailabilityChanged(ParkingLevel level) {
            Map<SpotType, Long> counts = new EnumMap<>(SpotType.class);
            for (SpotType type : SpotType.values()) {
                counts.put(type, level.availableCount(type));
            }
            availability.put(level.getNumber(), Map.copyOf(counts));
        }

        Map<Integer, Map<SpotType, Long>> snapshot() {
            return Map.copyOf(availability);
        }
    }

    static final class Ticket {
        private final String id;
        private final Vehicle vehicle;
        private final ParkingSpot spot;
        private final int levelNumber;
        private final Gate entryGate;
        private final Instant entryTime;
        private volatile TicketStatus status = TicketStatus.ACTIVE;
        private volatile Instant exitTime;

        private Ticket(Builder builder) {
            id = builder.id;
            vehicle = builder.vehicle;
            spot = builder.spot;
            levelNumber = builder.levelNumber;
            entryGate = builder.entryGate;
            entryTime = builder.entryTime;
        }

        synchronized void close(Instant time) {
            if (status != TicketStatus.ACTIVE) {
                throw new IllegalStateException("Ticket is already closed: " + id);
            }
            status = TicketStatus.CLOSED;
            exitTime = time;
        }

        static Builder builder() { return new Builder(); }

        String getId() { return id; }
        Vehicle getVehicle() { return vehicle; }
        ParkingSpot getSpot() { return spot; }
        int getLevelNumber() { return levelNumber; }
        Gate getEntryGate() { return entryGate; }
        Instant getEntryTime() { return entryTime; }
        TicketStatus getStatus() { return status; }
        Instant getExitTime() { return exitTime; }

        static final class Builder {
            private String id;
            private Vehicle vehicle;
            private ParkingSpot spot;
            private int levelNumber;
            private Gate entryGate;
            private Instant entryTime;

            Builder id(String value) { id = value; return this; }
            Builder vehicle(Vehicle value) { vehicle = value; return this; }
            Builder spot(ParkingSpot value) { spot = value; return this; }
            Builder levelNumber(int value) { levelNumber = value; return this; }
            Builder entryGate(Gate value) { entryGate = value; return this; }
            Builder entryTime(Instant value) { entryTime = value; return this; }
            Ticket build() { return new Ticket(this); }
        }
    }

    // Initialization-on-demand holder gives a lazy, thread-safe singleton.
    static final class ParkingLot {
        private final Map<String, Gate> gates = new ConcurrentHashMap<>();
        private volatile List<ParkingLevel> levels = List.of();

        private ParkingLot() {}

        private static class Holder {
            private static final ParkingLot INSTANCE = new ParkingLot();
        }

        static ParkingLot getInstance() { return Holder.INSTANCE; }

        synchronized void configure(List<ParkingLevel> newLevels, List<Gate> newGates) {
            levels = List.copyOf(newLevels);
            gates.clear();
            for (Gate gate : newGates) {
                gates.put(gate.getId(), gate);
            }
        }

        List<ParkingLevel> getLevels() { return levels; }

        Gate requireGate(String gateId, GateType expectedType) {
            Gate gate = gates.get(gateId);
            if (gate == null) {
                throw new IllegalArgumentException("Unknown gate: " + gateId);
            }
            if (gate.getType() != expectedType) {
                throw new IllegalArgumentException(
                        "Gate " + gateId + " is not a " + expectedType + " gate");
            }
            return gate;
        }
    }

    static final class SpotAssignment {
        private final ParkingLevel level;
        private final ParkingSpot spot;

        SpotAssignment(ParkingLevel level, ParkingSpot spot) {
            this.level = level;
            this.spot = spot;
        }

        ParkingLevel getLevel() { return level; }
        ParkingSpot getSpot() { return spot; }
    }

    interface ParkingSpotAllocationStrategy {
        Optional<SpotAssignment> assign(List<ParkingLevel> levels, Vehicle vehicle);
    }

    static final class FirstAvailableStrategy implements ParkingSpotAllocationStrategy {
        @Override
        public Optional<SpotAssignment> assign(List<ParkingLevel> levels, Vehicle vehicle) {
            for (ParkingLevel level : levels) {
                for (ParkingSpot spot : level.getSpots()) {
                    if (spot.tryPark(vehicle)) {
                        return Optional.of(new SpotAssignment(level, spot));
                    }
                }
            }
            return Optional.empty();
        }
    }

    static final class TicketService {
        private final ConcurrentMap<String, Ticket> activeTickets = new ConcurrentHashMap<>();
        private final Clock clock;

        TicketService(Clock clock) {
            this.clock = clock;
        }

        Ticket create(Vehicle vehicle, SpotAssignment assignment, Gate entryGate) {
            Ticket ticket = Ticket.builder()
                    .id(UUID.randomUUID().toString())
                    .vehicle(vehicle)
                    .spot(assignment.getSpot())
                    .levelNumber(assignment.getLevel().getNumber())
                    .entryGate(entryGate)
                    .entryTime(Instant.now(clock))
                    .build();
            activeTickets.put(ticket.getId(), ticket);
            return ticket;
        }

        Ticket removeActive(String ticketId) {
            Ticket ticket = activeTickets.remove(ticketId);
            if (ticket == null) {
                throw new IllegalArgumentException("No active ticket: " + ticketId);
            }
            return ticket;
        }

        void restore(Ticket ticket) {
            activeTickets.putIfAbsent(ticket.getId(), ticket);
        }

        Instant now() { return Instant.now(clock); }
    }

    interface FeeCalculationStrategy {
        double calculateFee(Ticket ticket);
    }

    static final class FixedFeeStrategy implements FeeCalculationStrategy {
        private final double fixedFee;

        FixedFeeStrategy(double fixedFee) {
            this.fixedFee = fixedFee;
        }

        @Override
        public double calculateFee(Ticket ticket) {
            return fixedFee;
        }
    }

    static final class HourlyFeeStrategy implements FeeCalculationStrategy {
        private final double hourlyRate;

        HourlyFeeStrategy(double hourlyRate) {
            this.hourlyRate = hourlyRate;
        }

        @Override
        public double calculateFee(Ticket ticket) {
            long parkedMinutes = Duration.between(
                    ticket.getEntryTime(), ticket.getExitTime()).toMinutes();

            // Charge for at least one hour and round partial hours upward.
            long chargedHours = (parkedMinutes + 59) / 60;
            if (chargedHours == 0) {
                chargedHours = 1;
            }
            return chargedHours * hourlyRate;
        }
    }

    static final class ExitReceipt {
        private final Ticket ticket;
        private final double parkingFee;

        ExitReceipt(Ticket ticket, double parkingFee) {
            this.ticket = ticket;
            this.parkingFee = parkingFee;
        }

        Ticket getTicket() { return ticket; }
        double getParkingFee() { return parkingFee; }
    }

    static final class ParkingService {
        private final ParkingLot parkingLot;
        private final ParkingSpotAllocationStrategy allocationStrategy;
        private final FeeCalculationStrategy feeCalculationStrategy;
        private final TicketService ticketService;

        ParkingService(ParkingLot parkingLot,
                       ParkingSpotAllocationStrategy allocationStrategy,
                       FeeCalculationStrategy feeCalculationStrategy,
                       TicketService ticketService) {
            this.parkingLot = parkingLot;
            this.allocationStrategy = allocationStrategy;
            this.feeCalculationStrategy = feeCalculationStrategy;
            this.ticketService = ticketService;
        }

        Ticket park(Vehicle vehicle, String entryGateId) {
            Gate entryGate = parkingLot.requireGate(entryGateId, GateType.ENTRY);
            Optional<SpotAssignment> result =
                    allocationStrategy.assign(parkingLot.getLevels(), vehicle);
            if (result.isEmpty()) {
                throw new ParkingFullException(
                        "No compatible spot for " + vehicle.getType());
            }
            SpotAssignment assignment = result.get();

            Ticket ticket = ticketService.create(vehicle, assignment, entryGate);
            assignment.getLevel().notifyAvailabilityChanged();
            return ticket;
        }

        ExitReceipt exit(String ticketId, String exitGateId) {
            parkingLot.requireGate(exitGateId, GateType.EXIT);
            Ticket ticket = ticketService.removeActive(ticketId);

            try {
                ticket.getSpot().release(ticket.getVehicle().getLicensePlate());
                ticket.close(ticketService.now());
                findLevel(ticket.getLevelNumber()).notifyAvailabilityChanged();
                double fee = feeCalculationStrategy.calculateFee(ticket);
                return new ExitReceipt(ticket, fee);
            } catch (RuntimeException exception) {
                ticketService.restore(ticket);
                throw exception;
            }
        }

        private ParkingLevel findLevel(int levelNumber) {
            for (ParkingLevel level : parkingLot.getLevels()) {
                if (level.getNumber() == levelNumber) {
                    return level;
                }
            }
            throw new IllegalStateException("Missing level: " + levelNumber);
        }
    }

    static final class ParkingFullException extends RuntimeException {
        ParkingFullException(String message) { super(message); }
    }

    // Facade used by the client. It hides object creation and service wiring.
    static final class ParkingLotManager {
        private final ParkingService parkingService;
        private final AvailabilityDisplayBoard displayBoard;

        ParkingLotManager() {
            displayBoard = new AvailabilityDisplayBoard();

            ParkingLevel groundFloor = new ParkingLevel(1, List.of(
                    new ParkingSpot("1-M1", SpotType.MOTORCYCLE),
                    new ParkingSpot("1-C1", SpotType.COMPACT),
                    new ParkingSpot("1-L1", SpotType.LARGE)));

            ParkingLevel firstFloor = new ParkingLevel(2, List.of(
                    new ParkingSpot("2-C1", SpotType.COMPACT),
                    new ParkingSpot("2-L1", SpotType.LARGE)));

            groundFloor.addObserver(displayBoard);
            firstFloor.addObserver(displayBoard);

            ParkingLot parkingLot = ParkingLot.getInstance();
            parkingLot.configure(List.of(groundFloor, firstFloor), List.of(
                    new Gate("ENTRY-A", GateType.ENTRY),
                    new Gate("ENTRY-B", GateType.ENTRY),
                    new Gate("EXIT-A", GateType.EXIT),
                    new Gate("EXIT-B", GateType.EXIT)));

            TicketService ticketService = new TicketService(Clock.systemUTC());
            ParkingSpotAllocationStrategy parkingStrategy = new FirstAvailableStrategy();

            // Change this to new FixedFeeStrategy(100.0) for a fixed fee.
            FeeCalculationStrategy feeStrategy = new HourlyFeeStrategy(50.0);
            parkingService = new ParkingService(
                    parkingLot, parkingStrategy, feeStrategy, ticketService);
        }

        Ticket enter(Vehicle vehicle, String entryGateId) {
            return parkingService.park(vehicle, entryGateId);
        }

        ExitReceipt exit(String ticketId, String exitGateId) {
            return parkingService.exit(ticketId, exitGateId);
        }

        void showAvailability() {
            System.out.println("Availability: " + displayBoard.snapshot());
        }
    }

    public static void main(String[] args) {
        ParkingLotManager manager = new ParkingLotManager();

        Ticket carTicket = manager.enter(new Car("KA-01-AB-1234"), "ENTRY-A");
        Ticket truckTicket = manager.enter(new Truck("KA-02-TR-9999"), "ENTRY-B");

        System.out.println("Car parked at: " + carTicket.getSpot().getId());
        System.out.println("Truck parked at: " + truckTicket.getSpot().getId());
        manager.showAvailability();

        ExitReceipt carReceipt = manager.exit(carTicket.getId(), "EXIT-A");
        ExitReceipt truckReceipt = manager.exit(truckTicket.getId(), "EXIT-B");

        System.out.println("Car ticket status: " + carTicket.getStatus());
        System.out.println("Car parking fee: " + carReceipt.getParkingFee());
        System.out.println("Truck parking fee: " + truckReceipt.getParkingFee());
        manager.showAvailability();
    }
}