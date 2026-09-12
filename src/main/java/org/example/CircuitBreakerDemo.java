package org.example;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

/**
 * Circuit Breaker Pattern - Complete Working Example
 */
public class CircuitBreakerDemo {

    public static void main(String[] args) throws Exception {

        CircuitBreakerConfig config =
                new CircuitBreakerConfig(3, 5000);

        CircuitBreaker breaker = new CircuitBreaker(config);

        RemoteService service = new RemoteService();

        System.out.println("========== First 3 Failures ==========");

        for (int i = 1; i <= 3; i++) {
            try {
                breaker.execute(service::call);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.println("\n========== Circuit is OPEN ==========");

        try {
            breaker.execute(service::call);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("\nWaiting 5 seconds...");
        Thread.sleep(5000);

        System.out.println("\n========== HALF OPEN ==========");

        service.setShouldFail(false);

        try {
            String response = breaker.execute(service::call);
            System.out.println(response);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("\n========== CLOSED Again ==========");

        try {
            String response = breaker.execute(service::call);
            System.out.println(response);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

/*----------------------------------------------------*/

enum CircuitState {
    CLOSED,
    OPEN,
    HALF_OPEN
}

/*----------------------------------------------------*/

class CircuitBreakerConfig {

    private final int failureThreshold;
    private final long waitDurationMillis;

    public CircuitBreakerConfig(int failureThreshold,
                                long waitDurationMillis) {
        this.failureThreshold = failureThreshold;
        this.waitDurationMillis = waitDurationMillis;
    }

    public int getFailureThreshold() {
        return failureThreshold;
    }

    public long getWaitDurationMillis() {
        return waitDurationMillis;
    }
}

/*----------------------------------------------------*/

class FailureCounter {

    private final AtomicInteger failures = new AtomicInteger();

    public int increment() {
        return failures.incrementAndGet();
    }

    public void reset() {
        failures.set(0);
    }

    public int count() {
        return failures.get();
    }
}

/*----------------------------------------------------*/

class CircuitBreakerException extends RuntimeException {

    public CircuitBreakerException(String message) {
        super(message);
    }
}

/*----------------------------------------------------*/

class CircuitBreaker {

    private volatile CircuitState state = CircuitState.CLOSED;

    private final FailureCounter counter = new FailureCounter();

    private final CircuitBreakerConfig config;

    private volatile long lastFailureTime;

    /**
     * Only one request is allowed in HALF_OPEN state.
     */
    private final AtomicBoolean trialRequest =
            new AtomicBoolean(false);

    public CircuitBreaker(CircuitBreakerConfig config) {
        this.config = config;
    }

    public <T> T execute(Supplier<T> supplier) {

        if (!allowRequest()) {
            throw new CircuitBreakerException(
                    "Circuit is OPEN. Request rejected.");
        }

        try {

            T result = supplier.get();

            recordSuccess();

            return result;

        } catch (Exception ex) {

            recordFailure();

            throw ex;
        }
    }

    /**
     * Decide whether request should proceed.
     */
    private boolean allowRequest() {

        switch (state) {

            case CLOSED:
                return true;

            case OPEN:

                long elapsed =
                        System.currentTimeMillis()
                                - lastFailureTime;

                if (elapsed >= config.getWaitDurationMillis()) {

                    System.out.println(
                            "Timeout completed. Moving to HALF_OPEN.");

                    state = CircuitState.HALF_OPEN;

                } else {

                    return false;
                }

            case HALF_OPEN:

                return trialRequest.compareAndSet(
                        false,
                        true);

            default:
                return false;
        }
    }

    /**
     * Successful request.
     */
    private synchronized void recordSuccess() {

        counter.reset();

        state = CircuitState.CLOSED;

        trialRequest.set(false);

        System.out.println(
                "State -> CLOSED");
    }

    /**
     * Failed request.
     */
    private synchronized void recordFailure() {

        lastFailureTime = System.currentTimeMillis();

        trialRequest.set(false);

        if (state == CircuitState.HALF_OPEN) {

            state = CircuitState.OPEN;

            System.out.println(
                    "HALF_OPEN request failed. State -> OPEN");

            return;
        }

        int failures = counter.increment();

        System.out.println(
                "Failure Count = " + failures);

        if (failures >= config.getFailureThreshold()) {

            state = CircuitState.OPEN;

            System.out.println(
                    "Threshold reached. State -> OPEN");
        }
    }
}

/*----------------------------------------------------*/

/**
 * Dummy downstream service.
 */
class RemoteService {

    private boolean shouldFail = true;

    public void setShouldFail(boolean shouldFail) {
        this.shouldFail = shouldFail;
    }

    public String call() {

        if (shouldFail) {
            throw new RuntimeException(
                    "Remote service failed.");
        }

        return "Remote service success.";
    }
}