package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Downsides {
    private static List<Downside> downsidesTrivial = new ArrayList<>();
    private static List<Downside> downsidesEasy = new ArrayList<>();
    private static List<Downside> downsidesMiddle = new ArrayList<>();
    private static List<Downside> downsidesHard = new ArrayList<>();
    private static List<Downside> downsidesCatastrophe = new ArrayList<>();

    public static void createDownsides() {
        Downside downsideTrivialOne = new Downside(0, "Du hast ein verstärktes Durstgefühl.", null);
        downsidesTrivial.add(downsideTrivialOne);
        Downside downsideTrivialTwo = new Downside(0, "Du denkst jede Person des anderen Geschlechtes ist an dir interessiert.", null);
        downsidesTrivial.add(downsideTrivialTwo);
        Downside downsideTrivialThree = new Downside(0, "Dein Gesicht sieht lächerlich aus.", null);
        downsidesTrivial.add(downsideTrivialThree);

        Downside downsideEasyOne = new Downside(1, "Du fühlst dich als hättest du Stundenland einem langweiligen" +
                "Theaterstück zugesehen. Du bist erschöpft und schlecht gelaunt.", "Endurance -1, Wahrnehmung -1, Charme -1");
        downsidesEasy.add(downsideEasyOne);
        Downside downsideEasyTwo = new Downside(1, "Du bist nicht mehr in der Lage mit Sprache zu kommunizieren.",
                "Du kannst keine Charme oder Überzeugenwürfe mehr machen und generell nicht mehr Sprechen.");
        downsidesEasy.add(downsideEasyTwo);
        Downside downsideEasyThree = new Downside(1, "Vergiftet deinen Körper langsam wenn Hautkontakt.",
                "-2 HP pro Runde im Gefecht oder -1 HP pro Stunde außerhalb des Gefechtes.");
        downsidesEasy.add(downsideEasyThree);

        Downside downsideMiddleOne = new Downside(2, "Du kannst weder riechen noch schmecken noch hören.",
                "-10 Wahrnehmung und Probleme wenn du deine Sinne nutzen willst.");
        downsidesMiddle.add(downsideMiddleOne);

        Downside downsideHardOne = new Downside(3, "Dein Körper wird alt und gebrechlich, so wird kämpfen schwer.",
                "Deine Max HP reduzieren sich auf 50%.");
        downsidesHard.add(downsideHardOne);

        Downside downsideCatastropheOne = new Downside(4, "Bei jeder Benutzung verkaufst du ein Stück deiner Seele.",
                "Für jedes Mal benutzen dieses Items musst du permanent einen deiner 4 Mainstats um 1 veringern.");
        downsidesCatastrophe.add(downsideCatastropheOne);
    }

    public static List<Downside> decideDownsides(int downsightWeight) {
        List<Downside> downsides = new ArrayList<>();
        Random random = new Random();

        if (downsightWeight == 0) {
            downsides.add(new Downside(0, "Dieses Item hat glücklicherweise keine Downsides.", "Keine."));
            return downsides;
        }

        while (downsightWeight > 0) {
            int biggestPossibleWeight = getBiggestDownside(downsightWeight);
            int decider = random.nextInt(2);

            if (decider == 0) {
                if (biggestPossibleWeight == 5) {
                    downsides.add(getRandomDownsideByLevel(4));
                    downsightWeight -= biggestPossibleWeight;
                } else if (biggestPossibleWeight == 4) {
                    downsides.add(getRandomDownsideByLevel(3));
                    downsightWeight -= biggestPossibleWeight;
                } else if (biggestPossibleWeight == 3) {
                    downsides.add(getRandomDownsideByLevel(2));
                    downsightWeight -= biggestPossibleWeight;
                } else if (biggestPossibleWeight == 2) {
                    downsides.add(getRandomDownsideByLevel(1));
                    downsightWeight -= biggestPossibleWeight;
                } else if (biggestPossibleWeight == 1) {
                    downsides.add(getRandomDownsideByLevel(0));
                    downsightWeight -= biggestPossibleWeight;
                }
            } else {
                if (biggestPossibleWeight == 5) {
                    downsides.add(getRandomDownsideByLevel(3));
                    downsightWeight -= biggestPossibleWeight;
                } else if (biggestPossibleWeight == 4) {
                    downsides.add(getRandomDownsideByLevel(2));
                    downsightWeight -= biggestPossibleWeight;
                } else if (biggestPossibleWeight == 3) {
                    downsides.add(getRandomDownsideByLevel(1));
                    downsightWeight -= biggestPossibleWeight;
                } else if (biggestPossibleWeight == 2 || biggestPossibleWeight == 1) {
                    downsides.add(getRandomDownsideByLevel(0));
                    downsightWeight -= biggestPossibleWeight;
                }
            }
        }
        return downsides;
    }

    private static int getBiggestDownside(int downsideWeight) {
        if (downsideWeight > 4) {
            return 5;
        } else if (downsideWeight > 3) {
            return 4;
        } else if (downsideWeight > 2) {
            return 3;
        } else if (downsideWeight > 1) {
            return 2;
        } else if (downsideWeight > 0) {
            return 1;
        } else
            return 0;
    }

    private static Downside getRandomDownsideByLevel (int level) {
        Random random = new Random();

        if (level == 4) {
            int listIndex = random.nextInt(downsidesCatastrophe.size());
            Downside downside = downsidesCatastrophe.get(listIndex);
            return downside;
        } else if (level == 3) {
            int listIndex = random.nextInt(downsidesHard.size());
            Downside downside = downsidesHard.get(listIndex);
            return downside;
        } else if (level == 2) {
            int listIndex = random.nextInt(downsidesMiddle.size());
            Downside downside = downsidesMiddle.get(listIndex);
            return downside;
        } else if (level == 1) {
            int listIndex = random.nextInt(downsidesEasy.size());
            Downside downside = downsidesEasy.get(listIndex);
            return downside;
        } else {
            int listIndex = random.nextInt(downsidesTrivial.size());
            Downside downside = downsidesTrivial.get(listIndex);
            return downside;
        }
    }
}
