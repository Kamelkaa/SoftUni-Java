package Exercise;

import java.util.Scanner;

public class Exercise_Task_07_FruitMarket {
    public static void main(String[] args) {
        //цена на ягоди за кг., количество банани, портокали, малини и ягоди
        //1.сума за ягоди = количетво ягоди * цена на ягоди
        //2.сума на малини = количество малини * цена малини
        //цена малини = цена ягоди * 0.50
        //3.сума банани = количество банани * цена банани
        //цена банани = цена малини * 0.20
        //4.сума портокали = количество портокали * цена портокали
        //цена портокали = цена малини * 0.60
        //5. необходими пари = сума за ягоди + сума на малини + сума банани + сума портокали
        Scanner scanner = new Scanner(System.in);

        double priceBerries = Double.parseDouble(scanner.nextLine());
        double quantityBananas = Double.parseDouble(scanner.nextLine());
        double quantityOranges = Double.parseDouble(scanner.nextLine());
        double quantityRaspberries = Double.parseDouble(scanner.nextLine());
        double quantityBerries = Double.parseDouble(scanner.nextLine());

        //ягоди
        double sumBerries = quantityBerries * priceBerries;
        //малини
        double priceRaspberries = priceBerries * 0.50;
        double sumRaspberries = quantityRaspberries * priceRaspberries;
        //банани
        double priceBananas = priceRaspberries * 0.20;
        double sumBananas = quantityBananas * priceBananas;
        //портокали
        double priceOranges = priceRaspberries * 0.60;
        double sumOranges = quantityOranges * priceOranges;

        double neededMoney = sumBerries + sumRaspberries + sumBananas + sumOranges;

        System.out.printf("%.2f", neededMoney);
    }
}
