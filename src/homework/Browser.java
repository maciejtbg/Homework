package homework;

import java.util.LinkedList;
import java.util.List;
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
    static String dot = ".";
    static String asterisk = "*";
    static String regularExpression = "xzxzabcnmnabcnabcdxzz";
    static String inputString = ".***.*abc*abc.abcd.*";
    public static void main(String[] args){
//        System.out.println("Input a regular expression:");
//        Scanner s = new Scanner(System.in);
//        regularExpression = s.nextLine();
//        System.out.println("Input a searching expression:");
//        inputString = s.nextLine();
        boolean result = IsMatching(inputString, regularExpression);
        System.out.println("Result: " + result);
    }

    private static boolean IsMatching(String inputString, String regularExpression) {
        boolean result = true;
        char dot = '.';
        char asterisk = '*';
        int regExpLength;
        int inputStrLength;

        List<String> inputList = MakeListOfTypes(inputString);
        List<String> inputListLetters = MakeListOfLetters(inputList);
        List<String> workList = new LinkedList<>();
        System.out.println(inputList);
        System.out.println(inputListLetters);
        //znaleźć literowe wyrażenia
        for (String letters:inputListLetters) {
            if(regularExpression.contains(letters)){
                //wszystko to co jest przed literami wpakuj do jakiejś listy
                workList.add(regularExpression.substring(0,regularExpression.indexOf(letters)));
                workList.add(letters);
                regularExpression = regularExpression.substring(regularExpression.indexOf(letters)+letters.length());
                //usuń ten ciąg z wyraźenia
            }else {
                return false;
            }
        }
        //dodaj to co zostało do listy roboczej
        if (regularExpression.length()>0){
            workList.add(regularExpression);
        }
        System.out.println("WORK: "+workList);
        boolean resultFromBlankMarks = CompareBlankMarks(inputList,inputListLetters,workList);



//        do{ //sposób dobry ale tylko na kropki
//            if (inputString.charAt(0) == dot){ //jeżeli jest kropką
//                //zabierz po jednym znaku z obu Stringów
//                inputString = inputString.substring(1);
//                regularExpression = regularExpression.substring(1);
//            }else{ //jeśli nie jest kropką
//                //porównaj pierwsze znaki
//                if (inputString.charAt(0) == regularExpression.charAt(0)){
//                    //ok
//                    //zabierz po jednym znaku z obu Stringów
//                    inputString = inputString.substring(1);
//                    regularExpression = regularExpression.substring(1);
//                }else {
//                    //nie pasuje
//                    result=false;
//                    break;
//                }
//            }
//            System.out.println("REG: "+regularExpression+" INPUT: "+inputString);
//
//            //sprawdzenie czy któryś string się wyczerpał
//            regExpLength = regularExpression.length();
//            inputStrLength = inputString.length();
//            if (regExpLength==0 || inputStrLength==0) {
//                if (regExpLength==0 && inputStrLength==0){
//                    break;
//                } else {
//                    result=false;
//                    break;
//                }
//            }
//        }while(true);

        return result;
    }

    private static boolean CompareBlankMarks(List<String> inputList, List<String> inputListLetters, List<String> workList) {
        boolean result = false;
        //metoda porównująca miejca, gdzie nie ma liter, muszą się zgadzać ilości znaków do kropek
        return result;
    }

    private static List<String> MakeListOfLetters(List<String> inputList) {
        List<String> result = new LinkedList<>();
        for (String e:inputList) {
            if (!e.equals(dot) && !e.equals(asterisk)){
                result.add(e);
            }
        }
        return result;
    }

    public static List<String> MakeListOfTypes(String inputString) {

        List<String> resultList = new LinkedList<>();
        do{
            if(String.valueOf(inputString.charAt(0)).equals(dot)){
                resultList.add(dot);
                inputString = inputString.substring(1);
            } else if(String.valueOf(inputString.charAt(0)).equals(asterisk)){
                if (!resultList.get(resultList.size() - 1).equals(asterisk)) {
                    resultList.add(asterisk);
                }
                inputString = inputString.substring(1);
            } else {
                if (resultList.get(resultList.size() - 1).equals(asterisk) || resultList.get(resultList.size() - 1).equals(dot)){
                    resultList.add(String.valueOf(inputString.charAt(0)));
                    inputString = inputString.substring(1);
                } else {
                    resultList.add(resultList.get(resultList.size() - 1)+(inputString.charAt(0)));
                    resultList.remove(resultList.size() - 2);
                    inputString = inputString.substring(1);
                }
            }
        }while (inputString.length()>0);
        return resultList;
    }
}
