package Lap;

import java.util.Scanner;

public class Task_05_Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String destination = scanner.nextLine();

        while (!destination.equals("End")) {
            double budget = Double.parseDouble(scanner.nextLine());
            double totalAmountSaved = 0;

            while (totalAmountSaved < budget) {
                double amountSaved = Double.parseDouble(scanner.nextLine());
                totalAmountSaved += amountSaved;
            }

            System.out.printf("Going to %s!%n", destination);
            destination = scanner.nextLine();
        }
    }
}

