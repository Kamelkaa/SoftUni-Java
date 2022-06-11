package November2020_15ti;

import java.util.Scanner;

public class Task01_MiningRig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int priceOfCard = Integer.parseInt(scanner.nextLine());
        int priceOfAdapter = Integer.parseInt(scanner.nextLine());
        double priceForElectricityPerDay = Double.parseDouble(scanner.nextLine());
        double winFromOneCard = Double.parseDouble(scanner.nextLine());

        int totalPriceForCards = priceOfCard * 13;
        int totalPriceForAdapters = priceOfAdapter * 13;
        int totalSpentMoney = totalPriceForCards + totalPriceForAdapters + 1000;
        double winFromCardPerDay = winFromOneCard - priceForElectricityPerDay;
        double totalWinForCardPerDay = winFromCardPerDay * 13;
        double totalDays = Math.ceil(totalSpentMoney / totalWinForCardPerDay);

        System.out.printf("%d%n%.0f", totalSpentMoney, totalDays);

    }
}
