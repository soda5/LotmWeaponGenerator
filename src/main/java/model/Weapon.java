package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Weapon {
    public String name;
    public int sequence;
    public String beschreibung = "Eine tödliche Waffe, fragt sich nur für wen?";
    public float hitChance = 0.2f;
    public List<Dice> damageDices = new ArrayList<>();
    private int downsideWeight;
    private List<Downside> downsides;

    public Weapon (String name, int sequence) {
        this.name = name;
        this.sequence = sequence;
        Random random = new Random();
        downsideWeight = (2 * sequence) -1  + random.nextInt(3);
        downsideWeight = downsideWeight < 0 ? 0 : downsideWeight;
        Downsides.createDownsides();
        downsides = Downsides.decideDownsides(downsideWeight);
    }

    public String toString() {
        String finalText = "";
        finalText += name + "\n";
        finalText += "Sequenz: " + sequence + "\n";
        finalText += "Beschreibung: " + beschreibung + "\n";
        finalText += "Downsides: " + downsides;
        return finalText;
    }
}