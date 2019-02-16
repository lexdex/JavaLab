package menu;

public enum MenuItem {
  START(1, "Start"), CONTINUE(2, "Continue"), EXIT(3, "Exit");

  private int id;
  private String text;

  MenuItem(int id, String text) {
    this.id = id;
    this.text = text;
  }

  public int getId() {
    return id;
  }

  public String getText() {
    return text;
  }

  public static MenuItem getItemById(int id) {
    for (MenuItem item:MenuItem.values()) {
      if (item.id == id) return item;
    }
    return null;
  }
}
