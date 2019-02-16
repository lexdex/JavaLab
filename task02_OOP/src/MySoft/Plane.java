package MySoft;

public class Plane {
  private String planeID;
  private int capacity;
  private int weightLift;
  private int range;

  public Plane(String planeID, int capacity, int weightLift,int range){
    this.planeID = planeID;
    this.capacity = capacity;
    this.weightLift=weightLift;
    this.range=range;
  }

  public String getID(){
    return this.planeID;
  }

  public int getCapacity(){
    return this.capacity;
  }
  public int getWeightLift(){
    return this.weightLift;
  }
  public int getRange(){
    return this.range;
  }

  @Override
  public String toString(){
    return this.planeID + " (" + this.capacity + " ppl"+" "+this.weightLift+" "+this.range+")";
  }

}