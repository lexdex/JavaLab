package droid;

public abstract class Droid {
    private int health;
    private int attack;
    private int armorValue;
    private boolean alive;
    private boolean armor;

    protected Droid(int health, int attack, int armorValue, boolean alive, boolean armor) {
        this.health = health;
        this.attack = attack;
        this.armorValue = armorValue;
        this.alive = alive;
        this.armor = armor;
    }

    public abstract int superAttack(Droid droid);
    public abstract int attack(Droid droid);
    public abstract void defence(int damage);

    //public abstract String printDroidInfo();

    public int getHealth() {
        if (health > 0) {
            return health;
        } else { return 0; }
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmorValue() {
        if (armorValue > 0) {
            return armorValue;
        } else { return 0; }
    }
    public void setArmorValue(int armorValue) { this.armorValue = armorValue; }

    public int getAttack() { return attack; }
    public void setAttack(int attack) { this.attack = attack; }

    public boolean isArmor() {
        if (armorValue <= 0) {
            return false;
        }
        return true;
    }

    public boolean isAlive() {
        if (health <= 0) {
            return false;
        }
        return true;
    }
}
