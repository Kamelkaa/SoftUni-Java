package Exercise;

import java.util.Scanner;

public class Task_07_WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());
        int sumOfQuantities = 0;
        int capacity = 255;

        for (int i = 0; i < numberOfLines; i++) {
            int quantity = Integer.parseInt(scanner.nextLine());
            if (sumOfQuantities + quantity <= capacity) {
                sumOfQuantities += quantity;
            } else {
                System.out.println("Insufficient capacity!");
            }
        }

        System.out.println(sumOfQuantities);
    }
}
