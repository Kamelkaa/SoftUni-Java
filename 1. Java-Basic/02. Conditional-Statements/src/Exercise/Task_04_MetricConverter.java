package Exercise;

import java.util.Scanner;

public class Task_04_MetricConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double numberForConverting = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        String output = scanner.nextLine();

        double convertedNumber = 0;

        if (input.equals("mm") && output.equals("m")) {
            convertedNumber = numberForConverting / 1000;
        } else if (input.equals("mm") && output.equals("cm")) {
            convertedNumber = numberForConverting / 10;
        } else if (input.equals("cm") && output.equals("m")) {
            convertedNumber = numberForConverting / 100;
        } else if (input.equals("cm") && output.equals("mm")) {
            convertedNumber = numberForConverting * 10;
        } else if (input.equals("m") && output.equals("mm")) {
            convertedNumber = numberForConverting * 1000;
        } else if (input.equals("m") && output.equals("cm")) {
            convertedNumber = numberForConverting * 100;
        }

        System.out.printf("%.3f", convertedNumber);
    }
}
