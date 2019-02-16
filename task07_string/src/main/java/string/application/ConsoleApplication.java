package string.application;

public class ConsoleApplication {

    private ConsoleMenu menu;

    public ConsoleApplication(ConsoleMenu menu) {
        this.menu = menu;
    }

    public void start() {
        while (true) {

            menu.showConsoleMenu();
            int menuChoice = menu.getInput();

            switch (menuChoice) {
                case 1:
                    menu.changeMenuLang(Language.UKRAINIAN);
                    break;
                case 2:
                    menu.changeMenuLang(Language.ENGLISH);
                    break;
                case 0:
                default:
                    System.exit(0);
            }
        }
    }
}
