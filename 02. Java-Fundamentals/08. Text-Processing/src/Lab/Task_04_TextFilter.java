package Lab;

import java.util.Scanner;

public class Task_04_TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String bannedWord : bannedWords) {
            if (text.contains(bannedWord)) {
                String wordToStars = makeWordToStars(bannedWord);
                text = text.replace(bannedWord, wordToStars);
            }
        }

        System.out.println(text);
    }

    private static String makeWordToStars(String bannedWord) {
        StringBuilder stars = new StringBuilder();
        for (int i = 0; i < bannedWord.length(); i++) {
            stars.append("*");
        }

        return stars.toString();
    }
}
