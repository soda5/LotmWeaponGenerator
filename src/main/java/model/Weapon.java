package model;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public abstract class Weapon {
    public String name;
    public int sequence;
    public boolean isRanged;
    public String beschreibung = "Eine tödliche Waffe, fragt sich nur für wen?";
    public float hitChance = 0.2f;
    public int baseDamage;
    public int numberDamageD6;
    private int downsideWeight;
    private List<Downside> downsides;

    public Weapon (String name, int sequence) {
        this.name = name;
        this.sequence = sequence;
        Random random = new Random();
        downsideWeight = (sequence / 2) + sequence -1 + random.nextInt(3);
        downsideWeight = downsideWeight < 0 ? 0 : downsideWeight;
        Downsides.createDownsides();
        downsides = Downsides.decideDownsides(downsideWeight);
        downsides = downsides.stream().distinct().collect(Collectors.toList());
        setDamage(sequence);
    }

    public Weapon() {
    }

    private void setDamage(int sequence) {
        switch(sequence){
            case 1:
                baseDamage = 5;
                numberDamageD6 = 1;
                break;
            case 2:
                baseDamage = 10;
                numberDamageD6 = 2;
                break;
            case 3:
                baseDamage = 15;
                numberDamageD6 = 2;
                break;
            case 4:
                baseDamage = 20;
                numberDamageD6 = 3;
                break;
            case 5:
                baseDamage = 25;
                numberDamageD6 = 3;
                break;
            case 6:
                baseDamage = 30;
                numberDamageD6 = 4;
                break;
            case 7:
                baseDamage = 35;
                numberDamageD6 = 4;
                break;
            case 8:
                baseDamage = 40;
                numberDamageD6 = 5;
                break;
            case 9:
                baseDamage = 45;
                numberDamageD6 = 5;
                break;
            case 10:
                baseDamage = 50;
                numberDamageD6 = 6;
                break;
            default:
                System.out.println("Sequence " + sequence + " gibt es nicht.");
                break;
        }
    }

    public String toString() {
        String finalText = "";
        finalText += name + "\n";
        finalText += "Sequenz: " + sequence + (isRanged == false ? " Fernkampfwaffe" : " Nahkampfwaffe") + "\n";
        finalText += "Beschreibung: " + beschreibung + "\n";
        finalText += "Schaden: " + baseDamage + " + " + numberDamageD6 + "D6" + "\n";
        finalText += "Downsides: \n";

        for (int i = 0; i < downsides.size(); i++) {
            finalText += downsides.get(i);
        }

        return finalText;
    }
}
