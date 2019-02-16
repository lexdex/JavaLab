package MySoft;
import java.lang.*;

public class Flight {
  private String departure;
  private String destination;
  private int currentflightrange;
  private Plane plane;

  public Flight(Plane plane, String departure, String destination,int currentflightrange){
    this.departure = departure;
    this.destination = destination;
    this.currentflightrange=currentflightrange;
    this.plane = plane;
  }

  @Override
  public String toString(){
    return this.plane.toString() + " (" + this.departure + "-" + this.destination +"-"+this.currentflightrange+ ")";
  }

}