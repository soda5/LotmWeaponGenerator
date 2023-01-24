import generator.nameGenerator;
import model.Weapon;

public class Run {
    public static void main(String[] args) {
        Weapon weapon = new Weapon("Death Helper", 3);
        System.out.println(weapon);

        Weapon weapon2 = new Weapon("Red Gloves", 2);
        System.out.println(weapon2);

        Weapon weapon3 = new Weapon("Suicide Gown", 6);
        System.out.println(weapon3);

        nameGenerator.initNames();
    }
}
