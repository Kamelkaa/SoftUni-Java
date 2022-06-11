package Exercise;

import java.util.Scanner;

public class Task_06_OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOne = Integer.parseInt(scanner.nextLine());
        int numberTwo = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();

        switch (operator) {

            case "+":
                int sum = numberOne + numberTwo;
                if (sum % 2 == 0) {
                    System.out.printf("%d + %d = %d - even", numberOne, numberTwo, sum);
                } else {
                    System.out.printf("%d + %d = %d - odd", numberOne, numberTwo, sum);
                }
                break;

            case "-":
                int sub = numberOne - numberTwo;
                if (sub % 2 == 0) {
                    System.out.printf("%d - %d = %d - even", numberOne, numberTwo, sub);
                } else {
                    System.out.printf("%d - %d = %d - odd", numberOne, numberTwo, sub);
                }
                break;

            case "*":
                int multi = numberOne * numberTwo;
                if (multi % 2 == 0) {
                    System.out.printf("%d * %d = %d - even", numberOne, numberTwo, multi);
                } else {
                    System.out.printf("%d * %d = %d - odd", numberOne, numberTwo, multi);
                }
                break;

            case "/":
                if (numberTwo == 0) {
                    System.out.printf("Cannot divide %d by zero", numberOne);
                } else {
                    double div = numberOne * 1.0 / numberTwo;
                    System.out.printf("%d / %d = %.2f", numberOne, numberTwo, div);
                }
                break;

            case "%":
                if (numberTwo == 0) {
                    System.out.printf("Cannot divide %d by zero", numberOne);
                } else {
                    int rest = numberOne % numberTwo;
                    System.out.printf("%d %% %d = %d", numberOne, numberTwo, rest);
                }
                break;
        }
    }
}
