package homework;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

//Run-length encoding is a fast and simple method of encoding strings.
// The basic idea is to represent repeated successive characters as a single count and character.
// For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".
// Implement run-length encoding and decoding.
// You can assume the string to be encoded have no digits and consists solely of alphabetic characters.
// You can assume the string to be decoded is valid.
public class LengthEncoding {
    private static String inputString = "AAAABBBCCDA";

    public static void main(String[] args) {
        System.out.println(EncodeString(inputString));
        System.out.println(DecodeString(EncodeString(inputString)));
    }

    private static String EncodeString(String inputString) {
        StringBuilder outputString = new StringBuilder();
        int counter = 1;
        for (int i = 1; i < inputString.length(); i++) {
            if (inputString.charAt(i) == inputString.charAt(i - 1)) {
                //ta litera jest taka sama jak poprzednia więc dodajemy 1
                counter++;
            } else {
                //koniec ciągu tych liter
                outputString.append(String.valueOf(counter) + inputString.charAt(i - 1));
                //ta litera jest inna niż poprzednia, więc tej poprzedniej jest ilość = 1
                counter = 1;
            }
        }
        outputString.append(String.valueOf(counter) + inputString.charAt(inputString.length() - 1));
        return outputString.toString();
    }

    private static String DecodeString(String inputString) {
        StringBuilder outputString = new StringBuilder();
        for (int i = 0; i < inputString.length() - 1; i += 2) {
            int CharNum = Character.getNumericValue(inputString.charAt(i));
            char ThisChar = inputString.charAt(i+1);
            outputString.append(String.valueOf(ThisChar).repeat(CharNum));
        }
        return outputString.toString();
    }
}
