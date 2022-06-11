package Exercise;

import java.util.Scanner;

public class Task_04_Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int sumSteps = 0;
        boolean isNotReached = false;

        while (sumSteps < 10000 && !input.equals("Going home")) {

            int steps = Integer.parseInt(input);
            sumSteps += steps;

            if(sumSteps >= 10000){
                int overSteps = sumSteps - 10000;
                System.out.printf("Goal reached! Good job!%n" +
                        "%d steps over the goal!", overSteps);
                break;
            }
            input = scanner.nextLine();
        }

        if (input.equals("Going home")) {
            int stepsToHome = Integer.parseInt(scanner.nextLine());
            sumSteps += stepsToHome;

            if (sumSteps < 10000) {
                int neededSteps = 10000 - sumSteps;
                System.out.printf("%d more steps to reach goal.", neededSteps);
            } else {
                int overSteps = sumSteps - 10000;
                System.out.printf("Goal reached! Good job!%n" +
                        "%d steps over the goal!", overSteps);
            }
        }
    }
}
