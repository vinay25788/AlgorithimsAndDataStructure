package concurrency.concurrentcollection;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;

class Producer implements Runnable
{
    LinkedBlockingDeque<String> que;
    volatile  int number =0;
     Producer( LinkedBlockingDeque<String> que)
     {
         this.que = que;
     }

    @Override
    public void run() {

         //for(int i=0;i<5;i++)
             produce();
    }
    public void produce()
    {
       // for(int i=0;i<10;i++)
        //{
            que.add("Produced "+number++);
        //}
    }
}

class Consumer implements  Runnable
{

    LinkedBlockingDeque<String> que;
    Consumer( LinkedBlockingDeque<String> que)
    {
        this.que = que;
    }

    @Override
    public void run() {

        for(int i=0;i<5;i++)
            consume();
    }
    public void consume()
    {
        try {
            for(int i=0;i<que.size();i++)
                System.out.println(" consumed "+que.takeFirst());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class LinkedBlockingDQueueDemo {

    public static void main(String[] args) {
        LinkedBlockingDeque< String> que = new LinkedBlockingDeque<>();
        Producer[] pr = new Producer[3];
        Thread th[] = new Thread[3];
        for(int i=0;i<3;i++)
        {
            pr[i] = new Producer(que);
            th[i] = new Thread(pr[i]);
            th[i].start();
        }

        Consumer[]  cr = new Consumer[3];
        Thread[] cth = new Thread[3];
        for(int i=0;i<3;i++)
        {
            cr[i] = new Consumer(que);
            cth[i] = new Thread(cr[i]);
            cth[i].start();
        }
    }
}
