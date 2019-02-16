package string.application;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class ConsoleMenu {

    private Console console;
    private Map<Integer, String> menu = new LinkedHashMap<>();

    private Locale locale = new Locale("uk");
    private ResourceBundle bundle = ResourceBundle.getBundle("ConsoleMenu", locale);

    private void updateMenuLanguage() {
        menu.put(1, bundle.getString("1"));
        menu.put(2, bundle.getString("2"));
        menu.put(0, bundle.getString("0"));
    }

    public ConsoleMenu(Console console) {
        this.console = console;
        updateMenuLanguage();
    }

    public void changeMenuLang(Language language) {

        switch (language) {
            case ENGLISH:
                this.locale = new Locale("en");
                break;
            case UKRAINIAN:
                this.locale = new Locale("uk");
                break;
            default:
                this.locale = new Locale("en");
                break;
        }
        this.bundle = ResourceBundle.getBundle("ConsoleMenu", this.locale);
        updateMenuLanguage();
    }

    public void showConsoleMenu() {
        console.print("\nMENU:");
        menu.keySet().forEach(e -> console.print(e + " " + menu.get(e)));
    }

    public int getInput() {
        return console.getInput();
    }

}
