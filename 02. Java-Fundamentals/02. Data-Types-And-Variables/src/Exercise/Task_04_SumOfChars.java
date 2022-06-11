package Exercise;

import java.util.Scanner;

public class Task_04_SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 0; i < numberOfLines; i++) {
            char letterOfAlphabet = scanner.nextLine().charAt(0);
            sum += letterOfAlphabet;
        }

        System.out.printf("The sum equals: %d", sum);
    }
}
