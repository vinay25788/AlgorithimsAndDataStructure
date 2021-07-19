package concurrency.concurrentcollection.practice;

import java.util.concurrent.LinkedBlockingDeque;

class Task implements Runnable {

    private String name;
    Task(String name)
    {
        this.name = name;
    }

    public String getName() {

        return name;
    }



    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class WorkerThread extends Thread {

    LinkedBlockingDeque<Runnable> que;

    WorkerThread(LinkedBlockingDeque<Runnable> que) {
        this.que = que;
    }

    public void run() {
        Task task;
        while (true) {
            synchronized (que) {
                while (que.isEmpty()) {
                    try {
                        que.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                task = (Task) que.poll();
                System.out.println(" consumed "+task.getName());
            }
            task.run();
        }
    }
}

public class CustomThreadPool {

    private int poolSize;
    LinkedBlockingDeque<Runnable> que;
    WorkerThread[] workes;

    CustomThreadPool(int poolSize, LinkedBlockingDeque<Runnable> que) {
        this.poolSize = poolSize;
        this.que = que;
        workes = new WorkerThread[poolSize];
        for (int i = 0; i < poolSize; i++) {
            workes[i] = new WorkerThread(que);
            workes[i].start();
        }
    }

    public void execute(Task task) {
        synchronized (que) {
            System.out.println(" added task "+ task.getName());
            que.add(task);
            que.notifyAll();
        }
    }

    public void shutDown() {
        for (int i = 0; i < poolSize; i++)
            workes[i] = null;
    }

    public static void main(String[] args) {
        LinkedBlockingDeque<Runnable> que = new LinkedBlockingDeque<>();
        CustomThreadPool cus = new CustomThreadPool(3, que);
        Task[] tasks = new Task[6];
        for (int i = 0; i < 6; i++) {
            tasks[i] = new Task("task "+i);
            cus.execute(tasks[i]);
        }

        cus.shutDown();
    }
}
