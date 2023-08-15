package homework;

import java.util.*;
import java.util.stream.Collectors;

//Given a string of round, curly, and square open and closing brackets,
// return whether the brackets are balanced (well-formed).
//For example, given the string "([])[]({})", you should return true.
//Given the string "([)]" or "((()", you should return false.
public class Brackets {

    public static String bracketsInput = "([])[]({})";
//    public static String bracketsInput = "([)]";

    public static void main(String[] something){
//        System.out.println("Input text with brackets:");
//        Scanner s = new Scanner(System.in);
//        String textInput = s.nextLine();
//        bracketsInput = GetBrackets(textInput);
//        System.out.println("Yours brackets from text:"+ GetBrackets(textInput));
        System.out.println("Does is your brackets are correct?: "+CheckBrackets(bracketsInput));

    }

    private static boolean CheckBrackets(String bracketsInput) {
        boolean result=false;
        char[] roundBrackets = {'(',')'};
        char[] squareBrackets = {'[',']'};
        char[] arrowBrackets = {'{','}'};

        List<Character> workBrackets = bracketsInput.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        boolean bracketRemoved;
        do {
            bracketRemoved=false;
            for (int i = 0; i < workBrackets.size(); i++) {
                try {
                    if (workBrackets.get(i) == roundBrackets[0] && workBrackets.get(i+1) == roundBrackets[1]){
                        workBrackets.remove(i+1);
                        workBrackets.remove(i);
                        bracketRemoved=true;
                    }
                    if (workBrackets.get(i) == squareBrackets[0] && workBrackets.get(i+1) == squareBrackets[1]){
                        workBrackets.remove(i+1);
                        workBrackets.remove(i);
                        bracketRemoved=true;
                    }
                    if (workBrackets.get(i) == arrowBrackets[0] && workBrackets.get(i+1) == arrowBrackets[1]){
                        workBrackets.remove(i+1);
                        workBrackets.remove(i);
                        bracketRemoved=true;
                    }
                } catch (Exception e) {
                    System.out.println("Lack of work brackets..");
                }

                System.out.println(Arrays.toString(workBrackets.toArray()));

            }
        } while (bracketRemoved==true);

        if (workBrackets.size()==0) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    private static List<Integer> GetBracketPosList(char bracketChar, String bracketsInput) {
        List<Integer> resultList = new LinkedList<>();
        for (int i=0; i<=bracketsInput.length(); i++) {
            if (bracketsInput.charAt(i) == bracketChar){
                resultList.add(i);
            }
        }
        return resultList;
    }


    private static String GetBrackets(String textInput) {
        StringBuilder result = new StringBuilder();
        char[] bracketSet = {'(',')','[',']','{','}'};
        char[] charArray = textInput.toCharArray();
        for (char c:charArray) {
            if (contains(bracketSet,c)) {
                result.append(c);
            }
        }
        return result.toString();
    }
    private static boolean contains(char[] inputArray, char inputChar) {
        boolean contains = false;
        for (char c:inputArray) {
            if (c == inputChar) {
                contains = true;
                break;
            }
        }
        return contains;
    }
}
