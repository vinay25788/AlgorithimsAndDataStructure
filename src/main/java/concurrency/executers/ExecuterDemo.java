package concurrency.executers;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

class Task implements Runnable
{

     private String name;
     Task(String name)
     {
         this.name = name;
     }
    @Override
    public void run() {
        System.out.println(" name -->"+name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Server
{
    private ThreadPoolExecutor threadPoolExecutor;
    public Server()
    {
        System.out.println(" availabel proces "+Runtime.getRuntime().availableProcessors());
        threadPoolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(3);
        RejectedTaskController rejectedTaskController = new RejectedTaskController();

        threadPoolExecutor.setRejectedExecutionHandler(rejectedTaskController);
    }

    public void executeTask(Task task)
    {
        System.out.println(" new task has been arrived ");
        threadPoolExecutor.execute(task);
        System.out.println(" thread pool size "+threadPoolExecutor.getPoolSize());
        System.out.println(" thread server active account "+threadPoolExecutor.getActiveCount());
        System.out.println(" completed task count "+threadPoolExecutor.getCompletedTaskCount());

    }
    public void endServer()
    {
        threadPoolExecutor.shutdown();
    }
}
class RejectedTaskController implements RejectedExecutionHandler
{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("task has been rejected "+r.toString());
        System.out.println(" executor isTerminated "+executor.isTerminated());
    }
}

public class ExecuterDemo {

    public static void main(String[] args) {
        Server server = new Server();
        for(int i=0;i<10;i++)
        {
            Task tk = new Task("task "+i);
            server.executeTask(tk);
        }
        System.out.println(" end server ");
        server.endServer();
        Task task = new Task(" rejected task ");
        server.executeTask(task);


    }
}
