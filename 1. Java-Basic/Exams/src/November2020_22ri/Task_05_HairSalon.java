package November2020_22ri;

import java.util.Scanner;

public class Task_05_HairSalon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int goal = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int sumIncome = 0;
        boolean isGoalReach = false;


        while (!input.equals("closed")) {
            int income = 0;

            if (input.equals("haircut")) {
                String typeHaircut = scanner.nextLine();
                switch (typeHaircut) {
                    case "mens":
                        income = 15;
                        break;
                    case "ladies":
                        income = 20;
                        break;
                    case "kids":
                        income = 10;
                        break;
                }
            } else if (input.equals("color")) {
                String typeColor = scanner.nextLine();
                switch (typeColor) {
                    case "touch up":
                        income = 20;
                        break;
                    case "full color":
                        income = 30;
                        break;
                }
            }

            sumIncome += income;

            if (sumIncome >= goal) {
                isGoalReach = true;
                System.out.println("You have reached your target for the day!");
                break;
            }

            input = scanner.nextLine();
        }

        if (!isGoalReach) {
            int neededMoney = goal - sumIncome;
            System.out.printf("Target not reached! You need %dlv. more.%n", neededMoney);
        }

        System.out.printf("Earned money: %dlv.", sumIncome);
    }
}
