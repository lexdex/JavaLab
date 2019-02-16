package com.company;

import com.company.menu.Menu;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        URL jsonUrl = Main.class.getClassLoader().getResource("json/gems.json");
        File json;
        try {
            if (jsonUrl != null) {
                json = new File(jsonUrl.toURI());
                new Menu(json).show();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
