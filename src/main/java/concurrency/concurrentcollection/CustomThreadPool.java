package concurrency.concurrentcollection;



import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

 class Task2 implements Runnable {
    private String name;

    public Task2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void run() {
        try {
            Long duration = (long) (Math.random() * 10);
            System.out.println("Executing : " + name);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class CustomThreadPool {

    private int poolSize;
    private final WorkerThread[] workers;

    private final LinkedBlockingDeque<Runnable> que;

    public CustomThreadPool(int poolSize) {
        this.poolSize = poolSize;
        que = new LinkedBlockingDeque<Runnable>();
        workers = new WorkerThread[poolSize];

        for(int i=0;i<poolSize;i++)
        {
            workers[i] = new WorkerThread();
            workers[i].start();
        }
    }

    public void execute(Runnable task)
    {
        synchronized (que)
        {
            que.add(task);
            que.notify();
        }
    }

     class WorkerThread extends Thread{



         public void run()
        {
            Runnable task;

            while (true)
            {
                synchronized (que)
                {
                    while(que.isEmpty())
                    {
                        try {
                            que.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    task = que.poll();

                }

                task.run();
            }
        }
    }

    public void shutDown()
    {
        System.out.println("shutting down the pool");
        for(int i=0;i<poolSize;i++)
            workers[i] = null;
    }
    public static void main(String[] args)
    {
        CustomThreadPool customThreadPool = new CustomThreadPool(2);

        for (int i = 1; i <= 5; i++)
        {
            Task2 task = new Task2("Task " + i);
            System.out.println("Created : " + task.getName());

            customThreadPool.execute(task);
        }

        customThreadPool.shutDown();
    }
}


