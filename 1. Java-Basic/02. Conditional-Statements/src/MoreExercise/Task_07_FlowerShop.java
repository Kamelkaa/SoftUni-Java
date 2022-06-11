package MoreExercise;

import java.util.Scanner;

public class Task_07_FlowerShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersMagnolias = Integer.parseInt(scanner.nextLine());
        int numbersHyacinths = Integer.parseInt(scanner.nextLine());
        int numbersRoses = Integer.parseInt(scanner.nextLine());
        int numbersCactus = Integer.parseInt(scanner.nextLine());
        double price = Double.parseDouble(scanner.nextLine());

        double raisedMoney = numbersMagnolias * 3.25 + numbersHyacinths * 4 + numbersRoses * 3.50 + numbersCactus * 8;
        double leftMoney = raisedMoney * 0.95;

        if (leftMoney >= price) {
            double moneyLeft = Math.floor(leftMoney - price);
            System.out.printf("She is left with %.0f leva.", moneyLeft);

        } else {
            double neededMoney = Math.ceil(price - leftMoney);
            System.out.printf("She will have to borrow %.0f leva.", neededMoney);
        }
    }
}
