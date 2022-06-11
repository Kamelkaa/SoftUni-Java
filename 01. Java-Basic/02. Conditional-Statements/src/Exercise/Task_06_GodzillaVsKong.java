package Exercise;

import java.util.Scanner;

public class Task_06_GodzillaVsKong {
    public static void main(String[] args) {
        //бюджет на филма(д), бр. статисти(инт), цена на облекло(д)
        //декор = 0.10 * бюджет
        //цена на статисти = бр. статисти + цена на облекло
        //при повече от 150 статиста -> отстъпка за облеколото 10%
        //ако бюджета не стига -> "Not enough money!" %н "Wingard needs {парите недостигащи за филма} leva more."
        //ако бщджета стига -> "Action!" %н "Wingard starts filming with {останалите пари} leva left."

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int numberOfSupernumerary = Integer.parseInt(scanner.nextLine());
        double priceOfClothing = Double.parseDouble(scanner.nextLine());

        double decor = budget * 0.10;
        double priceForAllSupernumerary = numberOfSupernumerary * priceOfClothing;

        if (numberOfSupernumerary > 150) {
            priceForAllSupernumerary = priceForAllSupernumerary - (priceForAllSupernumerary * 0.10);
        }

        double moneyCost = decor + priceForAllSupernumerary;

        if (budget < moneyCost) {
            double lackOfMoney = moneyCost - budget;
            System.out.printf("Not enough money!%n" +
                    "Wingard needs %.2f leva more.", lackOfMoney);
        } else if (budget >= moneyCost) {
            double remainingMoney = budget - moneyCost;
            System.out.printf("Action!%n" +
                    "Wingard starts filming with %.2f leva left.", remainingMoney);
        }
    }
}
