package MidExam03;

import java.util.Scanner;

public class Task_01_CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int energyLeft = energy;
        int counterWins = 0;

        while (!input.equals("End of battle")) {
            int distance = Integer.parseInt(input);
            energyLeft -= distance;

            if (energyLeft < 0) {
                energyLeft += distance;
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", counterWins, energyLeft);
                return;
            }

            counterWins++;
            if (counterWins % 3 == 0) {
                energyLeft += counterWins;
            }
            input = scanner.nextLine();
        }

        System.out.printf("Won battles: %d. Energy left: %d", counterWins, energyLeft);
    }
}
//X