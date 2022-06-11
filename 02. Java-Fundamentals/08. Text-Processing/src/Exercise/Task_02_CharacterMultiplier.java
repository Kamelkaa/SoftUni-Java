package Exercise;

import java.util.Scanner;

public class Task_02_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        String firstString = strings[0];
        String secondString = strings[1];

        int shorterWord = Math.min(firstString.length(), secondString.length());
        int longestWord = Math.max(firstString.length(), secondString.length());
        char[] firstWord = firstString.toCharArray();
        char[] secondWord = secondString.toCharArray();

        int multiply = multiplyCharacters(firstWord, secondWord, shorterWord);
        int sumCharacters = sumLeftCharacters(firstWord, secondWord, shorterWord, longestWord);

        int sum = multiply + sumCharacters;
        System.out.println(sum);

    }

    private static int multiplyCharacters(char[] firstWord, char[] secondWord, int shortWord) {
        int multiply = 0;
        for (int i = 0; i < shortWord; i++) {
            multiply += firstWord[i] * secondWord[i];
        }

        return multiply;
    }

    private static int sumLeftCharacters(char[] firstWord, char[] secondWord, int shortWord, int longWord) {
        int sum = 0;
        if (firstWord.length > secondWord.length) {
            for (int i = shortWord; i < longWord; i++) {
                sum += firstWord[i];
            }
        } else if (firstWord.length < secondWord.length) {
            for (int i = shortWord; i < longWord; i++) {
                sum += secondWord[i];
            }
        }

        return sum;
    }
}
