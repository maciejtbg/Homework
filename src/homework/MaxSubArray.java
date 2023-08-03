package homework;

import java.util.Arrays;
import java.util.Scanner;

//Given an array of integers and a number k, where 1 <= k <= length of the array,
// compute the maximum values of each subarray of length k.
//
//For example, given array = [10, 5, 2, 7, 8, 7] and k = 3,
// we should get: [10, 7, 8, 8], since:
//
//10 = max(10, 5, 2)
//7 = max(5, 2, 7)
//8 = max(2, 7, 8)
//8 = max(7, 8, 7)
//Do this in O(n) time and O(k) space.
// You can modify the input array in-place, and you do not need to store the results.
// You can simply print them out as you compute them.
public class MaxSubArray {

    public static int arraySize;
    public static int subArraySize;

    public static int[] inputArray;

    public static void main(String[] args) {
        System.out.print("Input array size: ");
        Scanner s = new Scanner(System.in);
        arraySize = s.nextInt();
        inputArray = new int[arraySize];
        System.out.println("Input all array elements: ");
        for (int i = 0; i < arraySize; i++) {
            inputArray[i] = s.nextInt();
        }
        System.out.println("Input array: "+Arrays.toString(inputArray));

        System.out.print("Input sub array size: ");
        subArraySize = s.nextInt();

        int result = CountMaxValueFromSubArrays(inputArray, subArraySize);
        System.out.println("Sum from max values from all sub arrays is: "+result);
        s.close();
    }

    private static int CountMaxValueFromSubArrays(int[] inputArray, int subArraySize) {
        int n = arraySize-subArraySize+1;//number of subarrays
        int[] maxValuesInSubStrings = new int[n]; //array of max values
        int[][] allSubArrays = new int[n][subArraySize];
        for (int i = 0; i < n; i++){//pętla po kolejnych podtablicach
            for (int j=0; j< subArraySize; j++){
                allSubArrays[i][j]=inputArray[i+j];
            }
            Arrays.sort(allSubArrays[i]); //sort all arrays ascending
            maxValuesInSubStrings[i]=allSubArrays[i][allSubArrays[i].length-1];
            System.out.println("Sorted arrays descending: "+Arrays.toString(allSubArrays[i]));

        }
        System.out.println("Max values from arrays:" +Arrays.toString(maxValuesInSubStrings));
        return SumArrayElements(maxValuesInSubStrings);
    }

    private static int SumArrayElements(int[] maxValuesInSubStrings) {
        return Arrays.stream(maxValuesInSubStrings).sum();
    }
}
