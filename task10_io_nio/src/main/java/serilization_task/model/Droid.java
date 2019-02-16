package serilization_task.model;

import java.io.Serializable;

public class Droid implements Serializable {

    private String name;
    private int weaponsPower;
    private transient int weaponsAmount;
    private transient int armorAmount;

    public Droid(String name, int weaponsPower, int weaponsAmount, int armorAmount) {
        this.name = name;
        this.weaponsPower = weaponsPower;
        this.weaponsAmount = weaponsAmount;
        this.armorAmount = armorAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeaponsPower() {
        return weaponsPower;
    }

    public void setWeaponsPower(int weaponsPower) {
        this.weaponsPower = weaponsPower;
    }

    public int getWeaponsAmount() {
        return weaponsAmount;
    }

    public void setWeaponsAmount(int weaponsAmount) {
        this.weaponsAmount = weaponsAmount;
    }

    public int getArmorAmount() {
        return armorAmount;
    }

    public void setArmorAmount(int armorAmount) {
        this.armorAmount = armorAmount;
    }

    @Override
    public String toString() {
        return "Droid [" +
                "name='" + name + " " +
                ", weaponsPower=" + weaponsPower +
                ", weaponsAmount=" + weaponsAmount +
                ", armorAmount=" + armorAmount +
                ']';
    }
}
