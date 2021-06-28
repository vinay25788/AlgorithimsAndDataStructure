package concurrency;

public class ThreadUsingThread  extends  Thread{

    public void run()
    {
        for(int i=0;i<5;i++)
            System.out.println("thread name "+ Thread.currentThread().getName()+" "+i);
    }

    public static void main(String[] args) {
        ThreadUsingThread obj = new ThreadUsingThread();
        ThreadUsingThread obj2 = new ThreadUsingThread();
        obj.start();
        obj2.start();
    }
}
