package Lab;

import java.util.Scanner;
import java.util.TreeSet;

public class Task_02_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> vipGuests = new TreeSet<>();
        TreeSet<String> regularGuests = new TreeSet<>();

        String guest = scanner.nextLine();

        while (!guest.equals("PARTY")) {
            AddGuests(vipGuests, regularGuests, guest);
            guest = scanner.nextLine();
        }

        guest = scanner.nextLine();

        while (!guest.equals("END")) {
            RemoveGuests(vipGuests, regularGuests, guest);
            guest = scanner.nextLine();
        }

        System.out.println(vipGuests.size() + regularGuests.size());
        printSetIsNotEmpty(vipGuests);
        printSetIsNotEmpty(regularGuests);
    }

    public static void AddGuests(TreeSet<String> vipGuests, TreeSet<String> regularGuests, String guest) {
        if (Character.isDigit(guest.charAt(0))) {
            vipGuests.add(guest);
        } else {
            regularGuests.add(guest);
        }
    }

    public static void RemoveGuests(TreeSet<String> vipGuests, TreeSet<String> regularGuests, String guest) {
        if (Character.isDigit(guest.charAt(0))) {
            vipGuests.remove(guest);
        } else {
            regularGuests.remove(guest);
        }
    }

    private static void printSetIsNotEmpty(TreeSet<String> set) {
        if (!set.isEmpty()) {
            System.out.println(String.join(System.lineSeparator(), set));
        }
    }
}
