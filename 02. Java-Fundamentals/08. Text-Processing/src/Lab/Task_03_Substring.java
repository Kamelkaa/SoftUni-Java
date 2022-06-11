package Lab;

import java.util.Scanner;

public class Task_03_Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String wordToRemove = scanner.nextLine();
        String inputWord = scanner.nextLine();

        while ((inputWord.contains(wordToRemove))) {
            inputWord = removeWord(inputWord, wordToRemove);
        }

        System.out.println(inputWord);
    }

    private static String removeWord(String inputWord, String wordToRemove) {
        int startIndex = inputWord.indexOf(wordToRemove);
        int endIndex = startIndex + wordToRemove.length();

        return inputWord.substring(0, startIndex) + inputWord.substring(endIndex);
    }
}
