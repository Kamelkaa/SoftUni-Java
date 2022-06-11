package Exercise;

import java.util.Scanner;

public class Task_01_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] train = new int[n];

        for (int i = 0; i < n; i++) {
            train[i] = Integer.parseInt(scanner.nextLine());
        }

        int sum = 0;
        for (int numbersOfPeople : train) {
            System.out.printf("%d ", numbersOfPeople);
            sum += numbersOfPeople;
        }

        System.out.print("\n" + sum);
    }
}
