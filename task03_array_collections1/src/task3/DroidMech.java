package novosad;
import java.util.List;

public class DroidMech extends Droid {
  int skill;

  public DroidMech(final String model,
      final int armor,
      final int skill) {
    super(model, armor);
    this.skill = skill;
  }

  public DroidMech(final String model, final int skill) {
    super(model);
    this.skill = skill;
  }

  public DroidMech(final String model) {
    super(model);
  }

  public void work() {
    System.out.print("Hard work");
  }

  public <T extends Droid> void repair(T droid) {
    droid.setArmor(100);
    System.out.print("Droid " + droid.toString() +
        " was successfully repaired");
  }

  public void repair(DroidShip<? extends Droid> droidShip) {
    List<? extends Droid> repairedDroids = droidShip.getDroids();

    for(Droid droid : repairedDroids) {
      if(droid.getArmor() < 100) {
        droid.setArmor(100);
        System.out.println("Droid " + droid.toString() +
            " was successfully repaired");
      }
    }

    droidShip.addtoList(repairedDroids);
  }

  public String speak() {
    return new String("Hi am droid");
  }


}


