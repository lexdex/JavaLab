package menu;

import tasks.task1.PingPongGame;
import tasks.task2.FibonacciTask;
import tasks.task3.FibonacciExecutorTask;
import tasks.task4.SumOfFibonacci;
import tasks.task5.SleepyTask;
import tasks.task6.CriticalTask;
import tasks.task7.PipeCommunication;

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
        menu.put("1", "Ping-Pong Game");
        menu.put("2", "MultiThread Fibonacci Sequence");
        menu.put("3", "Run Fibonacci Sequence Using Different Executors");
        menu.put("4", "Find Sum of Random Fibonacci Sequence Using Callable");
        menu.put("5", "Run Task to Wait/Sleep");
        menu.put("6", "Run Synchronisation Task");
        menu.put("7", "Run Pipes Communication Task");

        methods.put("1", new PingPongGame());
        methods.put("2", new FibonacciTask());
        methods.put("3", new FibonacciExecutorTask());
        methods.put("4", new SumOfFibonacci());
        methods.put("5", new SleepyTask());
        methods.put("6", new CriticalTask());
        methods.put("7", new PipeCommunication());
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
            } catch (NullPointerException e) {/*ignore*/}
        } while (!userInput.equalsIgnoreCase("Q"));
    }
}