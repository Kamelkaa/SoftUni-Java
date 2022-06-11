package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Task_03_DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> binaryRepresentation = new ArrayDeque<>();

        if (number == 0) {
            System.out.println(0);
        } else {
            while (number != 0) {
                binaryRepresentation.push(number % 2);
                number = number / 2;
            }
        }

        for (int binaryNumber : binaryRepresentation) {
            System.out.print(binaryNumber);
        }
    }
}
