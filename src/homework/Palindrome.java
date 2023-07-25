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


    static String inputString = "edmadea";
    public static void main(String[] args) {

        System.out.println("Give a string:");
        Scanner s = new Scanner(System.in);
//        String inputString = s.nextLine();
//        System.out.println(CheckIfPalindrome(inputString));
//        System.out.println(InvertString(inputString));
//        System.out.println(FindReversed(inputString));
        System.out.println(FindReversed(inputString));
//        System.out.println(MakePalindrome(inputString));

    }


    static boolean CheckIfPalindrome(String inputString) {
        boolean isPalindrome = true;
        for (int i = 0; i<(inputString.length()/2);i++){
            if (inputString.charAt(i) != inputString.charAt(inputString.length()-1-i)) isPalindrome = false;
        }
        return isPalindrome;
    }
    static List<String> FindReversed(String inputString){
        //inicjalizuje zmienne przechowujące największy powtarzający się kawałek tekstu
        int l = 0;//długość
        int p = 0;//miejsce
        int pm = 0; //miejsce początku lustrzanego odbicia kawałka tekstu
        String invertedString = "";
        String restLeft ="";
        String restRight = "";
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
                invertedString = InvertString(partOfString);
                boolean contains = inputString.substring(j+1).contains(InvertString(partOfString));
                System.out.println(contains);


                if (contains){
                    pm=inputString.lastIndexOf(invertedString);
                    if (j==0 && (pm+i)==inputString.length()){
                        System.out.println("Bez ogonków");
                    } else if (j==0 || (pm+i)==inputString.length()) {
                        System.out.println("Z jednym ogonkiem");
                        if (j==0){
                            restRight=inputString.substring(pm+i);
                            System.out.println("Ogonek tylko z prawej: "+restRight);

                        }else{
                            restLeft=inputString.substring(0,j);
                            System.out.println("Ogonek tylko z lewej: "+restLeft);

                        }
                    }
                    else {
                        System.out.println("Z ogonkami.");
                    }
                        repetisionString = partOfString;
                        l=i;p=j;



//                        if(restLeft.length()==0){
//                            //jeżeli po lewej nic nie ma to kopjujemy z prawej
//                            restLeft=MakePalindrome(restRight);
//                        }else{
//                            restRight=MakePalindrome(restLeft);
//                        }


//                    System.out.println("Index musterka: "+pm);
                    //sprawdzenie czy po lewej lub prawej stronie są resztki tekstu

                }
            }
        }

        String maxRepetitionStart=inputString.substring(p,p+l);
        String centerPalindrome=MakePalindrome(inputString.substring(p+l,pm));
        String mirrorRepetition=inputString.substring(pm,pm+l);
        System.out.println("Reszta z lewej: "+restLeft);
        System.out.println("Największa repetycja: "+maxRepetitionStart);
        System.out.println("Palindrom z wnętrza: "+centerPalindrome);
        System.out.println("Lustrzana repetycja: "+mirrorRepetition);
        System.out.println("Reszta z prawej: "+restRight);


        if (repetisionString!=null){
            result.add(maxRepetitionStart+centerPalindrome+mirrorRepetition);
        }
        return result;
    }
    public static String MakePalindrome (String inputString){
        String outputString = inputString;
        char[] mirror = new char[inputString.length()-1]; //towrzę tablicę do lustrzanego odbicia
        for (int i = 0; i<mirror.length; i++){
            mirror[i]=inputString.charAt(inputString.length()-i-2);
        }
        outputString += String.valueOf(mirror);
        return outputString;
    }
    public static String InvertString (String inputString){
        char[] resultArray = new char[inputString.length()];
        for (int i = 0; i<inputString.length(); i++){
            resultArray[i]=inputString.charAt(inputString.length()-1-i);
        }
        return String.valueOf(resultArray);
    }
}
