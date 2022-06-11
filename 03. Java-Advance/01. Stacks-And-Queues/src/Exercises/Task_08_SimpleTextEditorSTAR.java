package Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Task_08_SimpleTextEditorSTAR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfOperations = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> stackText = new ArrayDeque<>();
        String text = "";

        for (int i = 0; i < numberOfOperations; i++) {
            String[] token = scanner.nextLine().split("\\s+");

            switch (token[0]) {
                case "1":
                    stackText.push(text);
                    text += token[1];
                    break;
                case "2":
                    stackText.push(text);
                    int count = Integer.parseInt(token[1]);
                    text = text.substring(0, text.length() - count);
                    break;
                case "3":
                    int index = Integer.parseInt(token[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    text = stackText.pop();
                    break;
            }
        }
    }
}
