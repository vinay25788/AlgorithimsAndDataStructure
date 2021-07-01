package concurrency;


import java.util.concurrent.Phaser;

class MyPhaser extends Phaser
{
    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
         super.onAdvance(phase, registeredParties);

        switch (phase)
        {
            case 0:
                return studentArrived();
            case 1:
                return finishedFirstExcercise();
            default:
                return true;
        }
    }

    public boolean studentArrived()
    {
        System.out.println(" students arrived "+getRegisteredParties());
        return false;
    }

    public boolean finishedFirstExcercise()
    {
        System.out.println(" finished first excecise ");
        return false;
    }

}

class Student implements Runnable
{

    MyPhaser phaser;

    Student(MyPhaser phaser)
    {
        this.phaser = phaser;
    }




    @Override
    public void run() {
        System.out.println(" Arrived in exam center "+Thread.currentThread().getName());
        phaser.arriveAndAwaitAdvance();
        doExcercise1();
        phaser.arriveAndAwaitAdvance();

    }
    public void doExcercise1()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" completed excecise 1");
    }

}

public class PhaserDemo {

    public static void main(String[] args) {
        MyPhaser ph = new MyPhaser();

        Student[] students = new Student[5];
        for(int i=0;i<students.length;i++)
        {
            students[i] = new Student(ph);
            ph.register();
        }

        Thread[] th = new Thread[5];
        for(int i=0;i<students.length;i++)
        {
            th[i] = new Thread(students[i]," student "+i);
            th[i].start();
        }
    }
}
