package homework;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Palindrome {

//    Given a string, find the palindrome that can be made by inserting the fewest
//    number of characters as possible anywhere in the word. If there is more than
//    one palindrome of minimum length that can be made, return the lexicographically
//    earliest one (the first one alphabetically).
//
//    For example, given the string "race", you should return "ecarace", since we can
//    add three letters to it (which is the smallest amount to make a palindrome).
//    There are seven other palindromes that can be made from "race" by adding three
//    letters, but "ecarace" comes first alphabetically.
//
//    As another example, given the string "google", you should return "elgoogle".


    static String inputString = "edmade";
    public static void main(String[] args) {

        System.out.println("Give a string:");
        Scanner s = new Scanner(System.in);
//        String inputString = s.nextLine();
//        System.out.println(CheckIfPalindrome(inputString));
//        System.out.println(InvertString(inputString));
//        System.out.println(FindReversed(inputString));
        System.out.println(FindReversed(inputString));

    }


    static boolean CheckIfPalindrome(String inputString) {
        boolean isPalindrome = true;
        for (int i = 0; i<(inputString.length()/2);i++){
            if (inputString.charAt(i) != inputString.charAt(inputString.length()-1-i)) isPalindrome = false;
        }
        return isPalindrome;
    }
    static List<String> FindReversed(String inputString){
        List<String> result = new LinkedList<>();
        String repetisionString = null; //póki co ten string jest jako pojedynczy, ale musi być docelowo lista
        //pętla wycinająca kawałki ze stringa
        for(int i=1; i<=inputString.length(); i++){
            //i symbolizuje długość sprawdzanego stringa
            for (int j=0; j<inputString.length()-i+1; j++){
                //j symbolizuje miejsce w stringu
                String partOfString = inputString.substring(j,j+i);
                System.out.print("L: "+i+" P: "+j+" "+partOfString+" ");
                //tu trzeba znaleźć powtarzający się kawałek tekstu, ale w innym miejscu
                boolean contains = inputString.substring(j+1).contains(InvertString(partOfString));
                System.out.println(contains);
                if (contains){
                    repetisionString = partOfString;
                }
            }
        }
        if (repetisionString!=null){

        }
        return result;
    }
    public static String InvertString (String inputString){
        char[] resultArray = new char[inputString.length()];
        for (int i = 0; i<inputString.length(); i++){
            resultArray[i]=inputString.charAt(inputString.length()-1-i);
        }
        return String.valueOf(resultArray);
    }
}
