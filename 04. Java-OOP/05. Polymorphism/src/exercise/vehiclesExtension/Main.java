package exercise.vehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicles> vehicles = new LinkedHashMap<>();

        vehicles.put("Car", createVehicles(scanner.nextLine().split("\\s+")));
        vehicles.put("Truck", createVehicles(scanner.nextLine().split("\\s+")));

        Bus bus = createBus(scanner.nextLine().split("\\s+"));
        vehicles.put("Bus", bus);


        int numberLines = Integer.parseInt(scanner.nextLine());
        while (numberLines-- > 0) {
            String command = scanner.nextLine();
            String[] infoForVehicle = command.split("\\s+");

            if (command.contains("Drive") && command.contains("Bus")) {
                System.out.println(bus.driveWithPassengers(Double.parseDouble(infoForVehicle[2])));
            } else if (command.contains("Drive")) {
                System.out.println(vehicles.get(infoForVehicle[1])
                        .drive(Double.parseDouble(infoForVehicle[2])));
            } else {
                try {
                    vehicles.get(infoForVehicle[1])
                            .refuel(Double.parseDouble(infoForVehicle[2]));
                } catch (IllegalArgumentException exception) {
                    System.out.println(exception.getMessage());
                }
            }
        }

        for (Vehicles vehicle : vehicles.values()) {
            System.out.println(vehicle.toString());
        }
    }

    private static Bus createBus(String[] input) {
        return new Bus(Double.parseDouble(input[1]),
                Double.parseDouble(input[2]), Double.parseDouble(input[3]));
    }

    private static Vehicles createVehicles(String[] input) {
        switch (input[0]) {
            case "Car":
                return new Car(Double.parseDouble(input[1]),
                        Double.parseDouble(input[2]), Double.parseDouble(input[3]));
            case "Truck":
                return new Truck(Double.parseDouble(input[1]),
                        Double.parseDouble(input[2]), Double.parseDouble(input[3]));
            case "Bus":
                return createBus(input);
            default:
                throw new IllegalStateException("Unknown Vehicle type for " + input[0]);
        }
    }
}
