package tasks.task4;


import tasks.Tools;
import menu.Command;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SumOfFibonacci implements Command {
    @Override
    public void execute() {
        ExecutorService service = Executors.newFixedThreadPool(3);
        long sum1 = 0;
        long sum3 = 0;
        long sum2 = 0;
        try {
            sum1 = service.submit(new FibonacciSumCallable("Thread 1")).get();
            sum2 = service.submit(new FibonacciSumCallable("Thread 2")).get();
            sum3 = service.submit(new FibonacciSumCallable("Thread 3")).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        try {
            Tools.await(service);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread 1 sequence sum: " + sum1);
        System.out.println("Thread 2 sequence sum: " + sum2);
        System.out.println("Thread 3 sequence sum: " + sum3);
    }
}
