package Lap;

import java.util.Scanner;

public class Task_04_SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        int magicNumber = Integer.parseInt(scanner.nextLine());
        boolean isNotFind = true;
        int counterCombinations = 0;

        for (int i = start; i <= end; i++) {
            for (int j = start; j <= end; j++) {

                int sum = i + j;
                counterCombinations++;

                if (magicNumber == sum) {
                    isNotFind = false;
                    System.out.printf("Combination N:%d (%d + %d = %d)", counterCombinations, i, j, magicNumber);
                    break;
                }
            }

            if (!isNotFind) {
                break;
            }
        }

        if (isNotFind) {
            System.out.printf("%d combinations - neither equals %d", counterCombinations, magicNumber);
        }
    }
}
