package MoreExercise;

import java.util.Scanner;

public class Task_04_ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        StringBuilder reversedText = new StringBuilder();

        for (int i = text.length() - 1; i >= 0; i--) {
            char currentChar = text.charAt(i);
            reversedText.append(currentChar);
        }

        String result = reversedText.toString();
        System.out.print(result);
    }
}
