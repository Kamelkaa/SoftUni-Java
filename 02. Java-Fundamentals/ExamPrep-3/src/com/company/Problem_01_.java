package com.company;

import java.util.Scanner;

public class Problem_01_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double journeyCost = Double.parseDouble(scanner.nextLine());
        int months = Integer.parseInt(scanner.nextLine());
        double savedMoney = 0;

        for (int i = 1; i <= months; i++) {

            if (i % 2 == 1 && i != 1) {
                savedMoney -= (savedMoney * 0.16);
            }

            if (i % 4 == 0) {
                savedMoney += (savedMoney * 0.25);
            }


            savedMoney += (journeyCost * 0.25);
        }


        if (savedMoney >= journeyCost) {
            double leftMoney = savedMoney - journeyCost;
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.", leftMoney);
        } else {
            double neededMoney = journeyCost - savedMoney;
            System.out.printf("Sorry. You need %.2flv. more.", neededMoney);
        }
    }
}
