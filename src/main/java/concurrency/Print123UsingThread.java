package concurrency;

public class Print123UsingThread implements Runnable {
    static int number =1;
    int remainder;

     static Object lock = new Object();

    Print123UsingThread(int remainder)
    {
        this.remainder = remainder;
    }

    @Override
    public void run() {

        while(number<10)
        {
            synchronized (lock)
            {
                while(number%3 != remainder) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                System.out.println(Thread.currentThread().getName()+" "+number);
                number++;
                lock.notifyAll();
                }
            }

        }

    public static void main(String[] args) {
        Print123UsingThread t1 = new Print123UsingThread(1);
        Print123UsingThread t2 = new Print123UsingThread(2);
        Print123UsingThread t3 = new Print123UsingThread(0);
        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t2);
        Thread th3 = new Thread(t3);
        th1.start();
        th2.start();
        th3.start();
    }

    }

