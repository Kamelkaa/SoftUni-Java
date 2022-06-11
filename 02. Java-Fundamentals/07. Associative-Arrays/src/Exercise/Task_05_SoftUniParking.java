package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_05_SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        Map<String, String> registeredUsers = new LinkedHashMap<>();

        for (int i = 0; i < numberOfCommands; i++) {
            String[] command = scanner.nextLine().split(" ");

            String currentCommand = command[0];
            String userName = command[1];

            switch (currentCommand) {
                case "register":
                    String licenseNumber = command[2];
                    if (!registeredUsers.containsKey(userName)) {
                        registeredUsers.put(userName, licenseNumber);
                        System.out.printf("%s registered %s successfully%n", userName, licenseNumber);
                    } else {
                        System.out.printf("ERROR: already registered with plate number %s%n", licenseNumber);
                    }
                    break;
                case "unregister":
                    if (!registeredUsers.containsKey(userName)) {
                        System.out.printf("ERROR: user %s not found%n", userName);
                    } else {
                        registeredUsers.remove(userName);
                        System.out.printf("%s unregistered successfully%n", userName);
                    }
                    break;
            }
        }

        registeredUsers.forEach((k, v) -> System.out.printf("%s => %s%n", k, v));
    }
}
