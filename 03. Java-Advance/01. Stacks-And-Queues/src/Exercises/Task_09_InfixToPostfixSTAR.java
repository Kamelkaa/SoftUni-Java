package Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Task_09_InfixToPostfixSTAR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] expression = scanner.nextLine().split(" ");
        ArrayDeque<String> output = infixToPostfix(expression);

        for (String element : output) {
            System.out.print(element + " ");
        }
    }

    private static ArrayDeque<String> infixToPostfix(String[] expression) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queueOutPut = new ArrayDeque<>();

        for (String c : expression) {
            if (precedence(c) > 0) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    queueOutPut.offer(stack.pop());
                }
                stack.push(c);
            } else if (c.equals(")")) {
                String x = stack.pop();
                while (!x.equals("(")) {
                    queueOutPut.offer(x);
                    x = stack.pop();
                }
            } else if (c.equals("(")) {
                stack.push(c);
            } else {
                queueOutPut.offer(c);
            }
        }

        for (int i = 0; i <= stack.size(); i++) {
            queueOutPut.offer(stack.pop());
        }

        return queueOutPut;
    }

    public static int precedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
        }
        return -1;
    }
}
