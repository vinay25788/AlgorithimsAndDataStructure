package concurrency;

public class DeadLock implements  Runnable {

    public static void main(String[] args) {
        String st = " abc";
        String st2 = "vinay";
        DeadLock obj = new DeadLock();
        Thread th1 = new Thread(obj);
        Thread th2 = new Thread(obj);
        th1.start();
        th2.start();
    }
    public void call1()
    {
        synchronized (String.class)
        {
            System.out.println(" acquired lock using string class call1  "+Thread.currentThread().getName());
            synchronized (Integer.class)
            {
                System.out.println(" acquired lock using Integer class call1 "+ Thread.currentThread().getName());
            }
        }
    }

    public void call2( )
    {
        synchronized (Integer.class)
        {
            System.out.println(" acquired lock using String class call2  "+Thread.currentThread().getName());
            synchronized (String.class)
            {
                System.out.println(" acquired lock using Integer class call2 "+Thread.currentThread().getName());
            }

        }
    }

    @Override
    public void run() {

        call1();
        call2();
    }
}
