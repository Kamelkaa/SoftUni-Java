package Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Task_6_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputBrackets = scanner.nextLine();

        ArrayDeque<Character> stackOpenBrackets = new ArrayDeque<>();
        boolean areBalanced = false;

        for (int i = 0; i < inputBrackets.length(); i++) {
            char currentBracket = inputBrackets.charAt(i);

            if (currentBracket == '(' || currentBracket == '{' || currentBracket == '[') {
                stackOpenBrackets.push(currentBracket);
            } else if (currentBracket == ')' || currentBracket == '}' || currentBracket == ']') {
                if (stackOpenBrackets.isEmpty()) {
                    areBalanced = false;
                    break;
                }

                char lastOpenBracket = stackOpenBrackets.pop();

                if (lastOpenBracket == '(' && currentBracket == ')') {
                    areBalanced = true;
                } else if (lastOpenBracket == '{' && currentBracket == '}') {
                    areBalanced = true;
                } else if (lastOpenBracket == '[' && currentBracket == ']') {
                    areBalanced = true;
                } else {
                    areBalanced = false;
                    break;
                }
            }
        }

        if (areBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
