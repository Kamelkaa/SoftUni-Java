package FinalExam05;

import java.util.Scanner;

public class Task_01_ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rowActivationKey = scanner.nextLine();

        String commandInput = scanner.nextLine();
        while (!commandInput.equals("Generate")) {
            String[] types = commandInput.split(">>>");
            String commandName = types[0];

            switch (commandName) {
                case "Contains":
                    String substring = types[1];

                    if (rowActivationKey.contains(substring)) {
                        System.out.printf("%s contains %s%n", rowActivationKey, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String upperOrLower = types[1];
                    int startIndex = Integer.parseInt(types[2]);
                    int endIndex = Integer.parseInt(types[3]);
                    String theSubstring = rowActivationKey.substring(startIndex, endIndex);

                    if (upperOrLower.equals("Upper")) {
                        theSubstring = theSubstring.toUpperCase();
                    } else if (upperOrLower.equals("Lower")) {
                        theSubstring = theSubstring.toLowerCase();
                    }
                    rowActivationKey = rowActivationKey.substring(0, startIndex) + theSubstring + rowActivationKey.substring(endIndex);
                    System.out.println(rowActivationKey);
                    break;
                case "Slice":
                    int startDelete = Integer.parseInt(types[1]);
                    int endDelete = Integer.parseInt(types[2]);

                    rowActivationKey = rowActivationKey.substring(0, startDelete) + rowActivationKey.substring(endDelete);
                    System.out.println(rowActivationKey);
                    break;
            }

            commandInput = scanner.nextLine();
        }

        System.out.printf("Your activation key is: %s", rowActivationKey);
    }
}
