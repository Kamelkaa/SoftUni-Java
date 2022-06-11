package Exercise;

import java.util.Scanner;

public class Task_03_Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        String typeOfGroup = scanner.nextLine();
        String day = scanner.nextLine();
        double pricePerPerson = 0;
        double totalPrice = 1;

        switch (typeOfGroup) {
            case "Students":
                if (day.equals("Friday")) {
                    pricePerPerson = 8.45;
                } else if (day.equals("Saturday")) {
                    pricePerPerson = 9.80;
                } else if (day.equals("Sunday")) {
                    pricePerPerson = 10.46;
                }

                totalPrice = numberOfPeople * pricePerPerson;

                if (numberOfPeople >= 30) {
                    totalPrice *= 0.85;
                }
                break;

            case "Business":
                if (day.equals("Friday")) {
                    pricePerPerson = 10.90;
                } else if (day.equals("Saturday")) {
                    pricePerPerson = 15.60;
                } else if (day.equals("Sunday")) {
                    pricePerPerson = 16;
                }
                totalPrice = numberOfPeople * pricePerPerson;

                if (numberOfPeople >= 100) {
                    totalPrice = (numberOfPeople - 10) * pricePerPerson;
                }
                break;

            case "Regular":
                if (day.equals("Friday")) {
                    pricePerPerson = 15;
                } else if (day.equals("Saturday")) {
                    pricePerPerson = 20;
                } else if (day.equals("Sunday")) {
                    pricePerPerson = 22.50;
                }
                totalPrice = numberOfPeople * pricePerPerson;

                if (numberOfPeople >= 10 && numberOfPeople <= 20) {
                    totalPrice *= 0.95;
                }
                break;
        }

        System.out.printf("Total price: %.2f", totalPrice);
    }
}