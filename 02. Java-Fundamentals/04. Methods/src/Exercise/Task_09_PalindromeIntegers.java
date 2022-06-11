package Exercise;

import java.util.Scanner;

public class Task_09_PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            boolean isPalindrome = isPalindromeOrNot(input);
            if (isPalindrome) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }

            input = scanner.nextLine();
        }
    }

    private static boolean isPalindromeOrNot(String input) {
        StringBuilder reversedInput = new StringBuilder();

        for (int i = input.length() - 1; i >= 0; i--) {
            char currentChar = input.charAt(i);
            reversedInput.append(currentChar);
        }

        String reversed = reversedInput.toString();
        return reversed.equals(input);
    }
}
