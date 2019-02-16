package tasks.task2;

import tasks.Tools;
import menu.Command;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingQueueTask implements Command {
  private final int SIZE = 8;
  private BlockingQueue<String> pipe = new ArrayBlockingQueue<>(SIZE);
  private String[] stuffs = {
    "Apple",
    "Ball",
    "Soda",
    "Phone",
    "Light",
    "Fireball",
    "Gun",
    "Stick",
    "Hat",
    "Image",
    "Jam",
    "Key",
    "Lemon",
    "Map",
    "Nail",
    "Object"
  };

  @Override
  public void execute() {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    executorService.submit(this::putToPipe);
    executorService.submit(this::takeFromPipe);
    try {
      Tools.await(executorService);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("~~Stuffs in Pipe~~");
    pipe.forEach(s -> System.out.print(s + " "));
  }

  private void putToPipe() {
    try {
      for (String stuff : stuffs) {
        if (pipe.size() == SIZE) {
          System.out.println("Pipe is Full of Stuffs! Tried to put: " + stuff);
          Thread.sleep(3000);
        }
        pipe.put(stuff);
        showStuff("<- ", stuff, pipe.size());
        Thread.sleep(800);
      }

    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void takeFromPipe() {
    try {
      Thread.sleep(7000);
      for (int i = 0; i < SIZE + 2; i++) {
        if (pipe.isEmpty()) {
          System.out.println("Pipe is Empty!");
          Thread.sleep(5000);
        }
        String stuff = pipe.take();
        showStuff("->", stuff, pipe.size());
        Thread.sleep(200);
      }

    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void showStuff(String symb, String stuff, int pipeSize) {
    System.out.println(
        LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMMyyр HH:mm:ss;"))
            + " T: "
            + Thread.currentThread().getName()
            + "; "
            + symb
            + stuff
            + "; size: "
            + pipeSize);
  }
}
