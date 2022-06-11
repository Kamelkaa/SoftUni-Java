package Exercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Task_02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();

        ArrayDeque<Integer> stackNumbers = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            stackNumbers.push(scanner.nextInt());
        }

        for (int i = 0; i < s; i++) {
            stackNumbers.pop();
        }

        if (stackNumbers.contains(x)) {
            System.out.println("true");
        } else {
            if (stackNumbers.isEmpty()) {
                System.out.println("0");
            } else {
                System.out.println(Collections.min(stackNumbers));
            }
        }
    }
}
