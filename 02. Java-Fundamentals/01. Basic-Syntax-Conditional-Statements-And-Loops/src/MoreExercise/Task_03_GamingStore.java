package MoreExercise;

import java.util.Scanner;

public class Task_03_GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double currentBalance = Double.parseDouble(scanner.nextLine());
        String nameOfGame = scanner.nextLine();
        double spendMoney = 0;
        double leftMoney = currentBalance;

        while (!nameOfGame.equals("Game Time")) {
            double gamePrice = 0;


            switch (nameOfGame) {
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    gamePrice = 39.99;
                    break;
                case "CS: OG":
                    gamePrice = 15.99;
                    break;
                case "Zplinter Zell":
                    gamePrice = 19.99;
                    break;
                case "Honored 2":
                    gamePrice = 59.99;
                    break;
                case "RoverWatch":
                    gamePrice = 29.99;
                    break;
                default:
                    System.out.println("Not Found");
                    break;
            }

            if (leftMoney >= gamePrice && gamePrice != 0) {
                leftMoney -= gamePrice;
                System.out.printf("Bought %s%n", nameOfGame);
            } else if (leftMoney < gamePrice) {
                System.out.println("Too Expensive");
                gamePrice = 0;
            }
            if (leftMoney == 0) {
                System.out.println("Out of money!");
                break;
            }
            spendMoney += gamePrice;
            nameOfGame = scanner.nextLine();
        }

        if (leftMoney > 0) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", spendMoney, leftMoney);
        }
    }
}
