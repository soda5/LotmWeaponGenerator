package model;

import java.util.Random;

public class Dice {
    public int value;

    public Dice(int value) {
        this.value = value;
    }

    public int roll() {
        Random random = new Random();
        return random.nextInt(value + 1);
    }
}
