package task3;

import java.util.ArrayList;
import java.util.List;

public class DroidShip <T extends Droid> {
  private List<Droid> droids;
  T pilot;


  public DroidShip () {
    droids = new ArrayList<>();
  }

  public <E extends Droid> void add (E element) {

    droids.add(element);
  }


  public List <? extends Droid> getDroids() {
    return droids;
  }

  public void showDroids() {
    for(Droid droid : droids) {
      System.out.print(droid + " ");
    }
  }

  public void addtoList(List<? extends Droid> droidsList) {
    droids.addAll(droidsList);
  }

  public List<? extends Droid> find(T found) {
    List<? extends Droid> foundDroids;
    List<Droid> results = new ArrayList<>();

    for(Droid droid : droids) {
      if(droid == found) {
        results.add(droid);
      }
    }

    foundDroids = results;

    return foundDroids;
  }

  public List <Droid> find(List<T> desiredDroids) {
    List<Droid> results = new ArrayList<>();

    for(Droid droid : droids) {
      for(Droid searched : desiredDroids) {
        if (droid == searched) {
          results.add(droid);
        }
      }
    }

    return results;
  }

}
