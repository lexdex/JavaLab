package task3;

public class DroidAirportMain {

  public static void main(String [] args) {
    Droid C3PO = new DroidT("C3PO", 132, 13);
    Droid R2D2 = new DroidMech("R2D2");
    DroidShip<Droid> ship = new DroidShip();
    ship.add(C3PO);
    ship.add(R2D2);
    ((DroidT) C3PO).translate(C3PO);
  }
}
