package MidExam04;

import java.util.Scanner;

public class Task_01_NationalCourt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployeePeople = Integer.parseInt(scanner.nextLine());
        int secondEmployeePeople = Integer.parseInt(scanner.nextLine());
        int thirdEmployeePeople = Integer.parseInt(scanner.nextLine());
        int totalPeople = Integer.parseInt(scanner.nextLine());

        int countHours = 0;

        while (totalPeople > 0) {
            countHours++;

            if (countHours % 4 == 0) {
                continue;
            }

            totalPeople -= (firstEmployeePeople + secondEmployeePeople + thirdEmployeePeople);
        }

        System.out.printf("Time needed: %dh.", countHours);
    }
}
