package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Task_05_TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayOfNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        for (int i = 0; i <= arrayOfNumbers.length - 1; i++) {
            int number = arrayOfNumbers[i];

            if (i == arrayOfNumbers.length - 1) {
                System.out.print(number);
            }

            boolean isTopInt = false;

            for (int j = i + 1; j <= arrayOfNumbers.length - 1; j++) {
                if (number > arrayOfNumbers[j]) {
                    isTopInt = true;
                } else {
                    isTopInt = false;
                    break;
                }
            }

            if (isTopInt) {
                System.out.printf("%d ", number);
            }
        }
    }
}
