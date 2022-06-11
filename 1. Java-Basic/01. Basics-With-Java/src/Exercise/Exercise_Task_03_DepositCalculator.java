package Exercise;

import java.util.Scanner;

public class Exercise_Task_03_DepositCalculator {
    public static void main(String[] args) {
        //сума = депозирана сума + срок на депозита * ((депозирана сума * годишен лихвен процент ) / 12)
        Scanner scanner = new Scanner(System.in);

        double depositAmount = Double.parseDouble(scanner.nextLine());
        int month = Integer.parseInt(scanner.nextLine());
        double interestRate = Double.parseDouble(scanner.nextLine());

        double sum = depositAmount + month * ((depositAmount * interestRate / 100) / 12);

        System.out.println(sum);
    }
}
