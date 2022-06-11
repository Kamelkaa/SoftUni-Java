package Exercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Task_03_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stackNumbers = new ArrayDeque<>();

        for (int i = 0; i < numberOfLines; i++) {
            String[] commands = scanner.nextLine().split("\\s+");
            String command = commands[0];
            switch (command) {
                case "1":
                    int element = Integer.parseInt(commands[1]);
                    stackNumbers.push(element);
                    break;
                case "2":
                    stackNumbers.pop();
                    break;
                case "3":
                    if (!stackNumbers.isEmpty()) {
                        System.out.println(Collections.max(stackNumbers));
                    }
                    break;
            }
        }
    }
}
