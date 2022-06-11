package Exercise;

import java.util.Scanner;

public class Task_08_FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOne = Integer.parseInt(scanner.nextLine());
        int numberTwo = Integer.parseInt(scanner.nextLine());

        double factorialNumberOne = getFactorial(numberOne);
        double factorialNumberTwo = getFactorial(numberTwo);

        printTheDivision(factorialNumberOne, factorialNumberTwo);
    }

    private static double getFactorial(int number) {
        double factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

    private static void printTheDivision(double firstFactorial, double secondFactorial) {
        double division = firstFactorial / secondFactorial;
        System.out.printf("%.2f", division);
    }
}
