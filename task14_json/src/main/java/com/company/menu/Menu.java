package com.company.menu;

import com.company.GemsViewer;
import com.company.comparator.GemComparator;
import com.company.parsers.GSON.GSONGemParser;
import com.company.parsers.jackson.JACKSONGemParser;
import com.company.parsers.json_simple.JSONSimpleGemParser;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Map<String, String> menu;
    private Map<String, Command> methods;
    private Scanner input;

    private File json;

    public Menu(File json) {
        this.json = json;
        input = new Scanner(System.in);
        menu = new LinkedHashMap<>();
        methods = new HashMap<>();
        initMenu();

    }

    private void initMenu() {
        menu.put("1", "Get gems with JSON-Simple");
        menu.put("2", "Get gems with GSON");
        menu.put("3", "Get gems with JACKSON");

        methods.put("1", new GemsViewer(new JSONSimpleGemParser(), new GemComparator(), json));
        methods.put("2", new GemsViewer(new GSONGemParser(), new GemComparator(), json));
        methods.put("3", new GemsViewer(new JACKSONGemParser(), new GemComparator(), json));

    }

    public void show() {
        String userInput;
        do {
            System.out.println("\n\t\t~~MENU~~");
            menu.forEach((k, v) -> System.out.println(k + " - " + v));
            System.out.println("Q - Quit");
            userInput = input.next();
            try {
                methods.get(userInput).execute();
            } catch (NullPointerException e) {/*ignore*/}
        } while (!userInput.equalsIgnoreCase("Q"));
    }
}