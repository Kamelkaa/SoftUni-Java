package com.company;

import java.util.Scanner;

public class Problem_1_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String commandsInput = scanner.nextLine();

        while (!commandsInput.equals("Sign up")) {
            String[] infoCommands = commandsInput.split("\\s+");
            String commandType = infoCommands[0];

            switch (commandType) {
                case "Case":
                    String lowerOrUpper = infoCommands[1];
                    if (lowerOrUpper.equals("lower")) {
                        username = username.toLowerCase();
                        System.out.println(username);
                    } else if (lowerOrUpper.equals("upper")) {
                        username = username.toUpperCase();
                        System.out.println(username);
                    }
                    break;
                case "Reverse":
                    int startIndex = Integer.parseInt(infoCommands[1]);
                    int endIndex = Integer.parseInt(infoCommands[2]);

                    if (startIndex >= 0 && startIndex < username.length()) {
                        if (endIndex >= 0 && endIndex < username.length()) {
                            String reversedSubstring = new StringBuilder(username.substring(startIndex, endIndex + 1)).reverse().toString();
                            System.out.println(reversedSubstring);
                        }
                    }
                    break;
                case "Cut":
                    String substringForCut = infoCommands[1];

                    if (username.contains(substringForCut)) {
                        int index = username.indexOf(substringForCut);
                        username = username.substring(0, index) + username.substring(index + substringForCut.length());
                        System.out.println(username);
                    } else {
                        System.out.printf("The word %s doesn't contain %s.%n", username, substringForCut);
                    }
                    break;
                case "Replace":
                    String charForReplace = infoCommands[1];
                    username = username.replace(charForReplace, "*");
                    System.out.println(username);
                    break;
                case "Check":
                    String neededChar = infoCommands[1];

                    if (username.contains(neededChar)) {
                        System.out.println("Valid");
                    } else {
                        System.out.printf("Your username must contain %s.%n", neededChar);
                    }
                    break;
            }
            commandsInput = scanner.nextLine();
        }
    }
}
