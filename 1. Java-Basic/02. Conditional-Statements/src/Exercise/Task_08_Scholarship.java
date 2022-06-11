package Exercise;

import java.util.Scanner;

public class Task_08_Scholarship {
    public static void main(String[] args) {
        //доход в лв.(д), среден успех(д), минимална работна заплата(д)
        //социална стипендия = минималната работна заплата * 0.35
        //стипендия за отличен успех = среден успех * 25
        //⦁	Ако ученикът няма право да получава стипендия, се извежда: -> "You cannot get a scholarship!"
        //⦁	Ако ученикът има право да получава социална стипендия и тя е по-висока: ->
        //"You get a Social scholarship {стойност на стипендия} BGN"
        //⦁	Ако ученикът има право да получава стипендия за отличен успех и тя е по-висока или равна: ->
        //"You get a scholarship for excellent results {стойност на стипендията} BGN"
        Scanner scanner = new Scanner(System.in);

        double salary = Double.parseDouble(scanner.nextLine());
        double averageSuccess = Double.parseDouble(scanner.nextLine());
        double minimalSalary = Double.parseDouble(scanner.nextLine());

        double socialScholarship = 0;
        double scholarshipForExcellent = 0;
        boolean scholarship = false;

        if (salary < minimalSalary && averageSuccess > 4.5) {
            scholarship = true;
            socialScholarship = Math.floor(minimalSalary * 0.35);
        }
        if (averageSuccess >= 5.5) {
            scholarship = true;
            scholarshipForExcellent = Math.floor(averageSuccess * 25);
        }

        if (scholarship) {
            if (scholarshipForExcellent >= socialScholarship) {
                System.out.printf("You get a scholarship for excellent results %.0f BGN", scholarshipForExcellent);
            } else {
                System.out.printf("You get a Social scholarship %.0f BGN", socialScholarship);
            }
        } else {
            System.out.println("You cannot get a scholarship!");
        }
    }
}