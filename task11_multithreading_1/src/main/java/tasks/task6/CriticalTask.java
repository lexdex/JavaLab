package tasks.task6;

import menu.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CriticalTask implements Command {
    private final Object commonMonitor = new Object();

    @Override
    public void execute() {
        System.out.println("Choose mode:");
        System.out.println("1 - Critical Synchronization mode:");
        System.out.println("2 - Normal Synchronization mode:");
        Scanner scanner = new Scanner(System.in);
        boolean isChosen = false;
        do {
            String mode = scanner.next();
            try {
                isChosen = selectMode(mode);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect Input! Try again");
            }
        } while (!isChosen);
    }

    synchronized
    private boolean selectMode(String mode) {
        switch (Integer.parseInt(mode)) {
            case 1:
                runSynchronizedTasks();
                return true;
            case 2:
                runDifferentSynchronizedTasks();
                return true;
            default:
                System.out.println("Incorrect Input! Try again");
                return false;
        }
    }

    private void runSynchronizedTasks() {
        List<Thread> threads = new ArrayList<>();
        threads.add(new Thread(this::commonSynchronizedMethod1, "SynchronizedThread 1"));
        threads.add(new Thread(this::commonSynchronizedMethod2, "SynchronizedThread 2"));
        threads.add(new Thread(this::commonSynchronizedMethod3, "SynchronizedThread 3"));
        startAndJoinThreads(threads);
    }

    private void runDifferentSynchronizedTasks() {
        List<Thread> threads = new ArrayList<>();
        threads.add(new Thread(this::individualSynchronizedMethod1, "Thread 1"));
        threads.add(new Thread(this::individualSynchronizedMethod2, "Thread 2"));
        threads.add(new Thread(this::individualSynchronizedMethod3, "Thread 3"));
        startAndJoinThreads(threads);
    }

    private void startAndJoinThreads(List<Thread> threads) {
        threads.forEach(Thread::start);
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) { /*ignore*/}
        }
    }

    private void commonSynchronizedMethod1() {
        synchronized (commonMonitor) {
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Common Synchronized Method 1 in " + Thread.currentThread().getName() + " is running...");
            System.out.println("Common Synchronized Method 1 in  " + Thread.currentThread().getName() + " finished");
        }
    }

    private void commonSynchronizedMethod2() {
        synchronized (commonMonitor) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Common Synchronized Method 2 in " + Thread.currentThread().getName() + " is running...");
            System.out.println("Common Synchronized Method 2 in " + Thread.currentThread().getName() + "  finished");
        }
    }

    private void commonSynchronizedMethod3() {
        synchronized (commonMonitor) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Common Synchronized Method 3 in " + Thread.currentThread().getName() + " is running...");
            System.out.println("Common Synchronized Method 3 in " + Thread.currentThread().getName() + " finished");
        }
    }

    private void individualSynchronizedMethod1() {
        Object individualMonitor = new Object();
        synchronized (individualMonitor) {
            System.out.println("Individual Synchronized Method 1 in " + Thread.currentThread().getName());
            System.out.println("Individual Synchronized Method 1 in " + Thread.currentThread().getName() + " finished");
        }
    }

    private void individualSynchronizedMethod2() {
        Object individualMonitor = new Object();
        synchronized (individualMonitor) {
            System.out.println("Individual Synchronized Method 2 in " + Thread.currentThread().getName());
            System.out.println("Individual Synchronized Method 2 in " + Thread.currentThread().getName() + " finished");
        }
    }

    private void individualSynchronizedMethod3() {
        Object individualMonitor = new Object();
        synchronized (individualMonitor) {
            System.out.println("Individual Synchronized Method 3 in " + Thread.currentThread().getName());
            System.out.println("Individual Synchronized Method 3 in " + Thread.currentThread().getName() + " finished");
        }
    }
}
