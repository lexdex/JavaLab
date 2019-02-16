package task3;

public abstract class Droid {
  private int armor;
  private String model;

  public Droid(String droidName) {
    model = droidName;
  }

  public Droid(String droidName, int droidArmor) {
    model = droidName;
    armor = droidArmor;
  }

  public abstract String speak();


  public void setArmor(int newArmor) {
    armor = newArmor;
  }

  public int getArmor() {
    return armor;
  }

  @Override
  public String toString() {
    return model;
  }

  public abstract void work();

}
