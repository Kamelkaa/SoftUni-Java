package com.company;

import java.util.*;

public class Problem_3_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String commands = scanner.nextLine();
        Map<String, List<String>> guestWithMeals = new TreeMap<>();
        int countUnlikeMeals = 0;

        while (!commands.equals("Stop")) {
            String[] infoCommands = commands.split("-");
            String command = infoCommands[0];
            String guest = infoCommands[1];
            String meal = infoCommands[2];

            switch (command) {
                case "Like":
                    guestWithMeals.putIfAbsent(guest, new ArrayList<>());
                    if (guestWithMeals.containsKey(guest)) {
                        List<String> meals = guestWithMeals.get(guest);
                        if (!meals.contains(meal)) {
                            meals.add(meal);
                        }
                    }
                    break;
                case "Unlike":
                    if (!guestWithMeals.containsKey(guest)) {
                        System.out.printf("%s is not at the party.%n", guest);
                    } else {
                        List<String> containsMeals = guestWithMeals.get(guest);
                        if (containsMeals.contains(meal)) {
                            containsMeals.remove(meal);
                            System.out.printf("%s doesn't like the %s.%n", guest, meal);
                            countUnlikeMeals++;
                        } else {
                            System.out.printf("%s doesn't have the %s in his/her collection.%n", guest, meal);
                        }
                    }
                    break;
            }
            commands = scanner.nextLine();
        }

        guestWithMeals.entrySet().stream().sorted((e1, e2) -> {
            int result = e2.getValue().size() - e1.getValue().size();
            if (result == 0) {
                result = e1.getKey().compareTo(e2.getKey());
            }
            return result;
        }).forEach(entry -> System.out.printf("%s: %s%n", entry.getKey(), String.join(", ", entry.getValue())));

        System.out.printf("Unliked meals: %d", countUnlikeMeals);
    }
}
