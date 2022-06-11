package MidExam05;

import java.util.Scanner;

public class Task_02_MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rooms = scanner.nextLine().split("\\|");
        int health = 100;
        int bitcoins = 0;
        int countRooms = 0;

        for (String currentRoom : rooms) {
            String command = currentRoom.split(" ")[0];
            int number = Integer.parseInt(currentRoom.split(" ")[1]);

            switch (command) {
                case "potion":
                    int amount = 0;
                    int currantHealth = health;
                    health += number;

                    if (health >= 100) {
                        amount = 100 - currantHealth;
                        health = 100;
                    } else {
                        amount = number;
                    }

                    System.out.printf("You healed for %d hp.%n", amount);
                    System.out.printf("Current health: %d hp.%n", health);
                    countRooms++;
                    break;

                case "chest":
                    bitcoins += number;
                    System.out.printf("You found %d bitcoins.%n", number);
                    countRooms++;
                    break;

                default:
                    health -= number;

                    if (health > 0) {
                        System.out.printf("You slayed %s.%n", command);
                        countRooms++;
                    } else {
                        countRooms++;

                        System.out.printf("You died! Killed by %s.%n", command);
                        System.out.printf("Best room: %d%n", countRooms);
                        return;
                    }
                    break;
            }
        }

        System.out.printf("You've made it!%n" +
                "Bitcoins: %d%n" +
                "Health: %d%n", bitcoins, health);
    }
}
