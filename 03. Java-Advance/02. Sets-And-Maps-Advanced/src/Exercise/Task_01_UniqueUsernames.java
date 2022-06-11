package Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Task_01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfUsernames = Integer.parseInt(scanner.nextLine());
        LinkedHashSet<String> usernames = new LinkedHashSet<>();

        while (numberOfUsernames-- > 0) {
            String username = scanner.nextLine();
            usernames.add(username);
        }

        usernames.forEach(System.out::println);
    }
}
