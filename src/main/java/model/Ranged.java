package model;

public class Ranged extends Weapon {
    public Ranged(String name, int sequence) {
        super(name, sequence);
        this.isRanged = true;
    }
}
