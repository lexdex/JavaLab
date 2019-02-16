package menu;


import parser.dom.DOMDocumentCreator;
import parser.dom.DOMParser;
import parser.dom.TourDOMParser;
import parser.sax.TourSAXParser;

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
        menu.put("1","Create Document");
        menu.put("2", "Get Hotels with DOM");
        menu.put("3", "Get Hotels with SAX");
        methods.put("1", new DOMParser());
        methods.put("2", new TourDOMParser());
        methods.put("3", new TourSAXParser());

    }

    public void show() {
        String userInput;
        do {
            System.out.println("\n\t\t++MENU++");
            menu.forEach((k, v) -> System.out.println(k + " - " + v));
            System.out.println("Q - Quit");
            userInput = input.next();
            try {
                methods.get(userInput).execute();
            } catch (NullPointerException e) {
        System.out.println("NullPointerExeption!");
                        }
        } while (!userInput.equalsIgnoreCase("Q"));
    }
}