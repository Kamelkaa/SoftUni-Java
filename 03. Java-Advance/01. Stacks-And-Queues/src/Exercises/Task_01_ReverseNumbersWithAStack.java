package Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Task_01_ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputNumbers = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> stackNumbers = new ArrayDeque<>();

        for (String number : inputNumbers) {
            stackNumbers.push(Integer.parseInt(number));
        }

        for (int number : stackNumbers) {
            System.out.print(number + " ");
        }
    }
}
