package Exercise;

import java.util.Scanner;

public class Task_09_PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double amountOfMoney = Double.parseDouble(scanner.nextLine());
        int countOfStudents = Integer.parseInt(scanner.nextLine());
        double priceOfLightsabres = Double.parseDouble(scanner.nextLine());
        double priceOfRobes = Double.parseDouble(scanner.nextLine());
        double priceOfBelts = Double.parseDouble(scanner.nextLine());

        double totalPriceLightsabres = priceOfLightsabres * Math.ceil(countOfStudents * 1.10);
        double totalPriceBelts = (countOfStudents - countOfStudents / 6) * priceOfBelts;
        double totalPriceRobes = countOfStudents * priceOfRobes;

        double totalPrice = totalPriceLightsabres + totalPriceBelts + totalPriceRobes;

        if (totalPrice <= amountOfMoney) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        } else {
            double needMoney = totalPrice - amountOfMoney;
            System.out.printf("Ivan Cho will need %.2flv more.", needMoney);

        }
    }
}
