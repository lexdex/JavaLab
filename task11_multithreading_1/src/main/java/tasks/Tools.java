package tasks;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Tools {

    public static int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public static long getRandomLong(int min, int max) {
        Random random = new Random();
        return random.longs(min, max).limit(1).findFirst().orElse(min);

    }

    public static void await(ExecutorService executor) throws InterruptedException {
        executor.shutdown();
        while (!executor.awaitTermination(24L, TimeUnit.HOURS)) {
            System.out.println("Not yet. Still waiting for termination");
        }
    }
}
