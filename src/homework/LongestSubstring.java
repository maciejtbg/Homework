package homework;

import java.util.Scanner;

public class LongestSubstring {

//    Given an integer k and a string s,
//    find the length of the longest substring that contains at most k distinct characters.
//    For example, given s = "abcba" and k = 2,
//    the longest substring with k distinct characters is "bcb".

    static String inputString = "abcba";
    static int k = 2;
    public static void main(String[] args){
        System.out.println("Input string: ");
        Scanner s = new Scanner(System.in);
        inputString = s.nextLine();
        System.out.println("Input number");
        k = s.nextInt();
        System.out.println(FindLongestSubstring(inputString,k));

    }

    static String FindLongestSubstring(String inputString, int k) {
        String result = new String();

        return result;
    }
}
