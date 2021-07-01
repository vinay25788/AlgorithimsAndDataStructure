package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class BarrierAction1 implements  Runnable
{

    @Override
    public void run() {
        System.out.println(" ACtion 1 executed successfully");
    }
}

class BarrierAction2 implements  Runnable
{

    @Override
    public void run() {
        System.out.println(" Action 2 executed successfullly");
    }
}

class Task implements  Runnable
{

    CyclicBarrier cb1;
    CyclicBarrier cb2;

    Task(CyclicBarrier cb1,CyclicBarrier cb2)
    {
        this.cb1 = cb1;
        this.cb2 = cb2;
    }

    public void runTask()
    {
        System.out.println(" waiting on the border 1 "+Thread.currentThread().getName());
        try {
            cb1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }



        try {
            System.out.println(" waiting on the border 2 "+Thread.currentThread().getName());
            cb2.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        runTask();
    }
}

public class CyclicBarrierDemo  {
    public static void main(String[] args) {
        CyclicBarrier cb1 = new CyclicBarrier(3,new BarrierAction1());
        CyclicBarrier cb2 = new CyclicBarrier(3,new BarrierAction2());

        Task tsk1 = new Task(cb1,cb2);
        Task tsk2 = new Task(cb1,cb2);
        Task tsk3 = new Task(cb1,cb2);


        Thread th1 = new Thread(tsk1,"thread 1");
        Thread th2 = new Thread(tsk2,"thread 2");
        Thread th3 = new Thread(tsk3,"thread 3");



        th1.start();
        th2.start();
        th3.start();





    }
}
