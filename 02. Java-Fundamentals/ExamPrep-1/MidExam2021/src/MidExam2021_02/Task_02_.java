package MidExam2021_02;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_02_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> friends = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String commands = scanner.nextLine();
        int blacklistedNames = 0;
        int lostNames = 0;

        while (!commands.equals("Report")) {
            String command = commands.split(" ")[0];
            String name = commands.split(" ")[1];

            switch (command) {
                case "Blacklist":

                    if (friends.contains(name)) {
                        int index = friends.indexOf(name);
                        friends.remove(name);
                        friends.add(index, "Blacklisted");
                        blacklistedNames++;
                        System.out.printf("%s was blacklisted.%n", name);
                    } else {
                        System.out.printf("%s was not found.%n", name);
                    }
                    break;

                case "Error":
                    int index = Integer.parseInt(commands.split(" ")[1]);
                    String currantName = friends.get(index);

                    if (!currantName.equals("Blacklisted") && !currantName.equals("Lost")) {
                        friends.remove(currantName);
                        friends.add(index, "Lost");
                        System.out.printf("%s was lost due to an error.%n", currantName);
                        lostNames++;
                    }
                    break;

                case "Change":
                    int currentIndex = Integer.parseInt(commands.split(" ")[1]);
                    String newName = commands.split(" ")[2];
                    String nameBeforeChange = friends.get(currentIndex);

                    if (currentIndex >= 0 || currentIndex < friends.size()) {
                        friends.remove(nameBeforeChange);
                        friends.add(currentIndex, newName);
                        System.out.printf("%s changed his username to %s.%n", nameBeforeChange, newName);
                    }
                    break;
            }

            commands = scanner.nextLine();
        }

        System.out.printf("Blacklisted names: %d%n" +
                        "Lost names: %d%n",
                blacklistedNames, lostNames);
        System.out.print(String.join(" ", friends));
    }
}
