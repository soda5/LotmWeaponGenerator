package model;

import com.poiji.bind.Poiji;

import java.io.File;
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

        File file = new File("H:/dev/LotmWeaponGenerator/src/main/resources/Downsides.xlsx");
        List<Downside> ecxelList = Poiji.fromExcel(file, Downside.class);

        for (Downside downside : ecxelList) {
            switch(downside.severity){
                case 0:
                    downsidesTrivial.add(downside);
                    break;
                case 1:
                    downsidesEasy.add(downside);
                    break;
                case 2:
                    downsidesMiddle.add(downside);
                    break;
                case 3:
                    downsidesHard.add(downside);
                    break;
                default:
                    downsidesCatastrophe.add(downside);
                    break;
            }
        }

    }

    public static List<Downside> decideDownsides(int downsightWeight) {
        List<Downside> downsides = new ArrayList<>();
        Random random = new Random();

        if (downsightWeight == 0) {
            downsides.add(new Downside(0, "NIX" ,"Dieses Item hat glücklicherweise keine Nachteile.", "Keine."));
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
