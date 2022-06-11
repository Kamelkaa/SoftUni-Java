package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem_02_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] itemsWithPrices = scanner.nextLine().split("\\|");
        double budget = Double.parseDouble(scanner.nextLine());
        double sumBuyItems = 0;

        List<Double> newPrices = new ArrayList<>();

        for (int i = 0; i < itemsWithPrices.length; i++) {
            String type = itemsWithPrices[i].split("->")[0];
            double priceForCurrentItem = Double.parseDouble(itemsWithPrices[i].split("->")[1]);
            double newPriceForItem = 0;

            switch (type) {
                case "Clothes":
                    if (priceForCurrentItem <= 50.00 && budget >= priceForCurrentItem) {
                        budget -= priceForCurrentItem;
                        sumBuyItems += priceForCurrentItem;
                        newPriceForItem = priceForCurrentItem * 1.40;
                        newPrices.add(newPriceForItem);
                    }
                    break;
                case "Shoes":
                    if (priceForCurrentItem <= 35.00 && budget >= priceForCurrentItem) {
                        budget -= priceForCurrentItem;
                        sumBuyItems += priceForCurrentItem;
                        newPriceForItem = priceForCurrentItem * 1.40;
                        newPrices.add(newPriceForItem);
                    }
                    break;
                case "Accessories":
                    if (priceForCurrentItem <= 20.50 && budget >= priceForCurrentItem) {
                        budget -= priceForCurrentItem;
                        sumBuyItems += priceForCurrentItem;
                        newPriceForItem = priceForCurrentItem * 1.40;
                        newPrices.add(newPriceForItem);
                    }
                    break;
            }
        }

        double sumNewItemsPrice = newPrices.stream().mapToDouble(Double::doubleValue).sum();
        double profit = sumNewItemsPrice - sumBuyItems;

        double newBudget = budget + sumNewItemsPrice;

        for (Double newPrice : newPrices) {
            System.out.printf("%.2f ", newPrice);
        }

        System.out.printf("%nProfit: %.2f%n", profit);

        if (newBudget >= 150) {
            System.out.println("Hello, France!");
        } else {
            System.out.println("Time to go.");
        }
    }
}
