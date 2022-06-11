package November2020_22ri;

import java.util.Scanner;

public class Task_02_FootballKit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceTShirt = Double.parseDouble(scanner.nextLine());
        double neededSum = Double.parseDouble(scanner.nextLine());

        double priceShorts = 0.75 * priceTShirt;
        double priceSocks = 0.20 * priceShorts;
        double priceSneakers = 2 * (priceTShirt + priceShorts);
        double totalPriceWithDiscount = 0.85 * (priceTShirt + priceShorts + priceSocks + priceSneakers);

        if (totalPriceWithDiscount >= neededSum) {
            System.out.println("Yes, he will earn the world-cup replica ball!");
            System.out.printf("His sum is %.2f lv.", totalPriceWithDiscount);
        } else {
            System.out.println("No, he will not earn the world-cup replica ball.");

            double neededMoney = neededSum - totalPriceWithDiscount;
            System.out.printf("He needs %.2f lv. more.", neededMoney);
        }
    }
}
