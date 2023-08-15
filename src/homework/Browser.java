package homework;

import java.util.Scanner;

//Implement regular expression matching with the following special characters:
//  . (period) which matches any single character
//  * (asterisk) which matches zero or more of the preceding element
//That is, implement a function that takes in a string and a valid regular expression
//and returns whether, or not the string matches the regular expression.
//For example, given the regular expression "ra." and the string "ray",
//your function should return true.
//The same regular expression on the string "raymond" should return false.
//Given the regular expression ".*at" and the string "chat",
//your function should return true.
//The same regular expression on the string "chats" should return false.
public class Browser {

    static String regularExpression = "ray";
    static String inputString = "ra.";
    public static void main(String[] args){
        System.out.println("Input a regular expression:");
        Scanner s = new Scanner(System.in);
        regularExpression = s.nextLine();
        System.out.println("Input a searching expression:");
        inputString = s.nextLine();
        boolean result = IsMatching(inputString, regularExpression);
        System.out.println("Result: " + result);
    }

    private static boolean IsMatching(String inputString, String regularExpression) {
        boolean result = false;



        return result;
    }
}
