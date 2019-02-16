package menu;

public class ConsoleMenu {

  private Console console = new Console();

  public void start() {

    while (true) {
      showConsoleMenu();
      MenuItem menuChoice = console.getMenuInput();

      switch (menuChoice) {

        case START:
          console.print("Started");
          break;

        case CONTINUE:
          console.print("Continued");
          break;

        default:
        case EXIT:
          console.print("Exited");
          System.exit(0);
          break;
      }
    }
  }

  private void showConsoleMenu() {
    for (MenuItem item:MenuItem.values()) {
      console.print(item.getId() + ": " + item.getText());
    }
  }
}

