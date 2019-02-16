package tasks.task2;

import menu.Command;
import tasks.Tools;


import java.util.concurrent.TimeUnit;

public class FibonacciTask implements Command {


    @Override
    public void execute() {
        System.out.println("~~FibonacciTask Started~~");
        int min = 10;
        int max = 20;

        for (int i = 1; i <= 3; i++) {
            int set = Tools.getRandomInt(min, max);
            long pause = Tools.getRandomLong(1000, 3000);
            String name = "Thread " + i;
            Thread t = new Thread(() -> {
                showFibonacciSecuenceWithPause(name, set, pause);
            });
            t.start();
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("~~FibonacciTask Finished~~");
    }

    public static void showFibonacciSecuenceWithPause(String name, int set, Long pause) {
        try {
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " sequence: " + new FibonacciCreator(set).getFibonacciSequence());
    }
}
