package tasks.task3;

import tasks.Tools;
import menu.Command;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static tasks.task2.FibonacciTask.showFibonacciSecuenceWithPause;

public class FibonacciExecutorTask implements Command {

    @Override
    public void execute() {
        int min = 10;
        int max = 20;
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            int set = Tools.getRandomInt(min, max);
            long pause = Tools.getRandomLong(1000, 3000);
            System.out.println("SingleThreadExecutor is running...Time: " + (pause / 1000) + " sec.");
            showFibonacciSecuenceWithPause("SingleThreadExecutor", set, pause);

        });
        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(2);
        threadPoolExecutor.submit(() -> {
            int set = Tools.getRandomInt(min, max);
            long pause = 10000;
            System.out.println("newFixedThreadPoolExecutor is running...Time: " + (pause / 1000) + " sec.");
            showFibonacciSecuenceWithPause("newFixedThreadPoolExecutor", set, pause);

        });
        ExecutorService cachedThreadPoolExecutor = Executors.newCachedThreadPool();
        cachedThreadPoolExecutor.submit(() -> {
            int set = Tools.getRandomInt(min, max);
            long pause = Tools.getRandomLong(1000, 5000);
            System.out.println("newCachedThreadPoolExecutor is running... Time: " + (pause / 1000) + " sec.");
            showFibonacciSecuenceWithPause("newCachedThreadPoolExecutor", set, pause);

        });
        try {
            Tools.await(executor);
            Tools.await(threadPoolExecutor);
            Tools.await(cachedThreadPoolExecutor);
        } catch (InterruptedException e) {
        }
    }
}

