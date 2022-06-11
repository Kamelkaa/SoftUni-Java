package Exercise;

import java.util.Scanner;

public class Task_07_VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalMoney = 0;

        while (!input.equals("Start")) {
            double money = Double.parseDouble(input);

            if (money != 0.1 && money != 0.2 && money != 0.5 && money != 1 && money != 2) {
                System.out.printf("Cannot accept %.2f%n", money);
                totalMoney = totalMoney;
            } else {
                totalMoney += money;
            }

            input = scanner.nextLine();
        }

        String products = scanner.nextLine();

        while (!products.equals("End")) {
            double price = 0;

            switch (products) {
                case "Nuts":
                    price = 2.0;
                    totalMoney = totalMoney - price;
                    System.out.printf("Purchased %s%n", products);
                    break;

                case "Water":
                    price = 0.7;
                    totalMoney = totalMoney - price;
                    System.out.printf("Purchased %s%n", products);
                    break;

                case "Crisps":
                    price = 1.5;
                    totalMoney = totalMoney - price;
                    System.out.printf("Purchased %s%n", products);
                    break;

                case "Soda":
                    price = 0.8;
                    totalMoney = totalMoney - price;
                    System.out.printf("Purchased %s%n", products);
                    break;

                case "Coke":
                    price = 1.0;
                    totalMoney = totalMoney - price;
                    System.out.printf("Purchased %s%n", products);
                    break;

                default:
                    System.out.println("Invalid product");
                    break;
            }

            if (totalMoney < 0) {
                System.out.println("Sorry, not enough money");
                totalMoney = totalMoney + price;
            }

            products = scanner.nextLine();
        }

        System.out.printf("Change: %.2f", totalMoney);
    }
}
