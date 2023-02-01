import model.Melee;
import model.Ranged;

public class Run {
    public static void main(String[] args) {
        Ranged weapon = new Ranged("Death Helper", 3);
        System.out.println(weapon);

        Melee weapon2 = new Melee("Red Gloves", 2);
        System.out.println(weapon2);

        Ranged weapon3 = new Ranged("Suicide Gown", 6);
        System.out.println(weapon3);
    }
}
