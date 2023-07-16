package homework;

import java.util.*;

//Computer the running median of sequence of numbers.
// That is given a stream of numbers, print out the median of the list so far on each new element.
//Recall that median of an even-numbered list os the average of the two middle numbers.
public class MedianFromList {
    public static void main(String[] args) {

        ComputeRunningMedian();
    }

    private static void ComputeRunningMedian() {
        System.out.println("Keep input as many numbers as you want:");
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int counter = 0;
        boolean finishMethod = false;
        do {
            try {
                System.out.print(": ");
                int inputInt = scanner.nextInt();
                sum += inputInt;
                counter++;
                System.out.println((double) sum / (double) counter);
            } catch (InputMismatchException e) {
                System.out.println("Function ends...");
                finishMethod = true;
            }
        } while (!finishMethod);
    }
}
