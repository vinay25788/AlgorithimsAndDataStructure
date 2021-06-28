package concurrency;


class Printer
{
    static int number =0;
    public void print(int remainder) {
        while (number < 10) {
            synchronized (this) {
                while (number%2 !=  remainder) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + number);
                number++;
                this.notify();
            }

        }
    }

}

public class PrintOddEvenNumberUsingTwoThread implements Runnable {
    int number ;
    Printer printer;

    PrintOddEvenNumberUsingTwoThread(int number,Printer printer)
    {
        this.number = number;
        this.printer = printer;
    }

    @Override
    public void run() {

        printer.print(number);

    }


    public static void main(String[] args) {
        Printer pr = new Printer();
        PrintOddEvenNumberUsingTwoThread t1 = new PrintOddEvenNumberUsingTwoThread(0,pr);
        PrintOddEvenNumberUsingTwoThread t2 = new PrintOddEvenNumberUsingTwoThread(1, pr);

        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t2);
        th1.start();
        th2.start();
    }

}
