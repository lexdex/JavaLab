package menu;
import java.util.Scanner;

public class Console {

  private Scanner sc;

  public Console() {
    sc = new Scanner(System.in, "UTF-8");
  }

  public final void print(final String text) {
    System.out.println(text);
  }

  public final void print(final int text) {
    System.out.println(text);
  }

  public final int getInput() {
    return sc.nextInt();
  }

  public final MenuItem getMenuInput() {
    return MenuItem.getItemById(sc.nextInt());
  }
}

