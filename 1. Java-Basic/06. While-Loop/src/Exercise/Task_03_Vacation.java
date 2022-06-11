package Exercise;

import java.util.Scanner;

public class Task_03_Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double neededMoney = Double.parseDouble(scanner.nextLine());
        double currentMoney = Double.parseDouble(scanner.nextLine());
        int counterDays = 0;
        int countSpendDays = 0;

        while (neededMoney > currentMoney) {
            String typeOfAction = scanner.nextLine();
            double money = Double.parseDouble(scanner.nextLine());
            counterDays++;

            if (typeOfAction.equals("spend")) {
                currentMoney -= money;
                countSpendDays++;

                if (currentMoney < 0) {
                    currentMoney = 0;
                }

                if (countSpendDays == 5) {
                    System.out.printf("You can't save the money.%n" +
                            "%d", counterDays);
                    break;
                }
            }
            if (typeOfAction.equals("save")) {
                countSpendDays = 0;
                currentMoney += money;
            }
        }

        if (neededMoney <= currentMoney) {
            System.out.printf("You saved the money for %d days.", counterDays);
        }
    }
}
