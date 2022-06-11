package Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Task_10_PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> peopleNames = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Party!")) {
            String operation = input.split("\\s+")[0];
            String command = input.split("\\s+")[1];
            String criteria = input.split("\\s+")[2];

            Predicate<String> predicate = getPredicate(command, criteria);

            if (predicate != null) {
                int countSize = peopleNames.size();
                for (int i = 0; i < peopleNames.size(); i++) {
                    if (countSize-- == 0) {
                        break;
                    }

                    if (predicate.test(peopleNames.get(i))) {
                        switch (operation) {
                            case "Remove":
                                peopleNames.remove(i);
                                i--;
                                break;
                            case "Double":
                                peopleNames.add(peopleNames.get(i));
                                break;
                        }
                    }
                }
            }

            input = scanner.nextLine();
        }

        if (peopleNames.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(peopleNames);
            System.out.println(String.join(", ", peopleNames) + " are going to the party!");
        }
    }

    private static Predicate<String> getPredicate(String command, String criteria) {
        switch (command) {
            case "Length":
                return name -> name.length() == Integer.parseInt(criteria);
            case "StartsWith":
                return name -> name.startsWith(criteria);
            case "EndsWith":
                return name -> name.endsWith(criteria);
        }
        return null;
    }
}
