package homework;

import java.util.Scanner;

public class ReverseString {

    private static String ReverseThisString(String inputText) {
        char[] result = inputText.toCharArray();
        for (int i=0; i<inputText.length()/2;i++){
            char temp = result[i];
            result[i] = inputText.charAt(inputText.length()-1-i);
            result[inputText.length()-1-i]=temp;
        }
        return new String(result);
    }

    public static void main(String args[]) {
        System.out.print("Podaj tekst do odwrócenia: ");
        Scanner s = new Scanner(System.in);
        String text = s.nextLine();
        System.out.println(ReverseThisString(text));

    }

}
