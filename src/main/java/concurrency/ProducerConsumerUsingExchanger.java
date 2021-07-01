package concurrency;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Exchanger;

class ProducerEx implements Runnable {
    List<String> buffer;
   private final Exchanger<List<String>> exchanger;

    ProducerEx(List<String> buffer, Exchanger<List<String>> exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }


    public void produce() {
        for (int i = 0; i < 10; i++) {
            System.out.println("produced " + i);
            buffer.add("" + i);
        }

        try {
             buffer = exchanger.exchange(buffer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        produce();
    }
}

class ConsumerEx implements Runnable {
    List<String> buffer;
    private final Exchanger<List<String>> exchanger;

    ConsumerEx(List<String> buffer, Exchanger<List<String>> exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }


    public void consume() {


        try {
             buffer = exchanger.exchange(buffer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(buffer);
        System.out.println("size "+buffer.size());
        for (int i = 0; i < buffer.size(); i++)
        {
            System.out.println("consumer " + buffer.get(i));
        }
        buffer = null;

    }

    @Override
    public void run() {
        consume();
    }
}

public class ProducerConsumerUsingExchanger {
    public static void main(String[] args) {
        List<String> buffer = new LinkedList<>();
        List<String> buffer2 = new LinkedList<>();
        Exchanger<List<String>> exchanger = new Exchanger<>();

        ProducerEx pr = new ProducerEx(buffer, exchanger);
        ConsumerEx cr = new ConsumerEx(buffer2, exchanger);

        Thread th = new Thread(pr, "Producer ");
        Thread cth = new Thread(cr, "consumer");
        th.start();
        ;
        cth.start();
    }
}
