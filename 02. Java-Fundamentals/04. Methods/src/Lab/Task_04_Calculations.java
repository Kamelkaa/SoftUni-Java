package Lab;

import java.util.Scanner;

public class Task_04_Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());

        switch (command) {
            case "add":
                addNumbers(firstNumber, secondNumber);
                break;
            case "multiply":
                multiplyNumbers(firstNumber, secondNumber);
                break;
            case "subtract":
                subtractNumbers(firstNumber, secondNumber);
                break;
            case "divide":
                divideNumbers(firstNumber, secondNumber);
        }

    }

    private static void addNumbers(int firstNumber, int secondNumber) {
        System.out.println(firstNumber + secondNumber);
    }

    private static void multiplyNumbers(int firstNumber, int secondNumber) {
        System.out.println(firstNumber * secondNumber);
    }

    private static void subtractNumbers(int firstNumber, int secondNumber) {
        System.out.println(firstNumber - secondNumber);
    }

    private static void divideNumbers(int firstNumber, int secondNumber) {
        System.out.println(firstNumber / secondNumber);
    }
}
