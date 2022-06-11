package Exercise;

import java.util.Scanner;

public class Task_06_Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int salary = Integer.parseInt(scanner.nextLine());
        int penalty = 0;

        for (int i = 0; i < n; i++) {
            String site = scanner.nextLine();

            switch (site) {
                case "Facebook":
                    penalty += 150;
                    break;
                case "Instagram":
                    penalty += 100;
                    break;
                case "Reddit":
                    penalty += 50;
                    break;
            }
        }

        if (salary <= penalty) {
            System.out.println("You have lost your salary.");
        } else {
            int restOfSalary = salary - penalty;
            System.out.printf("%d", restOfSalary);
        }
    }
}
