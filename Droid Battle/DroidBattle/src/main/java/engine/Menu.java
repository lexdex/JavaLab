package engine;

import manager.DroidFactory;

import java.util.Scanner;

public class Menu {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public int createStartMenu() {
        System.out.println(ANSI_GREEN + "This is your daily dose of war!");
        System.out.println("Choose what you want:\n" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "\t1. Start Battle");
        System.out.println("\t2. About developers");
        System.out.println("\t3. Quit\n" + ANSI_RESET);
        System.out.print(ANSI_GREEN + "Print your massage here: " + ANSI_RESET);
        int result = Integer.parseInt(scanner.nextLine());
        System.out.println();
        return result;
    }

    public int startBattleMenu() {
        System.out.println(ANSI_CYAN + "Lets crash some engine!!!\n" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "\t1. Simple attack");
        System.out.println("\t2. Super attack");
        System.out.println("\t3. Surrender" + ANSI_RESET);
        System.out.print(ANSI_GREEN + "Print your massage here: " + ANSI_RESET);
        int result = Integer.parseInt(scanner.nextLine());
        System.out.println();
        return result;
    }

    public int chooseDroidMenu() {
        System.out.println(ANSI_CYAN + "Choose your droid:\n" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "\t1. IG100MagnaGuard");
        System.out.println("\t2. Droideka");
        System.out.println("\t3. BXDroidCommando");
        System.out.println("\t4. KSDroidSecurity");
        System.out.println("\t5. Random Droid\n" + ANSI_RESET);
        System.out.print(ANSI_GREEN + "Print your massage here: " + ANSI_RESET);

        int result = Integer.parseInt(scanner.nextLine());
        System.out.println();

        return result;
    }

    public int chooseEnemyMenu() {
        System.out.println(ANSI_CYAN + "Choose your enemy:\n" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "\t1. IG100MagnaGuard");
        System.out.println("\t2. Droideka");
        System.out.println("\t3. BXDroidCommando");
        System.out.println("\t4. KSDroidSecurity");
        System.out.println("\t5. Random Droid\n" + ANSI_RESET);
        System.out.print(ANSI_GREEN + "Print your massage here: " + ANSI_RESET);

        int result = Integer.parseInt(scanner.nextLine());
        System.out.println();

        return result;
    }
}
