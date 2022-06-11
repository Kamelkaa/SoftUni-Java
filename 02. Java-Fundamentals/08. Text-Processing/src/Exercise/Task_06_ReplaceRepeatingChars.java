package Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_06_ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] chars = scanner.nextLine().toCharArray();
        List<Character> newText = replacedSequence(chars);

        for (Character character : newText) {
            System.out.print(character);
        }
    }

    private static List<Character> replacedSequence(char[] chars) {
        List<Character> newSequence = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (!newSequence.contains(chars[i])) {
                newSequence.add(chars[i]);
            } else {
                if (chars[i] != chars[i - 1]) {
                    newSequence.add(chars[i]);
                }
            }
        }

        return newSequence;
    }
}