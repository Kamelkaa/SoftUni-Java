package Exercise;

import java.util.Scanner;

public class Task_05_AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        int sum = getSum(firstNumber, secondNumber);
        int subtract = getSubtract(sum, thirdNumber);

        System.out.println(subtract);
    }

    private static int getSum(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    private static int getSubtract(int sum, int thirdNumber) {
        return sum - thirdNumber;
    }
}
