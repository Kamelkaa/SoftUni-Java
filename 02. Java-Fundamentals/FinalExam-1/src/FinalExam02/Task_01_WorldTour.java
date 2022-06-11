package FinalExam02;

import java.util.Scanner;

public class Task_01_WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stops = scanner.nextLine();
        String commandsInput = scanner.nextLine();

        while (!commandsInput.equals("Travel")) {
            String[] commands = commandsInput.split(":");
            String typeCommand = commands[0];

            switch (typeCommand) {
                case "Add Stop":
                    int index = Integer.parseInt(commands[1]);
                    String string = commands[2];

                    if (index >= 0 && index < stops.length()) {
                        stops = stops.substring(0, index) + string + stops.substring(index);
                    }
                    System.out.println(stops);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(commands[1]);
                    int endIndex = Integer.parseInt(commands[2]);

                    if (startIndex >= 0 && startIndex < stops.length()) {
                        if (endIndex >= 0 && endIndex < stops.length()) {
                            stops = stops.substring(0, startIndex) + stops.substring(endIndex + 1);
                        }
                    }
                    System.out.println(stops);
                    break;
                case "Switch":
                    String oldString = commands[1];
                    String newString = commands[2];

                    if (stops.contains(oldString)) {
                        stops = stops.replace(oldString, newString);
                    }
                    System.out.println(stops);
                    break;
            }

            commandsInput = scanner.nextLine();
        }

        System.out.printf("Ready for world tour! Planned stops: %s", stops);
    }
}
