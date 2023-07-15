package homework;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JustifiedText {

//    Write an algorithm to justify text.
//    Given a sequence of words and an integer line length k, return a list of strings which represents each line, fully justified.
//    More specifically, you should have as many words as possible in each line.
//    There should be at least one space between each word.
//    Pad extra spaces when necessary so that each line has exactly length k.
//    Spaces should be distributed as equally as possible, with the extra spaces, if any, distributed starting from the left.
//    If you can only fit one word on a line, then you should pad the right-hand side with spaces.
//    Each word is guaranteed not to be longer than k.


    public static String inputText = "the quick brown fox jumps over the lazy dog";
    public static int k = 18;

    public static void main(String args[]) {

//        Scanner s = new Scanner(System.in);
//        System.out.println("Put text to justify:");
//        inputText = s.nextLine();
//        System.out.println("Put one line length:");
//        k = s.nextInt();
        System.out.println(JustifyText(inputText, k));

    }

    private static String JustifyText(String inputText, int k) {
        String outputString = "";

        String[] inputWords = inputText.split(" ");
        List<String[]> wordsLines = new LinkedList<>();
        StringBuilder lineBuffer = new StringBuilder();
        for (int i = 0; i < inputWords.length; i++) {
            if (lineBuffer.length() + inputWords[i].length() <= k) {
                lineBuffer.append(inputWords[i] + " ");
            } else {
                wordsLines.add(lineBuffer.toString().split(" "));
                lineBuffer = new StringBuilder(inputWords[i] + " ");
            }
        }
        wordsLines.add(lineBuffer.toString().split(" "));
        List<Integer[]> spaceLines = new LinkedList<>();
        for (int i = 0; i < wordsLines.size(); i++) {
            spaceLines.add(new Integer[wordsLines.get(i).length - 1]);
            Arrays.fill(spaceLines.get(i), 1);
        }

        for (int i = 0; i < wordsLines.size(); i++) {
            int[] characterNumberLines = Arrays.stream(wordsLines.get(i)).mapToInt(String::length).toArray();
            int lineLength = Arrays.stream(characterNumberLines).sum() + Arrays.stream(spaceLines.get(i)).mapToInt(Integer::intValue).sum();
            int spacesToDistribute = k - lineLength;
            int counter = 0;
            while (spacesToDistribute > 0) {

                spaceLines.get(i)[counter]++;
                counter++;
                if (counter == spaceLines.get(i).length) {
                    counter = 0;
                }
                spacesToDistribute--;
            }
        }
        String[] outputTable = new String[wordsLines.size()];
        for (int i = 0; i < outputTable.length; i++) {
            StringBuilder thisLine = new StringBuilder();
            for (int j = 0; j < wordsLines.get(i).length; j++) {
                thisLine.append(wordsLines.get(i)[j]);
                if (j < spaceLines.get(i).length) {
                    thisLine.append(" ".repeat(spaceLines.get(i)[j]));
                }
            }
            outputTable[i] = thisLine.toString();
        }
        for (String outputLine : outputTable) {
            outputString += outputLine + '\n';
        }
        return outputString;
    }

}
