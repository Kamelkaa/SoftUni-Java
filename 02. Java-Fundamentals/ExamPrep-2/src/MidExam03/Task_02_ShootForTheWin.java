package MidExam03;

import java.util.Arrays;
import java.util.Scanner;

public class Task_02_ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targetsValue = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();
        int count = 0;

        while (!input.equals("End")) {
            int index = Integer.parseInt(input);

            if (index > targetsValue.length - 1 || index < 0) {
                input = scanner.nextLine();
                continue;
            }

            int currentValue = targetsValue[index];
            if (targetsValue[index] == -1) {
                input = scanner.nextLine();
                continue;
            } else {
                targetsValue[index] = -1;
                count++;
            }

            for (int i = 0; i < targetsValue.length; i++) {
                if (currentValue < targetsValue[i] && targetsValue[i] != -1) {
                    targetsValue[i] -= currentValue;
                } else if (currentValue >= targetsValue[i] && targetsValue[i] != -1) {
                    targetsValue[i] += currentValue;
                }
            }

            input = scanner.nextLine();
        }

        String[] strArray = Arrays.stream(targetsValue)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        System.out.printf("Shot targets: %d -> %s", count, String.join(" ", strArray));
    }
}
