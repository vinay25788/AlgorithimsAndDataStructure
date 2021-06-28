package concurrency;

import java.util.LinkedList;
import java.util.List;

class Producer implements  Runnable
{
    Object obj;
    List<Integer> sharedQueue;
    static int number =0;
    Producer(List<Integer> sharedQueue,Object obj)
    {
        this.sharedQueue = sharedQueue;
        this.obj = obj;
    }

    @Override
    public void run() {

        while (number < 30)
            synchronized (obj) {
                while (sharedQueue.size() == 10) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("produced " + " " + number);
                sharedQueue.add(number++);
                obj.notifyAll();
            }
    }
    }


class Consumer implements  Runnable
{
    Object obj;
    List<Integer> shareQueue;
    Consumer(Object obj, List<Integer> shareQueue)
    {
        this.obj = obj;
        this.shareQueue = shareQueue;
    }

    @Override
    public void run()
    {
        while(true) {
            synchronized (obj) {
                while (shareQueue.isEmpty()) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("consumer " + shareQueue.remove(0));
                obj.notifyAll();
            }
        }
    }
}
public class ProducerConsumerProblem {
    public static void main(String[] args) {
        Object obj = new Object();
        List<Integer> sharedQueue = new LinkedList<>();
        Producer pr = new Producer(sharedQueue,obj);
        Consumer cr = new Consumer(obj,sharedQueue);
        Thread pth = new Thread(pr);
        Thread cth = new Thread(cr);
        pth.start();
        cth.start();
    }
}
