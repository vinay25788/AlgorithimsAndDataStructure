package concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Producers implements Runnable {
    Lock lock;
    Condition bufferEmpty;
    Condition bufferFull;
    Queue<Integer> que;
    int capacity = 10;
    static int number;

    Producers(Lock lock, Condition emptySpaces, Condition fullSpaces, Queue<Integer> que) {

        this.lock = lock;
        this.bufferEmpty = emptySpaces;
        this.bufferFull = fullSpaces;
        this.que = que;
    }

    public void produce() {
        try {
            lock.lock();

            while (que.size() == capacity)
            {
                bufferFull.await();
            }
            System.out.println("produced " + number);
            boolean status = que.offer(number++);
            if (status)
                bufferEmpty.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {

        for (int i = 0; i < 30; i++)
            produce();
    }
}

class Consumers implements Runnable {

    Lock lock;
    Condition bufferEmpty;
    Condition bufferFull;
    Queue<Integer> que;

    Consumers(Lock lock, Condition emptySpaces, Condition fullSpaces, Queue<Integer> que) {

        this.lock = lock;
        this.bufferEmpty = emptySpaces;
        this.bufferFull = fullSpaces;
        this.que = que;
    }

    public void consume() {
        while (true) {
            try {
                lock.lock();

                while (que.isEmpty()) {
                    bufferEmpty.await();
                }

                Integer value = que.poll();
                System.out.println("consumed " + value);

                if (value != null)
                    bufferFull.signalAll();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    @Override
    public void run() {
        consume();
    }
}

public class ProducerConsumerUsingLockAndConditions {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition queFull = lock.newCondition();
        Condition queEmpty = lock.newCondition();
        Queue<Integer> que = new LinkedList<>();

        Producers pr = new Producers(lock, queEmpty, queFull, que);
        Consumers cr = new Consumers(lock, queEmpty, queFull, que);
        Thread pth = new Thread(pr);
        Thread cth = new Thread(cr);
        pth.start();
        cth.start();
    }

}
