package Exercise;

import java.util.*;

public class Task_08_CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> companyAndUsers = new TreeMap<>();

        while (!input.equals("End")) {
            String[] currentCompanyAndUser = input.split(" -> ");
            String companyName = currentCompanyAndUser[0];
            String usersId = currentCompanyAndUser[1];

            companyAndUsers.putIfAbsent(companyName, new ArrayList<>());

            if (!companyAndUsers.get(companyName).contains(usersId)) {
                companyAndUsers.get(companyName).add(usersId);
            }

            input = scanner.nextLine();
        }

        companyAndUsers.forEach((k, v) -> {
            System.out.printf("%s%n", k);
            v.forEach(e -> System.out.printf("-- %s%n", e));
        });
    }
}
