package homework;

import java.util.*;

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
static String inputString = "race"; //działa

//    static String inputString = "google"; //działa

//    static String inputString = "jajk"; //działa
//    static String inputString = "abemngeb"; //działa

    public static void main(String[] args) {

        System.out.print("Give a string: ");
        System.out.println(inputString);
        Scanner s = new Scanner(System.in);
//        String inputString = s.nextLine();
//        System.out.println(CheckIfPalindrome(inputString));
//        System.out.println(InvertString(inputString));
//        System.out.println(FindReversed(inputString));
        System.out.println(FindShortestPalindrome(inputString));
//        System.out.println(MakePalindrome(inputString));

    }


    static boolean CheckIfPalindrome(String inputString) {
        boolean isPalindrome = true;
        for (int i = 0; i<(inputString.length()/2);i++){
            if (inputString.charAt(i) != inputString.charAt(inputString.length()-1-i)) isPalindrome = false;
        }
        return isPalindrome;
    }
    static String FindShortestPalindrome(String inputString){
        //inicjalizuje zmienne przechowujące największy powtarzający się kawałek tekstu
        int l = 0;//długość
        int p = 0;//miejsce
        int pm = 0; //miejsce początku lustrzanego odbicia kawałka tekstu
        String invertedString = "";
        String restLeft ="";
        String restRight = "";
        String maxRepetitionStart = "";
        String centerPalindrome="";
        String mirrorRepetition="";
        List<String> result = new LinkedList<>();
        //pętla wycinająca kawałki ze stringa
        for(int i=1; i<=inputString.length(); i++){
            //i symbolizuje długość sprawdzanego stringa
            for (int j=0; j<inputString.length()-i+1; j++){
                //j symbolizuje miejsce w stringu
                String partOfString = inputString.substring(j,j+i);
//                System.out.print("L: "+i+" P: "+j+" "+partOfString+" ");
                //tu trzeba znaleźć powtarzający się kawałek tekstu, ale w innym miejscu
                invertedString = InvertString(partOfString);
                boolean contains = inputString.substring(j+1).contains(invertedString);
//                System.out.println(contains);


                if (contains){//rozpatrywany kawałektekstu się powtarza gdzieś w tekscie
                    System.out.println("inversedString: "+invertedString);
                    pm=inputString.lastIndexOf(invertedString);//pm to place mirror - miejsce odwróconego tekstu
                    l=i;p=j;
                    if (j==0 && (pm+i)==inputString.length()){
                        System.out.println("Bez ogonków");
                        //tu tylko trzeba zmodyfikować środek i dodać do listy result
                        maxRepetitionStart=inputString.substring(p,p+l);
                        centerPalindrome=MakePalindrome(inputString.substring(p+l,pm));
                        mirrorRepetition=inputString.substring(pm,pm+l);
                        System.out.println("Reszta z lewej: "+restLeft);
                        System.out.println("Największa repetycja: "+maxRepetitionStart);
                        System.out.println("Palindrom z wnętrza: "+centerPalindrome);
                        System.out.println("Lustrzana repetycja: "+mirrorRepetition);
                        System.out.println("Reszta z prawej: "+restRight);
                        result.add(maxRepetitionStart+centerPalindrome+mirrorRepetition);

                    } else if (j==0 || (pm+i)==inputString.length()) {
                        System.out.println("Z jednym ogonkiem");
                        if (j==0){
                            restRight=inputString.substring(pm+i);
                            System.out.println("Ogonek tylko z prawej: "+restRight);
                            //zmodyfikować środek i dodać ogonek z lewej
                            maxRepetitionStart=inputString.substring(p,p+l);
                            System.out.println("inputString: "+inputString+" p,l,pm "+p+","+l+","+pm+" Repetycja: "+maxRepetitionStart);
                            if (p+l>pm){
                                centerPalindrome = String.valueOf(inputString.charAt(p+l));
                            }else if ((p+l)==pm){
                                centerPalindrome="";
                            }else{
                                centerPalindrome=MakePalindrome(inputString.substring(p+l,pm));
                            }
                            mirrorRepetition=inputString.substring(pm,pm+l);
                            System.out.println("Odwrócony ogonek: "+InvertString(restRight));
                            System.out.println("Największa repetycja: "+maxRepetitionStart);
                            System.out.println("Palindrom z wnętrza: "+centerPalindrome);
                            System.out.println("Lustrzana repetycja: "+mirrorRepetition);
                            System.out.println("Reszta z prawej: "+restRight);
                            result.add(InvertString(restRight)+maxRepetitionStart+centerPalindrome+mirrorRepetition+restRight);

                        }else{
                            restLeft=inputString.substring(0,j);
                            System.out.println("Ogonek tylko z lewej: "+restLeft);
                            //zmodyfikować środek i dodać ogonek z prawej
                            maxRepetitionStart=inputString.substring(p,p+l);
                            System.out.println("inputString: "+inputString+" p,l,pm "+p+","+l+","+pm+" Repetycja: "+maxRepetitionStart);
                            if (p+l>pm){
                                centerPalindrome = String.valueOf(inputString.charAt(p+l));
                            }else if ((p+l)==pm){
                                centerPalindrome="";
                            }else{
                                centerPalindrome=MakePalindrome(inputString.substring(p+l,pm));
                            }
                            mirrorRepetition=inputString.substring(pm,pm+l);
                            System.out.println("Reszta z lewej: "+restLeft);
                            System.out.println("Największa repetycja: "+maxRepetitionStart);
                            System.out.println("Palindrom z wnętrza: "+centerPalindrome);
                            System.out.println("Lustrzana repetycja: "+mirrorRepetition);
                            result.add(restLeft+maxRepetitionStart+centerPalindrome+mirrorRepetition+InvertString(restLeft));

                        }
                    }
                    else {
                        System.out.println("Z ogonkami.");
                        //tu trzeba dodać logikę dokładania naprzemiennego po obu stronach

                    }

                }
            }
        }
        if (result.size()==0){
            //logika kiedy na ma żadnych powtarzających się liter
            result.add(MakePalindrome(inputString));
            result.add(MakePalindromeInverted(inputString));

        }


        return FindTheShortest(result);
    }
    public static String FindTheShortest(List<String> listOfStrings) {
        listOfStrings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int compResult = o1.length()-o2.length();
                return compResult != 0 ? compResult : o1.compareTo(o2);
            }
        });
        for (String string:listOfStrings) {
            System.out.println(string);
        }
        return listOfStrings.get(0);
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
    public static String MakePalindromeInverted (String inputString){
        String outputString = inputString;
        char[] mirror = new char[inputString.length()-1]; //towrzę tablicę do lustrzanego odbicia
        for (int i = 0; i<mirror.length; i++){
            mirror[i]=inputString.charAt(inputString.length()-1-i);
        }
        outputString = String.valueOf(mirror)+outputString;
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
