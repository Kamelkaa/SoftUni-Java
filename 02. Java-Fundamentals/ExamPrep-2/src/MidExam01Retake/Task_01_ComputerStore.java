package MidExam01Retake;

import java.util.Scanner;

public class Task_01_ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceWithoutTaxes = 0;

        String input = scanner.nextLine();

        while (!input.equals("special") && !input.equals("regular")) {
            double price = Double.parseDouble(input);

            if (price < 0) {
                System.out.println("Invalid price!");
            } else {
                priceWithoutTaxes += price;
            }

            input = scanner.nextLine();
        }

        double taxes = priceWithoutTaxes * 0.20;
        double totalPrice = priceWithoutTaxes + taxes;

        if(input.equals("special")){
            totalPrice *= 0.90;
        }

        if (totalPrice > 0) {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", priceWithoutTaxes);
            System.out.printf("Taxes: %.2f$%n" +
                    "-----------%n", taxes);
            System.out.printf("Total price: %.2f$", totalPrice);
        } else {
            System.out.println("Invalid order!");
        }
    }
}
