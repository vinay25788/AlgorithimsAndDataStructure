package concurrency;

import java.util.concurrent.CountDownLatch;

class VideoConference
{
    private CountDownLatch countDownLatch;
    VideoConference(CountDownLatch countDownLatch)
    {
        this.countDownLatch = countDownLatch;
    }

    public void start()
    {
        System.out.println(" Team member pending to join "+Thread.currentThread().getName()+" "+countDownLatch.getCount());

        countDownLatch.countDown();

        System.out.println(" welcome ");



    }
}

class Employee implements  Runnable
{

    VideoConference videoConference;

    Employee(VideoConference videoConference)
    {
        this.videoConference = videoConference;
    }

    @Override
    public void run() {
        videoConference.start();

    }
}
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        VideoConference videoConference = new VideoConference(countDownLatch);
        Employee e1 = new Employee(videoConference);
        Employee e2 = new Employee(videoConference);
        Employee e3 = new Employee(videoConference);
        Employee e4 = new Employee(videoConference);
        Employee e5 = new Employee(videoConference);



        Thread th1 = new Thread(e1);
        Thread th2 = new Thread(e2);
        Thread th3 = new Thread(e3);
        Thread th4 = new Thread(e4);
        Thread th5 = new Thread(e5);

        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" All member arrived and meeting can get started");

    }
}
