package Exercise;

import java.util.Scanner;

public class Task_04_CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        String encryptedText = encryptedEveryChar(text);
        System.out.println(encryptedText);
    }

    private static String encryptedEveryChar(String text) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i <= text.length() - 1; i++) {
            char encryptedCurrentChar = (char) (text.charAt(i) + 3);
            encryptedText.append(encryptedCurrentChar);
        }

        return encryptedText.toString();
    }
}
