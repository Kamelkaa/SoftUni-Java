package MoreExercise;

import java.util.Scanner;

public class Task_01_BackToThePast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double theMoney = Double.parseDouble(scanner.nextLine());
        double theYear = Double.parseDouble(scanner.nextLine());

        double leftMoney = theMoney - 12000;
        int yearsOld = 19;

        for (int i = 1801; i <= theYear; i++) {

            if (i % 2 == 0) {
                leftMoney = leftMoney - 12000;
            } else if (i % 2 == 1) {
                leftMoney = leftMoney - (12000 + 50 * yearsOld);
                yearsOld += 2;
            }
        }

        if (leftMoney >= 0) {
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", leftMoney);
        } else {
            System.out.printf("He will need %.2f dollars to survive.", Math.abs(leftMoney));
        }
    }
}
