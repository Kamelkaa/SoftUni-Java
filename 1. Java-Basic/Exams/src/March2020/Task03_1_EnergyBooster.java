package March2020;

import java.util.Scanner;

public class Task03_1_EnergyBooster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String sizeSet = scanner.nextLine();
        int numbers = Integer.parseInt(scanner.nextLine());

        double pricePerSet = 0.0;

        switch (sizeSet) {

            case "small":
                if (fruit.equals("Watermelon")) {
                    pricePerSet = 2 * 56;
                } else if (fruit.equals("Mango")) {
                    pricePerSet = 2 * 36.66;
                } else if (fruit.equals("Pineapple")) {
                    pricePerSet = 2 * 42.10;
                } else if (fruit.equals("Raspberry")) {
                    pricePerSet = 2 * 20.00;
                }
                break;

            case "big":
                if (fruit.equals("Watermelon")) {
                    pricePerSet = 5 * 28.70;
                } else if (fruit.equals("Mango")) {
                    pricePerSet = 5 * 19.60;
                } else if (fruit.equals("Pineapple")) {
                    pricePerSet = 5 * 24.80;
                } else if (fruit.equals("Raspberry")) {
                    pricePerSet = 5 * 15.20;
                }
                break;
        }
        double priceForAllSets = pricePerSet * numbers;
        double priceAfterDiscount = 0.0;

        if (priceForAllSets >= 400 && priceForAllSets <= 1000) {
            priceAfterDiscount = priceForAllSets * 0.85;
            System.out.printf("%.2f lv.", priceAfterDiscount);
        } else if (priceForAllSets > 1000) {
            priceAfterDiscount = priceForAllSets * 0.50;
            System.out.printf("%.2f lv.", priceAfterDiscount);
        } else if (priceForAllSets < 400) {
            System.out.printf("%.2f lv.", priceForAllSets);
        }
    }
}
