package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {
    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    public static void main(String[] args) {




            new Thread(() -> {
                synchronized(lock1){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized(lock2){}

                }
            }).start();

            new Thread(() -> {
                synchronized(lock2){
                    synchronized(lock1){}
                }
            }).start();
        int id =5;
       // CompletableFuture<String> user = CompletableFuture.supplyAsync(()-> UserService.getUser(id)).orTimeout(4, TimeUnit.MILLISECONDS).completeOnTimeout(10,2, TimeUnit.MILLISECONDS);

        //CompletableFuture.allOf((user)).join();


    }

    public String getUser(int a)
    {
        return "vinay";
    }
}

class UserService
{
    public static String getUser(int id)
    {
        return "Vinay";
    }
}
