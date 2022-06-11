package Lap;

import java.util.Scanner;

public class Task_07Exm_ToyShop {
    public static void main(String[] args) {
        //Цена на екскурзията
        //Над 50 играчки -> 25% отстъпка и намем на магазин -> 10%
        //⦁	Пъзел / puzzle - 2.60 лв.
        //⦁	Говореща кукла / talkingDoll - 3 лв.
        //⦁	Плюшено мече / teddyBear - 4.10 лв.
        //⦁	Миньон / minion - 8.20 лв.
        //⦁	Камионче / truck - 2 лв.
        //Парите са достатъчни -> "Yes! {оставащите пари} lv left."
        //Парите не са достатъчни -> "Not enough money! {недостигащите пари} lv needed."
        Scanner scanner = new Scanner(System.in);

        double tripPrice = Double.parseDouble(scanner.nextLine());
        int puzzle = Integer.parseInt(scanner.nextLine());
        int talkingDoll = Integer.parseInt(scanner.nextLine());
        int teddyBear = Integer.parseInt(scanner.nextLine());
        int minion = Integer.parseInt(scanner.nextLine());
        int truck = Integer.parseInt(scanner.nextLine());

        int numberOfToys = puzzle + talkingDoll + teddyBear + minion + truck;
        double allToysPrice = puzzle * 2.60 + talkingDoll * 3 + teddyBear * 4.10 + minion * 8.20 + truck * 2;
        double earnings = 0;

        if (numberOfToys >= 50) {
            double discount = allToysPrice - (allToysPrice * 0.25);
            earnings = discount - (discount * 0.10);

        } else {
            earnings = allToysPrice - (allToysPrice * 0.10);
        }
        if (earnings >= tripPrice) {
            double remainingMoney = earnings - tripPrice;
            System.out.printf("Yes! %.2f lv left.", remainingMoney);
        } else if (earnings < tripPrice) {
            double remainingMoney = tripPrice - earnings;
            System.out.printf("Not enough money! %.2f lv needed.", remainingMoney);
        }
    }
}
