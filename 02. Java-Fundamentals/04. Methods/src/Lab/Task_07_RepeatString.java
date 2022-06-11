package Lab;

import java.util.Scanner;

public class Task_07_RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int repeatCount = Integer.parseInt(scanner.nextLine());

        String result = repeatedString(text, repeatCount);
        System.out.println(result);
    }

    private static String repeatedString(String text, int repeatCount) {
        StringBuilder repeatedText = new StringBuilder("");

        for (int i = 0; i < repeatCount; i++) {
            repeatedText.append(text);
        }

        return repeatedText.toString();
    }
}
