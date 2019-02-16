package com.company.view;

import com.company.model.Student;
import com.company.service.StudentService;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.*;

public class MyView {

  private Map<String, String> menu;
  private Map<String, Printable> methodsMenu;
  private static Scanner input = new Scanner(System.in);

  public MyView() {
    menu = new LinkedHashMap<>();
    methodsMenu = new LinkedHashMap<>();
    menu.put("11", "  11 - Create for Students");
    menu.put("12", "  12 - Delete for Students");
    menu.put("13", "  13 - Get all from Students");
    menu.put("Q", "   Q - exit");

    methodsMenu.put("11", this::StudentService::create);
    methodsMenu.put("12", this::StudentService::delete);
    methodsMenu.put("13", this::StudentService::getAllStudents);
  }


  private void outputMenu() {
    System.out.println("\nMENU:");
    for (String key : menu.keySet()) {
      if (key.length() == 1) {
        System.out.println(menu.get(key));
      }
    }
  }

  private void outputSubMenu(String fig) {

    System.out.println("\nSubMENU:");
    for (String key : menu.keySet()) {
      if (key.length() != 1 && key.substring(0, 1).equals(fig)) {
        System.out.println(menu.get(key));
      }
    }
  }

  public void show() {
    String keyMenu;
    do {
      outputMenu();
      System.out.println("Please, select menu point.");
      keyMenu = input.nextLine().toUpperCase();

      if (keyMenu.matches("^\\d")) {
        outputSubMenu(keyMenu);
        System.out.println("Please, select menu point.");
        keyMenu = input.nextLine().toUpperCase();
      }

      try {
        methodsMenu.get(keyMenu).print();
      } catch (Exception e) {
      }
    } while (!keyMenu.equals("Q"));
  }
}
