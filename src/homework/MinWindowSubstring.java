package homework;


import java.util.*;

class MinWindowSubstring {

    public static String MinWindowSubstring(String[] strArr) {

        if (strArr == null || strArr.length != 2 || strArr[0].isEmpty() || strArr[1].isEmpty()){
            throw new IllegalArgumentException("Invalid input.");
        }


        String targetString = strArr[0];
        String substringToCheck = strArr[1];


        String result = "";
        boolean allCharactersExists = true;
        int movement = 0;
        do {
            for (int i=0;i <=(targetString.length()-(substringToCheck.length()))-movement;i++){
                int startPoint=i;
                int endPoint=startPoint+substringToCheck.length()+movement;

                allCharactersExists = true;

                String thisSubstring = targetString.substring(startPoint,endPoint);
                Map<Character,Integer> charMapInTargetString = new HashMap<>();
                for (char c:thisSubstring.toCharArray()) {
                    if(charMapInTargetString.containsKey(c)){
                        charMapInTargetString.put(c,charMapInTargetString.get(c)+1);
                    }else {
                        charMapInTargetString.put(c,1);
                    }
                }
                for (char c:substringToCheck.toCharArray()) {
                    if(charMapInTargetString.containsKey(c)){
                        charMapInTargetString.put(c,charMapInTargetString.get(c)-1);
                    }else {
                        allCharactersExists=false;
                    }
                }
                for (int n:charMapInTargetString.values()) {
                    if (n<0){
                        allCharactersExists=false;
                    }
                }
                if (allCharactersExists){
                    result = targetString.substring(startPoint,endPoint);
                    break;
                }else {
                    startPoint++;
                }
            }
            movement++;
        } while (!allCharactersExists && movement<=targetString.length());


        return result;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);

        System.out.print(MinWindowSubstring(new String[] {"ggggggggggggggggmaaaciekggggggamciekaaagggggggggggggggggggggggggggggmgaaagggagegiggcgggggggggkgggggggg", "maaaaciek"}));
    }

}