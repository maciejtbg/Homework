package homework;

import java.util.*;

public class LetterCount {

    private static String token = "2sghuafd1c";

    private static String TokenComparator(String word){
        // Once your function is working, take the final output string
        // and replace all characters that appear in your ChallengeToken with --[CHAR]--.
        StringBuilder wordBuilder = new StringBuilder();
        for (char c:word.toCharArray()){
            if (token.contains(Character.toString(c))){
                wordBuilder.append(c);
            }else {
                wordBuilder.append('-');
            }
        }
        return wordBuilder.toString();
    }


    private static String SearchingChallenge(String str) {
        // Have the function SearchingChallenge(str)
        // take the str parameter being passed and return the first word
        // with the greatest number of repeated letters. For example:
        // "Today, is the greatest day ever!" should return
        // greatest because it has 2 e's (and 2 t's) and it comes before
        // ever which also has 2 e's. If there are no words with repeating
        // letters return -1. Words will be separated by spaces.




        List<String> words = new ArrayList<>();
        words = Arrays.stream(str.split(" ")).toList(); //list of words


        Integer maxRepeatsInAllWords = 1;
        String searchedWord ="";
        for (String word: words) {
            // now look at one word
            Map <Character,Integer> mapOfRepetition = new HashMap<>();
            for (Character c: word.toCharArray()){
                //włożyć do mapy o indeksie znaku wartość powtórzenia
                mapOfRepetition.merge(c, 1, Integer::sum);
            }
            //tu trzeba znaleźć największą wartość z mapy
            Integer maxRepeatsInThisWord = mapOfRepetition.values().stream().max(Integer::compare).orElse(1);
            System.out.println(word+" "+maxRepeatsInThisWord);
            if (maxRepeatsInThisWord>maxRepeatsInAllWords){
                maxRepeatsInAllWords=maxRepeatsInThisWord;
                searchedWord = word;
            }
        }
        if (maxRepeatsInAllWords==1){
            searchedWord="-1";
        }
        result = searchedWord;
        return searchedWord;
    }
    static String result;


    public static void main(String args[]){
        System.out.print("Give me a sentence: ");
        Scanner s = new Scanner(System.in);
        System.out.println("First output: "+SearchingChallenge(s.nextLine()));
        System.out.println("Second output: "+TokenComparator(result));

    }
}
