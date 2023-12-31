package homework;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ElevationMap {

    //You are given an array of non-negative integers that represents a two-dimensional elevation map
    // where each element is unit-width wall and the integer is the height.
    // Suppose it will rain and all spots between two walls get filled up.
    //Compute how many units of water remain trapped on the map in O(N) time and O(1) space.
    //For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.
    //Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index,
    // 2 in the second, and 3 in the fourth index (we cannot hold 5 since it would run off to the left),
    // so we can trap 8 units of water.

    private static List<Integer> inputMap = new ArrayList<>(Arrays.asList(3, 0, 1, 1));
    private static int waterLever = 2;

    public static void main(String[] args) {
//        System.out.println("Insert 3 numbers: ");
//        Scanner s = new Scanner(System.in);
//        for (int i = 0; i<inputMap.size() ; i++) {
//            int newNumber = s.nextInt();
//            inputMap.set(i,newNumber);
//        }
        System.out.println("Input map:");
        System.out.println(inputMap);
//        System.out.println("Insert water level (0 is null):");
//        waterLever=s.nextInt();

        System.out.println(GetNumberOfWater(inputMap, waterLever));
    }
    static int GetNumberOfWater(List<Integer> inputMap, int waterLever) {
        int numberOfWater = 0;
        //iteracja po poziomach wody
        for (int i = 0; i < waterLever; i++) { // i - poziom, aż do wody
            System.out.println(i + " level iteration...");
            //iteracja po kolumnach w danym poziomie
            for (int j = 0; j < inputMap.size(); j++) { // j - kolumna
                System.out.print("Level: " + i + " block: " + j);
                //znajdowanie pustego bloku
                boolean empty;
                if (inputMap.get(j) <= i) empty = true;
                else empty = false;
                System.out.println(" Empty: " + empty);
                if (empty) {
                    boolean isRightSealed = false;
                    boolean isLeftSealed = false;
                    boolean isSealed = false;
                    //sprawdzam, czy szczelne po obu stronach
                    //szczelne jest wtedy, gdy rozpatrywany poziom (np. 1) jest mniejszy od wartości mapy w kolumnie (np. 2)
                    for (int r = j; r < inputMap.size(); r++) {
                        //sprawdzanie w prawo
                        if (inputMap.get(r) > i) {
                            isRightSealed = true;
                        }
                    }
                    for (int r = j; r >= 0; r--) {
                        //sprawdzanie w lewo
                        if (inputMap.get(r) > i) {
                            isLeftSealed = true;
                        }
                    }
                    System.out.println("Szczelne z lewej: " + isLeftSealed + " Szczelne z prawej: " + isRightSealed);
                    isSealed = isLeftSealed && isRightSealed;
                    if (isSealed) {
                        numberOfWater++;
                    }
                }
                //tu trzeba sprawdzić, czy znaleziony blok jest pomiędzy innymi blokami
            }
        }
        return numberOfWater;
    }
}
