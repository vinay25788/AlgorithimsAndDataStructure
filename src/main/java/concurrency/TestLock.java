package concurrency;

class Demo implements Runnable {

    public volatile int number;

    @Override
    public void run() {
        for (int i = 0; i < 5; i++)
            test();
    }

    public void test() {
        synchronized (Demo.class) {
            System.out.println(" I am in test " + Thread.currentThread().getName()+" value "+number++);

        }
    }
}

public class TestLock {
    public static void main(String[] args) {

        Demo d1 = new Demo();


        Thread t1 = new Thread(d1, "first");
        Thread t2 = new Thread(d1, "second");
        Thread t3 = new Thread(d1, "third");

        t1.start();
        t2.start();
        t3.start();

    }
}
