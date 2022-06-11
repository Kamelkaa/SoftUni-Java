package Exercise;

import java.util.Scanner;

public class Exercise_Task_05_BirthdayParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rentForHall = Integer.parseInt(scanner.nextLine());

        double cakePrice = 0.20 * rentForHall;
        double drinksPrice = 0.55 * cakePrice;
        double animator = rentForHall / 3.0;

        double budget = cakePrice + drinksPrice + animator + rentForHall;

        System.out.println(budget);
    }
}
