package MidExam03;

import java.util.*;
import java.util.stream.Collectors;

public class Task_03_MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targetsValue = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String command = input.split(" ")[0];
            int index = Integer.parseInt(input.split(" ")[1]);

            switch (command) {
                case "Shoot":
                    int power = Integer.parseInt(input.split(" ")[2]);
                    if (index >= 0 && index < targetsValue.size()) {
                        targetsValue.add(index, targetsValue.get(index) - power);
                        targetsValue.remove(index + 1);
                        if (targetsValue.get(index) <= 0) {
                            targetsValue.remove(index);
                        }
                    }
                    break;

                case "Add":
                    int value = Integer.parseInt(input.split(" ")[2]);
                    if (index >= 0 && index < targetsValue.size()) {
                        targetsValue.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;

                case "Strike":
                    int radius = Integer.parseInt(input.split(" ")[2]);
                    if (index >= 0 && index < targetsValue.size()) {
                        if (index - radius < 0 || index + radius > targetsValue.size()) {
                            System.out.println("Strike missed!");
                        } else {
                            targetsValue.remove(index + 1);
                            targetsValue.remove(index);
                            targetsValue.remove(index - 1);
                        }
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        List<String> str = targetsValue.stream().map(String::valueOf)
                .collect(Collectors.toList());
        System.out.printf("%s", String.join("|", str));
    }
}
