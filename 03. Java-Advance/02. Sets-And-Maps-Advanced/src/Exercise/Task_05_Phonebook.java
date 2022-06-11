package Exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Task_05_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, String> phonebook = new LinkedHashMap<>();

        while (!input.equals("search")) {
            String name = input.split("-")[0];
            String number = input.split("-")[1];

            phonebook.put(name, number);

            input = scanner.nextLine();
        }

        String nameToFind = scanner.nextLine();
        while (!nameToFind.equals("stop")) {

            if (phonebook.containsKey(nameToFind)) {
                System.out.println(nameToFind + " -> " + phonebook.get(nameToFind));
            } else {
                System.out.printf("Contact %s does not exist.%n", nameToFind);
            }

            nameToFind = scanner.nextLine();
        }
    }
}
