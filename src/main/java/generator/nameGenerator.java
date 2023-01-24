package generator;

import java.util.ArrayList;
import java.util.List;

public class nameGenerator {

    static List<String> weaponFirstNames = new ArrayList<>();
    static List<String> weaponSecondNames = new ArrayList<>();

    public static void initNames() {
        String firstNames = "Death, Harm, Destruction, Love, Peace, Strength";
        String[] names = firstNames.split(", ");
        weaponFirstNames.addAll(List.of(names));

        String lastNames = "Bringer, Giver, Maker";
        String[] names2 = lastNames.split(", ");
        weaponSecondNames.addAll(List.of(names2));
    }
}
