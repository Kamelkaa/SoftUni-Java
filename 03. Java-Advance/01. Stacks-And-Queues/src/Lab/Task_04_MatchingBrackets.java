package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Task_04_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();
        ArrayDeque<Integer> subExpressionStack = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            if (currentChar == '(') {
                subExpressionStack.push(i);
            } else if (currentChar == ')') {
                int startIndex = subExpressionStack.pop();
                String result = expression.substring(startIndex, i + 1);

                System.out.println(result);
            }
        }
    }
}
