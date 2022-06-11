package MoreExercise;

import java.util.Scanner;

public class MoreExercise_Task_04_VegetableMarket {
    public static void main(String[] args) {
        //цена на кг. зеленчуци(д), цена на кг. плодове(д), общо кг. зеленчуци(инт), общо кг. плодове(инт)
        //1. сумата за зеленчуците = цена на кг. зеленчуци(д) * общо кг. зеленчуци(инт)
        //2. сумата за плодовете = цена на кг. плодове(д) * общо кг. плодове(инт)
        //3. обща сума в евро = (сумата за зеленчуците + сумата за плодовете) * 1.94
        //1 евро = 1.94 лв.
        Scanner scanner = new Scanner(System.in);

        double priceVegetables = Double.parseDouble(scanner.nextLine());
        double priceFruits = Double.parseDouble(scanner.nextLine());
        int amountVegetables = Integer.parseInt(scanner.nextLine());
        int amountFruits = Integer.parseInt(scanner.nextLine());

        double sumVegetables = priceVegetables * amountVegetables;
        double sumFruits = priceFruits * amountFruits;

        double proceedsInEuro = (sumVegetables + sumFruits) / 1.94;

        System.out.printf("%.2f", proceedsInEuro);
    }
}
