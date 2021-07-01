package concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

class QueueForJob {
    Semaphore semaphore;
    Queue<Integer> que = new LinkedList<>();
    static int number;

    QueueForJob() {
        semaphore = new Semaphore(3,true);
    }

    public void print() {
        try {
            semaphore.acquire();
            que.add(number++);


            System.out.println(" Thread name  " + Thread.currentThread().getName() + " " + que.remove());


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            semaphore.release();
        }

    }
}

class PrintJob implements Runnable {

    private QueueForJob queueForJob;

    PrintJob(QueueForJob queueForJob) {
        this.queueForJob = queueForJob;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++)
            queueForJob.print();
    }
}

public class SemaphoresExample {

    public static void main(String[] args) {
        QueueForJob queueForJob = new QueueForJob();

        PrintJob s1 = new PrintJob(queueForJob);
        PrintJob s2 = new PrintJob(queueForJob);
        PrintJob s3 = new PrintJob(queueForJob);
        PrintJob s4 = new PrintJob(queueForJob);

        Thread th1 = new Thread(s1);

        Thread th2 = new Thread(s2);
        Thread th3 = new Thread(s3);
        Thread th4 = new Thread(s4);
        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }


}
