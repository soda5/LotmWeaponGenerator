package model;

public class Melee extends Weapon {
    public Melee(String name, int sequence) {
        super(name, sequence);
        this.isRanged = false;
    }
}
