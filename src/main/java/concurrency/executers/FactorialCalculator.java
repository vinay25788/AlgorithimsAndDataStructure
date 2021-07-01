package concurrency.executers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class FactorialCalculator implements Callable<Integer> {

    private Integer number;

    FactorialCalculator(Integer number)
    {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int result = 1;

        if(number == 1 || number ==0)
            return 1;
        else
        {
            for(int i=2;i<number;i++)
            {
                result *= i;
                Thread.sleep(100);
            }
            System.out.println(" result --->"+result);
        }

        return result;
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(2);

        List<Future<Integer>>  resultList = new ArrayList<>();
        Random random = new Random();
        for(int i=0;i<10;i++)
        {
            Integer in = random.nextInt(10);
            FactorialCalculator factorialCalculator = new FactorialCalculator(in);
            Future<Integer> result = executor.submit(factorialCalculator);
            resultList.add(result);
        }

        do {
            System.out.println(" completed count "+executor.getCompletedTaskCount());
            for(int i=0;i<10;i++)
            {
                Future<Integer> res = resultList.get(i);
                System.out.format( "Main: task %d: %s\n",i,res.isDone());
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (executor.getCompletedTaskCount()<resultList.size());

        System.out.println(" Main result ");
        for(int i=0;i<resultList.size();i++)
        {
            Future<Integer> res = resultList.get(i);
            try {
                int number = res.get();
                System.out.format(" main Task: %d %s ",i,number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}























