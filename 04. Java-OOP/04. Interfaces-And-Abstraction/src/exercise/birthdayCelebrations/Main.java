package exercise.birthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        List<Birthable> birthables = new ArrayList<>();

        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");
            String type = tokens[0];
            Birthable birthable = null;

            switch (type) {
                case "Citizen":
                    //Citizen <name> <age> <id> <birthdate>
                    birthable = new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
                    break;
                case "Robot":
                    break;
                case "Pet":
                    //Pet <name> <birthdate>
                    birthable = new Pet(tokens[1], tokens[2]);
                    break;
            }
            if (birthable != null) {
                birthables.add(birthable);
            }

            line = scanner.nextLine();
        }

        String year = scanner.nextLine();
        boolean isEndWithThisYear = false;
        for (Birthable birthable : birthables) {
            if (birthable.getBirthDate().endsWith(year)) {
                System.out.println(birthable.getBirthDate());
                isEndWithThisYear = true;
            }
        }

        if (!isEndWithThisYear) {
            System.out.println("<no output>");
        }
    }
}

