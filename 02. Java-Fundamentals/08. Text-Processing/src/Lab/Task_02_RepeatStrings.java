package Lab;

import java.util.Scanner;

public class Task_02_RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        StringBuilder concatenatedWords = new StringBuilder();
        for (String word : words) {
            int count = word.length();
            for (int i = 0; i < count; i++) {
                concatenatedWords.append(word);
            }
        }

        System.out.println(concatenatedWords);
    }
}
