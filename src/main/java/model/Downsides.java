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
        /*Trivial:*/
        Downside downsideTrivialOne = new Downside(0, "Du hast ein verstärktes Durstgefühl.", "Du musst öfter pinkeln.");
        downsidesTrivial.add(downsideTrivialOne);
        Downside downsideTrivialTwo = new Downside(0, "Du denkst jede Person des anderen Geschlechtes ist an dir interessiert.",
                "Du missinterpretierst oft gesellschaftliche Situationen.");
        downsidesTrivial.add(downsideTrivialTwo);
        Downside downsideTrivialThree = new Downside(0, "Dein Gesicht sieht lächerlich aus.",
                "NPCs müssen sich zusammenreißen um dich nicht auszulachen.");
        downsidesTrivial.add(downsideTrivialThree);
        Downside downsideTrivialFour = new Downside(0, "Deine Haut wird grünlich.",
                "Charm -1, NPCs reagieren seltsam auf dich.");
        downsidesTrivial.add(downsideTrivialFour);

        /*Leicht:*/
        Downside downsideEasyOne = new Downside(1, "Du fühlst dich als hättest du Stundenland einem langweiligen" +
                "Theaterstück zugesehen. Du bist erschöpft und schlecht gelaunt.", "Endurance -1, Wahrnehmung -1, Charme -1");
        downsidesEasy.add(downsideEasyOne);
        Downside downsideEasyTwo = new Downside(1, "Du bist nicht mehr in der Lage mit Sprache zu kommunizieren.",
                "Du kannst keine Charme oder Überzeugenwürfe mehr machen und generell nicht mehr Sprechen.");
        downsidesEasy.add(downsideEasyTwo);
        Downside downsideEasyThree = new Downside(1, "Vergiftet deinen Körper langsam wenn Hautkontakt.",
                "-2 HP pro Runde im Gefecht oder -1 HP pro Stunde außerhalb des Gefechtes.");
        downsidesEasy.add(downsideEasyThree);
        Downside downsideEasyFour = new Downside(1, "Du kannst Gesichter nicht mehr auseinanderhalten.",
                "Du weißt nicht mit wem du sprichst sofern die Person nicht offensichtliche Merkmale außerhalb des Gesichts hat.");
        downsidesEasy.add(downsideEasyFour);
        Downside downsideEasyFive = new Downside(1, "Das Benutzen des Items versetzt dich in einen Zustand wie nach einem sehr harten Workout.",
                "-3 Stärke nachdem du es benutzt für den Tag, nachdem du den Effekt an 14 aufeinanderfolgenden Tagen benutzt, erhöht sich deine Stärke" +
                        "dauerhaft um 1 (Effekt kann pro Person nur einmal erhalten werden.)");
        downsidesEasy.add(downsideEasyFive);

        /*Mittel:*/
        Downside downsideMiddleOne = new Downside(2, "Du kannst weder riechen noch schmecken noch hören.",
                "-10 Wahrnehmung, Probleme wenn du deine Sinne nutzen willst.");
        downsidesMiddle.add(downsideMiddleOne);
        Downside downsideMiddleTwo = new Downside(2, "Du fängst an extrem nach Verwesung zu stinken.",
                "-10 Charm, -10 Überzeugen, +5 Einschüchtern.");
        downsidesMiddle.add(downsideMiddleTwo);

        /*Schwer:*/
        Downside downsideHardOne = new Downside(3, "Dein Körper wird alt und gebrechlich, so wird kämpfen schwer.",
                "Deine Max HP reduzieren sich auf 50%.");
        downsidesHard.add(downsideHardOne);
        Downside downsideHardTwo = new Downside(3, "Das Item scheint vampirischen Ursprunges zu sein, es suagt dein Blut.",
                "-6 HP pro Runde im Gefecht oder -3 HP pro Stunde außerhalb des Gefechtes.");
        downsidesHard.add(downsideHardTwo);

        /*Catastrophe:*/
        Downside downsideCatastropheOne = new Downside(4, "Bei jeder Benutzung verkaufst du ein Stück deiner Seele.",
                "Für jedes Mal benutzen dieses Items musst du permanent einen beliebigen deiner 4 Mainstats um 1 veringern.");
        downsidesCatastrophe.add(downsideCatastropheOne);
        Downside downsideCatastropheTwo = new Downside(4, "Du musst den großteil deiner aktuellen Lebensenergie opfern.",
                "Verringere deine aktuellen HP um 80% für jeden Use.");
        downsidesCatastrophe.add(downsideCatastropheTwo);
    }

    public static List<Downside> decideDownsides(int downsightWeight) {
        List<Downside> downsides = new ArrayList<>();
        Random random = new Random();

        if (downsightWeight == 0) {
            downsides.add(new Downside(0, "Dieses Item hat glücklicherweise keine Nachteile.", "Keine."));
            return downsides;
        }

        while (downsightWeight > 0) {
            int biggestPossibleWeight = getBiggestDownside(downsightWeight);
            int decider = random.nextInt(3);

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
            } else if (decider == 1) {
                if (biggestPossibleWeight == 5) {
                    downsides.add(getRandomDownsideByLevel(3));
                    downsightWeight -= biggestPossibleWeight;
                } else if (biggestPossibleWeight == 4) {
                    downsides.add(getRandomDownsideByLevel(2));
                    downsightWeight -= biggestPossibleWeight;
                } else if (biggestPossibleWeight == 3) {
                    downsides.add(getRandomDownsideByLevel(1));
                    downsightWeight -= biggestPossibleWeight;
                } else if (biggestPossibleWeight < 3) {
                    downsides.add(getRandomDownsideByLevel(0));
                    downsightWeight -= biggestPossibleWeight;
                }
            } else if (decider == 2) {
                if (biggestPossibleWeight == 5) {
                    downsides.add(getRandomDownsideByLevel(2));
                    downsightWeight -= biggestPossibleWeight;
                } else if (biggestPossibleWeight == 4) {
                    downsides.add(getRandomDownsideByLevel(1));
                    downsightWeight -= biggestPossibleWeight;
                } else if (biggestPossibleWeight < 4) {
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
