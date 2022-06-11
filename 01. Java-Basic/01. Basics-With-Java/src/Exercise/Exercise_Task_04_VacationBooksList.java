package Exercise;

import java.util.Scanner;

public class Exercise_Task_04_VacationBooksList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPages = Integer.parseInt(scanner.nextLine());
        int pagerPerHour = Integer.parseInt(scanner.nextLine());
        int numberOfDays = Integer.parseInt(scanner.nextLine());

        int allHours = numberOfPages / pagerPerHour;
        int hoursPerDay = allHours / numberOfDays;

        System.out.println(hoursPerDay);
    }
}
