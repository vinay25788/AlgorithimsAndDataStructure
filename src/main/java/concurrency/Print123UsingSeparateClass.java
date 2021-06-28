package concurrency;

class PrintNumber
{
    static int number;

    public void print(int remainder)
    {
        while(number <15)
        {
            synchronized (this)
            {
                while(number % 3 != remainder)
                {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+" "+number);
                number++;
                this.notifyAll();
            }
        }
    }
}
public class Print123UsingSeparateClass implements Runnable{

    PrintNumber pr;
    int remainder;

    Print123UsingSeparateClass( int remainder,PrintNumber pr)
    {
        this.remainder = remainder;
        this.pr = pr;
    }

    @Override
    public void run() {
        pr.print(remainder);
    }

    public static void main(String[] args) {
        PrintNumber pr = new PrintNumber();
        Print123UsingSeparateClass t1 = new Print123UsingSeparateClass(0,pr);
        Print123UsingSeparateClass t2 = new Print123UsingSeparateClass(1,pr);

        Print123UsingSeparateClass t3 = new Print123UsingSeparateClass(2,pr);
        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t2);
        Thread th3 = new Thread(t3);
        th1.start();
        th2.start();
        th3.start();
    }
}
