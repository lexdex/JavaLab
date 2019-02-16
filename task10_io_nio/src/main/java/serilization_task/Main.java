package serilization_task;

import serialization.io.Serialization;
import serialization.model.Droid;
import serialization.model.Ship;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Droid> droids = new ArrayList<>();
        droids.add(new Droid("R2D2NEW", 100, 300, 900));
        droids.add(new Droid("C3POOLD", 200, 200, 400));

        Ship ship = new Ship(droids);

        Serialization.serialize(ship, "shipwithdroids.dat");

        Ship receivedShip = Serialization.deserialize("shipwithdroids.dat");
        System.out.println(receivedShip);

    }
}
