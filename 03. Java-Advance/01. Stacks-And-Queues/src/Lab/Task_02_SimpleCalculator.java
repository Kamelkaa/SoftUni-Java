package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Task_02_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbersAndOperators = scanner.nextLine().split("\\s+");
        ArrayDeque<String> numbersStack = new ArrayDeque<>();

        for (int i = numbersAndOperators.length - 1; i >= 0; i--) {
            numbersStack.push(numbersAndOperators[i]);
        }

        while (numbersStack.size() > 1) {
            int firstNumber = Integer.parseInt(numbersStack.pop());
            String operator = numbersStack.pop();
            int secondNumber = Integer.parseInt(numbersStack.pop());

            int result = operator.equals("+")
                    ? firstNumber + secondNumber
                    : firstNumber - secondNumber;

            numbersStack.push(String.valueOf(result));
        }

        System.out.println(numbersStack.pop());
    }
}
