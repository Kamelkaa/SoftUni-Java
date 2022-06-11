package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Task_08_TheHeiganDance {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        int[][] field = new int[15][15];

        Double helganHealthPoints = 3000000d;
        int playerHealthPoints = 18500;
        Double playerDamage = Double.parseDouble(reader.readLine());

        int eruptionDamage = 6000;
        int plagueDamage = 3500;
        boolean hasPlague = false;

        int playerRow = 7;
        int playerCol = 7;

        String currentMagic = "";

        while (helganHealthPoints > 0 && playerHealthPoints > 0) {

            playerHealthPoints -= hasPlague ? plagueDamage : 0;
            hasPlague = false;
            helganHealthPoints -= playerDamage;

            if (helganHealthPoints <= 0) {
                continue;
            }

            String[] tokens = reader.readLine().split(" ");
            int rowCast = Integer.parseInt(tokens[1]);
            int colCast = Integer.parseInt(tokens[2]);
            currentMagic = tokens[0];

            currentMagic = playerHealthPoints <= 0 ? "Cloud" : currentMagic;
            if (isInside(playerRow, playerCol, rowCast, colCast)) {
                if (!isInside(playerRow - 1, playerCol, rowCast, colCast) && (playerRow - 1 >= 0)) {
                    playerRow -= 1;
                } else if (!isInside(playerRow, playerCol + 1, rowCast, colCast) && (playerCol + 1 < 15)) {
                    playerCol += 1;
                } else if (!isInside(playerRow + 1, playerCol, rowCast, colCast) && (playerRow + 1 < 15)) {
                    playerRow += 1;
                } else if (!isInside(playerRow, playerCol - 1, rowCast, colCast) && (playerCol - 1 >= 0)) {
                    playerCol -= 1;
                } else {
                    playerHealthPoints -= "Eruption".equals(tokens[0]) ? eruptionDamage : plagueDamage;
                    hasPlague = "Cloud".equals(tokens[0]);
                }
            }
        }

        currentMagic = currentMagic.equals("Cloud") ? "Plague Cloud" : "Eruption";
        if (helganHealthPoints <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", helganHealthPoints);
        }

        if (playerHealthPoints <= 0) {
            System.out.println("Player: Killed by " + currentMagic);
        } else {
            System.out.println("Player: " + playerHealthPoints);
        }

        System.out.println("Final position: " + playerRow + ", " + playerCol);
    }

    private static boolean isInside(int playerX, int playerY, int xcast, int ycast) {
        return (Math.abs(xcast - playerX) <= 1) && (Math.abs(ycast - playerY) <= 1);
    }
}

