package Lap;

import java.util.Scanner;

public class Task_11_FruitShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String day = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        double price = 0;
        switch (day) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                if ("banana".equals(fruit)) {
                    price = quantity * 2.50;
                    System.out.printf("%.2f", price);
                } else if ("apple".equals(fruit)) {
                    price = quantity * 1.20;
                    System.out.printf("%.2f", price);
                } else if ("orange".equals(fruit)) {
                    price = quantity * 0.85;
                    System.out.printf("%.2f", price);
                } else if ("grapefruit".equals(fruit)) {
                    price = quantity * 1.45;
                    System.out.printf("%.2f", price);
                } else if ("kiwi".equals(fruit)) {
                    price = quantity * 2.70;
                    System.out.printf("%.2f", price);
                } else if ("pineapple".equals(fruit)) {
                    price = quantity * 5.50;
                    System.out.printf("%.2f", price);
                } else if ("grapes".equals(fruit)) {
                    price = quantity * 3.85;
                    System.out.printf("%.2f", price);
                } else {
                    System.out.println("error");
                }
                break;
            case "Saturday":
            case "Sunday":
                if ("banana".equals(fruit)) {
                    price = quantity * 2.70;
                    System.out.printf("%.2f", price);
                } else if ("apple".equals(fruit)) {
                    price = quantity * 1.25;
                    System.out.printf("%.2f", price);
                } else if ("orange".equals(fruit)) {
                    price = quantity * 0.90;
                    System.out.printf("%.2f", price);
                } else if ("grapefruit".equals(fruit)) {
                    price = quantity * 1.60;
                    System.out.printf("%.2f", price);
                } else if ("kiwi".equals(fruit)) {
                    price = quantity * 3.00;
                    System.out.printf("%.2f", price);
                } else if ("pineapple".equals(fruit)) {
                    price = quantity * 5.60;
                    System.out.printf("%.2f", price);
                } else if ("grapes".equals(fruit)) {
                    price = quantity * 4.20;
                    System.out.printf("%.2f", price);
                } else {
                    System.out.println("error");
                }
                break;
            default:
                System.out.println("error");
                break;
        }
    }
}

