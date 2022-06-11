package exercise.vehicles;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        Map<String, Vehicles> vehicles = new HashMap<>();

        vehicles.put("Car", new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2])));

        tokens = scanner.nextLine().split("\\s+");
        vehicles.put("Truck", new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2])));

        int numberLines = Integer.parseInt(scanner.nextLine());
        while (numberLines-- > 0) {
            String command = scanner.nextLine();
            String[] infoForVehicle = command.split("\\s+");

            if (infoForVehicle[0].equals("Drive")) {
                System.out.println(vehicles.get(infoForVehicle[1])
                        .drive(Double.parseDouble(infoForVehicle[2])));
            } else {
                vehicles.get(infoForVehicle[1])
                        .refuel(Double.parseDouble(infoForVehicle[2]));
            }
        }

        for (Vehicles vehicle : vehicles.values()) {
            System.out.println(vehicle.toString());
        }
    }
}
