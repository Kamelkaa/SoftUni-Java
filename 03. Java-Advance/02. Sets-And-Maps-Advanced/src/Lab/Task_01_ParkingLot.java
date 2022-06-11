package Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Task_01_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashSet<String> carNumbers = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String direction = input.split(", ")[0];
            String carNumber = input.split(", ")[1];

            switch (direction) {
                case "IN":
                    carNumbers.add(carNumber);
                    break;
                case "OUT":
                    carNumbers.remove(carNumber);
                    break;
            }

            input = scanner.nextLine();
        }

        if (carNumbers.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            System.out.println(String.join(System.lineSeparator(), carNumbers));
        }
    }
}
