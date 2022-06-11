package MidExam2021_02;

import java.util.Scanner;

public class Task_01_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceOfFlour = Double.parseDouble(scanner.nextLine());
        double priceOfEgg = Double.parseDouble(scanner.nextLine());
        double priceOfApron = Double.parseDouble(scanner.nextLine());

        double allPackages = 0;
        int count = 0;

        for (int i = 1; i <= students; i++) {
            count++;
            int currentStudent = i;
            double priceOfPackage = (currentStudent * 10 * priceOfEgg) + (priceOfApron * Math.ceil(currentStudent * 1.2)) + priceOfFlour * currentStudent;
            allPackages += priceOfPackage;
            if (count % 5 == 0) {
                int free = students / 5;
                allPackages -= free;
            }
        }


        if (budget >= allPackages) {
            System.out.printf("Items purchased for %.2f$.", allPackages);
        } else {
            double neededMoney = allPackages - budget;
            System.out.printf("%.2f$ more needed.", neededMoney);
        }
    }
}
