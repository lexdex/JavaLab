package tasks.task1;

import tasks.Tools;
import menu.Command;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockGrail implements Command {
  private Lock grail = new ReentrantLock();

  @Override
  public void execute() {
    System.out.println("Templar, Priest, Peasant with Holy Grail ");
    Scanner input = new Scanner(System.in);
    while (true) {
      try {
        System.out.println("Your choice:");
        String mode = input.next();
        switch (Integer.valueOf(mode)) {
          case 1:
            executeGrailLockMode();
            return;
          case 2:
            executeDifferentLockMode();
            return;
        }
      } catch (IllegalArgumentException e) {
        /*ignore*/
      }
    }
  }

  private void executeGrailLockMode() {
    ExecutorService executor;
    for (int i = 0; i < 3; i++) {
      executor = Executors.newFixedThreadPool(3);
      executor.submit(this::templarAttempt);
      executor.submit(this::priestAttempt);
      executor.submit(this::peasantAttempt);
      try {
        Tools.await(executor);
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private void executeDifferentLockMode() {
    ExecutorService executorService;
    executorService = Executors.newCachedThreadPool();
    executorService.submit(this::ownLockMethod1);
    executorService.submit(this::ownLockMethod2);
    executorService.submit(this::ownLockMethod3);
    try {
      Thread.sleep(1500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    try {
      Tools.await(executorService);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void templarAttempt() {
    String templar = "Templar";
    grail.lock();
    getGrail(templar);
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    lostGrail(templar);
    grail.unlock();
  }

  private void priestAttempt() {
    String priest = "Priest";
    grail.lock();
    getGrail(priest);
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    lostGrail(priest);
    grail.unlock();
  }

  private void peasantAttempt() {
    String peasant = "Peasant";
    grail.lock();
    getGrail(peasant);
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    lostGrail(peasant);
    grail.unlock();
  }

  private void lostGrail(String person) {
    System.out.println("The " + person + " has lost it...");
    System.out.println("------------------------------------");
  }

  private void getGrail(String person) {
    System.out.println("The " + person + " has the Holy Grail");
  }

  private void ownLockMethod1() {
    Lock lock = new ReentrantLock();
    lock.lock();
    showExecution(1);
    lock.unlock();
  }

  private void ownLockMethod2() {
    Lock lock = new ReentrantLock();
    lock.lock();
    showExecution(2);
    lock.unlock();
  }

  private void ownLockMethod3() {
    Lock lock = new ReentrantLock();
    lock.lock();
    showExecution(3);
    lock.unlock();
  }

  private void showExecution(int m) {
    System.out.println(
        "time:"
            + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            + "; T: "
            + Thread.currentThread().getName()
            + " method "
            + m);
  }
}
