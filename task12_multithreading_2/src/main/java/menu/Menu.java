package menu;

import tasks.MedicalClinic;
import tasks.task1.LockGrail;
import tasks.task2.BlockingQueueTask;
import tasks.task3.MyLock;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
  private Map<String, String> menu;
  private Map<String, Command> methods;
  private Scanner input;

  public Menu() {
    input = new Scanner(System.in);
    menu = new LinkedHashMap<>();
    methods = new HashMap<>();
    initMenu();
  }

  private void initMenu() {
    menu.put("1", "Medical Clinic Task");
    menu.put("2", "Lock Task");
    menu.put("3", "BlockQueue Taks");

    methods.put("1", new MedicalClinic());
    methods.put("2", new LockGrail());
    methods.put("3", new BlockingQueueTask());
  }

  public void show() {
    String userInput;
    do {
      System.out.println("\n\t\t-++MENU++-");
      menu.forEach((k, v) -> System.out.println(k + " - " + v));
      System.out.println("Q - Quit");
      userInput = input.next();
      try {
        methods.get(userInput).execute();
      } catch (NullPointerException e) {
        /*ignore*/
      }
    } while (!userInput.equalsIgnoreCase("Q"));
  }
}
