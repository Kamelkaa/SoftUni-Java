package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Task_08_MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j <= array.length - 1; j++) {
                int firstNumber = array[i];
                int secondNumber = array[j];

                if (firstNumber + secondNumber == number) {
                    System.out.printf("%d %d%n", firstNumber, secondNumber);
                }
            }
        }
    }
}
