package concurrency.concurrentcollection;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class Task implements  Runnable
{

    @Override
    public void run() {
        System.out.println(" thread name  "+Thread.currentThread().getName());
    }
}

class MyThreadFatory implements ThreadFactory
{

    private AtomicInteger counter;
    private String prefix;

    public MyThreadFatory(String prefix)
    {
        this.prefix = prefix;
        counter = new AtomicInteger(1);
    }
    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r,prefix+"-"+counter.getAndIncrement());
    }
}
public class ThreadUsingThreadFactory {
    public static void main(String[] args) {
        MyThreadFatory fth =  new  MyThreadFatory(" my_thready");
        Task tsk = new Task();
        Thread th= fth.newThread(tsk);
        Thread th2 = fth.newThread(tsk);
        th.start();
        th2.start();
        Thread th3 = fth.newThread(tsk);
        th3.start();
    }

}
