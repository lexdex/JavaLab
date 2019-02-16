package tasks.task5;


import tasks.Tools;
import menu.Command;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SleepyTask implements Command {


    @Override
    public void execute() {
        ScheduledFuture<?> f;
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
        System.out.println("Enter number of sleeping tasks:");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        for (int i = 1; i <= input; i++) {
            String name = "Task #" + i;
            f = executor.schedule(() -> {
                System.out.println(name + " Woke Up in " + "Thread: ["
                        + Thread.currentThread().getName() + "] and finished.");
            }, Tools.getRandomInt(1, 10), TimeUnit.SECONDS);
            long delay = f.getDelay(TimeUnit.SECONDS);
            System.out.println(name + " delay: " + delay + " sec.");

        }
        try {
            Tools.await(executor);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("~~SleepyTask finished~~");
    }
}
