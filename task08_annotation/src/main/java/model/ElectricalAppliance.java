package model;

import annotation.Description;

public class ElectricalAppliance {

    @Description(text = "name of appliances")
    private String name;

    @Description(text = "power consumption counter")
    private int powerConsumption;

    @Description
    private boolean isTurnedOn;

    public ElectricalAppliance(String name, int powerConsumption) {
        this.name = name;
        this.powerConsumption = powerConsumption;
    }

    public boolean plugIntoOutlet() {
        return this.isTurnedOn = true;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }


    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    @Override
    public String toString() {
        return "name = '" + name + '\'' +
                ", power consumption = " + powerConsumption +
                ", turned on = " + isTurnedOn;
    }
}
