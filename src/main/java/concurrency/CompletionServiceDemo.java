package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class MultiplyTask implements Callable<Integer> {
    private int a;
    private int b;
    private String name;

    MultiplyTask(String name, int a, int b) {
        this.a = a;
        this.b = b;
        this.name = name;
    }


    @Override
    public Integer call() {
        System.out.println("started " + name);
        int result = a * b;
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" finished " + name);
        return result;
    }
}

public class CompletionServiceDemo {
    public static void main(String[] args) {
        MultiplyTask tsk1 = new MultiplyTask("task 1", 2, 4);
        MultiplyTask tsk2 = new MultiplyTask("task 2", 3, 5);
        MultiplyTask tsk3 = new MultiplyTask(" task 3 ", 5, 6);
        ExecutorService service = Executors.newFixedThreadPool(3);
        Executor pool = Executors.newFixedThreadPool(4);
        CompletionService<Integer> excutorCompletionService = new ExecutorCompletionService<>(service);
        List<Future<Integer>> results = new ArrayList<>();
        results.add(excutorCompletionService.submit(tsk1));
        results.add(excutorCompletionService.submit(tsk2));
        results.add(excutorCompletionService.submit(tsk3));

        for (int i = 0; i < results.size(); i++) {
            try {
                Future<Integer> res = excutorCompletionService.take();
                System.out.println(" result of "+res.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }

        service.shutdown();
    }
}
