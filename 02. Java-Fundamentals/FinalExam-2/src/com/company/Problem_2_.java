package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem_2_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regexValidMessage = "(!)(?<command>[A-Z][a-z]{2,})\\1:\\[(?<message>[A-Za-z]{8,})]";

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number; i++) {
            String message = scanner.nextLine();
            Pattern patternValidMessage = Pattern.compile(regexValidMessage);
            Matcher matcherValidMessage = patternValidMessage.matcher(message);

            if (matcherValidMessage.find()) {
                String command = matcherValidMessage.group("command");
                String validMessage = matcherValidMessage.group("message");

                String encryptedMessage = getEncryptedNumbers(validMessage);
                System.out.printf("%s: %s%n", command, encryptedMessage);

            } else {
                System.out.println("The message is invalid");
            }
        }
    }

    static String getEncryptedNumbers(String message) {
        StringBuilder encMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char currentSymbol = message.charAt(i);
            encMessage.append((int) currentSymbol).append(" ");
        }
        return encMessage.toString();
    }
}
