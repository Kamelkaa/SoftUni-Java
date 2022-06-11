package November2020_15ti;

import java.util.Scanner;

public class Task03_ComputerRoom {
    public static void main(String[] args) {
        //На първия ред - месецът - текст с възможности: "march", "april", "may", "june", "july", "august"
        //На четвъртия ред - времето от деня – текст с възможности: "day", "night"
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int numbersOfHouers = Integer.parseInt(scanner.nextLine());
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        String dayOrNight = scanner.nextLine();
        double pricePerPerson = 0;

        switch (month) {
            case "march":
            case "april":
            case "may":
                if (dayOrNight.equals("day")) {
                    pricePerPerson = 10.50;
                } else if (dayOrNight.equals("night")) {
                    pricePerPerson = 8.40;
                }
                break;
            case "june":
            case "july":
            case "august":
                if (dayOrNight.equals("day")) {
                    pricePerPerson = 12.60;
                } else if (dayOrNight.equals("night")) {
                    pricePerPerson = 10.20;
                }
                break;
        }
        if (numberOfPeople >= 4) {
            pricePerPerson *= 0.90;
        }
        if (numbersOfHouers >= 5) {
            pricePerPerson *= 0.50;
        }
        double totalPrice = (pricePerPerson * numberOfPeople) * numbersOfHouers;
        System.out.printf("Price per person for one hour: %.2f%n" +
                "Total cost of the visit: %.2f", pricePerPerson, totalPrice);
    }
}
