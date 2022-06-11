package MoreExercise;

import java.util.Scanner;

public class MoreExercise_Task_06_Fishland {
    public static void main(String[] args) {
        //скумрия лв., цаца лв., маламуд кг., сафрид кг., миди кг.
        //1. цена паламуд = 0.60 * скумрия лв. + скумрия лв.
        //2. цена сафрид = 0.80 * цаца лв. + цаца лв.
        //3. цена миди = миди кг. * 7.50
        //4. сметка = цена паламуд + цена сафрид + цена миди
        Scanner scanner = new Scanner(System.in);

        double mackerelPrice = Double.parseDouble(scanner.nextLine());
        double spratPrice = Double.parseDouble(scanner.nextLine());
        double bonitoWeight = Double.parseDouble(scanner.nextLine());
        double horseMackerelWeight = Double.parseDouble(scanner.nextLine());
        double musselsWeight = Double.parseDouble(scanner.nextLine());

        double bonitoBill = (0.60 * mackerelPrice + mackerelPrice) * bonitoWeight;
        double horseMackerelBill = (0.80 * spratPrice + spratPrice) * horseMackerelWeight;
        double musselsBill = 7.50 * musselsWeight;

        double allBill = bonitoBill + horseMackerelBill + musselsBill;

        System.out.printf("%.2f", allBill);
    }
}
