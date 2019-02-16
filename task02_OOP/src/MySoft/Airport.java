package MySoft;

import java.util.*;

public class Airport {

  private ArrayList<Plane> planes;
  private ArrayList<Flight> flights;
  private Scanner reader;

  public Airport(Scanner scan) {
    this.planes = new ArrayList<Plane>();
    this.flights = new ArrayList<Flight>();
    this.reader = scan;
  }

  public void start() {
    startAirportPanel();
  }

  public void startAirportPanel() {

    System.out.println("Airport panel");
    System.out.println("--------------------");
    System.out.println();
    System.out.println("Choose Operation:"
        + "\n[1] Add airplane"
        + "\n[2] Add flight"
        + "\n[x] Exit");

    while (true) {
      String input = this.reader.nextLine();

      if (input.toLowerCase().equals("x")) {
        break;

      } else if (Integer.parseInt(input) == 1) {
        System.out.println("Give plane ID: ");
        String planeID = this.reader.nextLine();

        System.out.println("Give plane capacity: ");
        int planeCapacity = Integer.parseInt(this.reader.nextLine());

        System.out.println("Give plane WeightLift: ");
        int planeWeightLift = Integer.parseInt(this.reader.nextLine());
        System.out.println("Give plane Range : ");
        int planeRange = Integer.parseInt(this.reader.nextLine());
        addPlane(planeID, planeCapacity, planeWeightLift,planeRange);

      } else if (Integer.parseInt(input) == 2) {
        System.out.println("Give plane ID: ");
        String planeID = this.reader.nextLine();

        System.out.println("Give departure airport code: ");
        String departure = this.reader.nextLine();

        System.out.println("Give destination airport code: ");
        String destination = this.reader.nextLine();

        System.out.println("Give range value fromm departure to destination");
        int currentflightrange = Integer.parseInt(this.reader.nextLine());

        addFlight(planeID, departure, destination,currentflightrange);
      }

      System.out.println("Choose Operation:"
          + "\n[1] Add airplane"
          + "\n[2] Add flight"
          + "\n[x] Exit");
    }
    startFlightPanel();
  }

  public void startFlightPanel() {


    System.out.println();
    System.out.println("Flight service"
        + "\n------------");
    System.out.println();
    System.out.println("Choose Operation:"
        + "\n[1] Print planes"
        + "\n[2] Print flights"
        + "\n[3] Print plane info"
        + "\n[x] Quit");
    planes.sort((Plane p1, Plane p2)->p1.getRange()-p2.getRange());
    while (true) {
      String input = this.reader.nextLine();

      if (input.toLowerCase().equals("x")) {
        break;

      } else if (Integer.parseInt(input) == 1) {
        printPlanes();

      } else if (Integer.parseInt(input) == 2) {
        printFlights();

      } else if (Integer.parseInt(input) == 3) {
        System.out.println("Give plane ID: ");
        String planeID = this.reader.nextLine();

        printPlane(planeID);
      }
      System.out.println("Choose Operation:"
          + "\n[1] Print planes"
          + "\n[2] Print flights"
          + "\n[3] Print plane info"
          + "\n[x] Quit");
    }

  }

  public void addPlane(String planeID, int planeCapacity,int planeWeightLift,int range) {
    Plane plane = new Plane(planeID, planeCapacity, planeWeightLift,range);
    this.planes.add(plane);
  }

  public void addFlight(String id, String departure, String destination, int currentflightrange) {

    Flight flight = new Flight(getPlaneInList(id), departure, destination,currentflightrange);

    this.flights.add(flight);
  }

  public Plane getPlaneInList(String id) {
    Plane plane = null;
    for (Plane p : this.planes) {
      if (p.getID().equals(id));
      plane = p;
    }
    return plane;
  }

  public void printPlanes() {
    for (Plane p : this.planes) {
      System.out.println(p);
    }
  }

  public void printFlights() {
    for (Flight f : this.flights) {
      System.out.println(f);
    }
  }

  public void printPlane(String id) {
    for (Plane p : this.planes) {
      if (p.getID().equals(id)) {
        System.out.println(p);
      }
    }
  }
}
