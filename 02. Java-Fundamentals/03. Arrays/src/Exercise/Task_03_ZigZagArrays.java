package Exercise;

import java.util.Scanner;

public class Task_03_ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String[] firstArray = new String[n];
        String[] secondArray = new String[n];

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            String firstNumber = input[0];
            String secondNumber = input[1];

            if (i % 2 == 0) {
                firstArray[i] = firstNumber;
                secondArray[i] = secondNumber;
            } else {
                firstArray[i] = secondNumber;
                secondArray[i] = firstNumber;
            }
        }

        System.out.println(String.join(" ", firstArray));
        System.out.println(String.join(" ", secondArray));
    }
}
