package homework;

import java.util.Scanner;

public class JustifiedText {

//    Write an algorithm to justify text.
//    Given a sequence of words and an integer line length k, return a list of strings which represents each line, fully justified.
//    More specifically, you should have as many words as possible in each line.
//    There should be at least one space between each word.
//    Pad extra spaces when necessary so that each line has exactly length k.
//    Spaces should be distributed as equally as possible, with the extra spaces, if any, distributed starting from the left.
//    If you can only fit one word on a line, then you should pad the right-hand side with spaces.
//    Each word is guaranteed not to be longer than k.



    public static String inputText = "";
    public static int k = 16;

    public static void main (String args[]){

        Scanner s = new Scanner(System.in);
        System.out.println("Put text to justify:");
        inputText = s.nextLine();
        System.out.println("Put one line length:");
        k = s.nextInt();
        System.out.println(JustifyText(inputText,k));

    }

    private static String JustifyText(String inputText,int k) {
        String outputString = "";

        return  outputString;
    }

}
