package Lap;

import java.util.Scanner;

public class Lab_Task_09_YardGreening {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double yardForGreening = Double.parseDouble(scanner.nextLine());
        double price = yardForGreening * 7.61;
        double discount = price * 0.18;
        double finalPrice = price - discount;

        System.out.printf("The final price is: %.2f lv.%n" +
                        "The discount is: %.2f lv.",
                finalPrice, discount);
    }
}
