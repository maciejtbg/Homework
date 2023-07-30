package homework;

import java.util.*;
import java.util.stream.Collectors;

public class LongestSubstring {

//    Given an integer k and a string s,
//    find the length of the longest substring that contains at most k distinct characters.
//    For example, given s = "abcba" and k = 2,
//    the longest substring with k distinct characters is "bcb".

    static String inputString = "abcba";
    static int k = 2;
    public static void main(String[] args){
        System.out.println("Input string: ");
        Scanner s = new Scanner(System.in);
        inputString = s.nextLine();
        System.out.println("Input number");
        k = s.nextInt();
        System.out.println(FindLongestSubstring(inputString,k));
    }

    static String FindLongestSubstring(String inputString, int k) {
        List<String> allSubstrings = CollectAllSubstrings(inputString);
        Map<String,Integer> substringsMap = MapIntoCharactersNumber(allSubstrings);
        Map<String, Integer> substringsMapUsingK = substringsMap.entrySet().stream()
                .filter(entry -> entry.getValue() == k)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        List<String> orderedList = substringsMapUsingK.keySet().stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        }).toList();
        String result=orderedList.get(0);
        return result;
    }

    static List<String> CollectAllSubstrings(String inputString){
        List <String> result = new LinkedList<>();
        for(int l=0; l<=inputString.length(); l++){
            for(int p=0; p<inputString.length()-l; p++){
                result.add(inputString.substring(p,p+l+1));
            }
        }
        return result;
    }
    static Map<String,Integer> MapIntoCharactersNumber(List<String> inputList){
        Map<String, Integer> resultMap = new LinkedHashMap<>();
        for (String substring: inputList) {
            resultMap.put(substring, CountLetterTypes(substring));
        }
        return resultMap;
    }
    private static Integer CountLetterTypes(String substring) {
        Set<Character> setOfCharacters = new HashSet<>();
        for (Character c: substring.toCharArray()) {
            setOfCharacters.add(c);
        }
        return setOfCharacters.size();
    }
}
