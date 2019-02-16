package tasks;

import menu.Command;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MedicalClinic implements Command {
  private ReadWriteLock lock = new ReentrantReadWriteLock();
  private String nextPatient;
  private String[] names = {"Superman", "Batman", "Spiderman", "Aquaman", "Ironman", "Thor"};
  private Queue<String> queueToTheDoctor = new LinkedList<>(Arrays.asList(names));
  private List<Visitor> visitors = new ArrayList<>();
  private Lock writeLock = lock.writeLock();
  private Lock readLock = lock.readLock();

  @Override
  public void execute() {
    System.out.println("\n~~Medical Clinic~~");
    ExecutorService executor = Executors.newSingleThreadExecutor();
    for (String name : names) {
      visitors.add(new Visitor(name));
    }
    visitors.forEach(Thread::start);
    executor.submit(this::callTheVisitor);
    executor.shutdown();
  }

  private void callTheVisitor() {
    try {
      Thread.sleep(1000);
      while (!queueToTheDoctor.isEmpty()) {
        writeLock.lock();
        nextPatient = queueToTheDoctor.poll();
        System.out.println("-----------------------------------------");
        System.out.println("next patient is: " + nextPatient);
        System.out.println("-----------------------------------------");
        writeLock.unlock();
        Thread.sleep(2000);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("No patients left.");
  }

  class Visitor extends Thread {
    private String name;

    Visitor(String name) {
      this.name = name;
    }

    @Override
    public void run() {
      while (true) {
        readLock.lock();
        try {
          if (name.equalsIgnoreCase(nextPatient)) {
            System.out.println(name + ": it's my turn!!");
            readLock.unlock();
            return;
          } else {
            System.out.println(name + ": still waiting...");
          }
          Thread.sleep(2500);
          readLock.unlock();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
