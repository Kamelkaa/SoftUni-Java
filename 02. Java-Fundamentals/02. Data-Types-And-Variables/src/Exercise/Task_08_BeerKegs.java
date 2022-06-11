package Exercise;

import java.util.Scanner;

public class Task_08_BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersOfKegs = Integer.parseInt(scanner.nextLine());
        String biggestKeg = "";
        double maxVolume = 0;

        for (int i = 0; i < numbersOfKegs; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            double volume = Math.PI * Math.pow(radius, 2) * height;

            if (maxVolume <= volume) {
                maxVolume = volume;
                biggestKeg = model;
            }
        }

        System.out.println(biggestKeg);
    }
}
