package concurrency;

public class ThreadUsingRunnable  implements Runnable{

    private int number =0;

    @Override
    public void run() {

        for(int i=0;i<5;i++)
            System.out.println("thread name "+ Thread.currentThread().getName()+" "+i);
    }

    public static void main(String[] args) {
        ThreadUsingRunnable obj = new ThreadUsingRunnable();
        Thread th = new Thread(obj);
        th.start();
        Thread th2 = new Thread(obj);
        th2.start();
    }
}
