package Lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Task_08_MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());

        double result = matchPower(number, power);
        System.out.println(new DecimalFormat("0.####").format(result));
    }

    private static double matchPower(double number, int power) {
        return Math.pow(number, power);
    }
}
