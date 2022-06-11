package FinalExam03;

import java.util.*;

public class Task_03_NeedForSpeed3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> cars = new TreeMap<>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] carInfo = scanner.nextLine().split("\\|");
            String carName = carInfo[0];
            int carMileage = Integer.parseInt(carInfo[1]);
            int carFuel = Integer.parseInt(carInfo[2]);

            cars.put(carName, Arrays.asList(carMileage, carFuel)); //0 -> mileage, 1 -> fuel
        }

        String commandsInput = scanner.nextLine();

        while (!commandsInput.equals("Stop")) {
            String[] commands = commandsInput.split(" : ");
            String command = commands[0];
            String car = commands[1];

            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(commands[2]);
                    int fuelForDrive = Integer.parseInt(commands[3]);

                    if (cars.get(car).get(1) < fuelForDrive) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        int mileageLeft = cars.get(car).get(0) + distance;
                        cars.get(car).set(0, mileageLeft);

                        int fuelLeft = cars.get(car).get(1) - fuelForDrive;
                        cars.get(car).set(1, fuelLeft);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",
                                car, distance, fuelForDrive);
                    }

                    if (cars.get(car).get(0) >= 100000) {
                        cars.remove(car);
                        System.out.printf("Time to sell the %s!%n", car);
                    }
                    break;
                case "Refuel":
                    int fuelForRefuel = Integer.parseInt(commands[2]);
                    int refuel = cars.get(car).get(1) + fuelForRefuel;

                    if (refuel > 75) {
                        refuel = 75;
                    }

                    System.out.printf("%s refueled with %d liters%n", car, refuel - cars.get(car).get(1));
                    cars.get(car).set(1, refuel);
                    break;
                case "Revert":
                    int kilometersForDecrease = Integer.parseInt(commands[2]);
                    int decreasedKm = cars.get(car).get(0) - kilometersForDecrease;

                    if (decreasedKm < 10000) {
                        decreasedKm = 10000;
                        cars.get(car).set(0, decreasedKm);
                        break;
                    }

                    System.out.printf("%s mileage decreased by %d kilometers%n", car, cars.get(car).get(0) - decreasedKm);
                    cars.get(car).set(0, decreasedKm);
                    break;
            }

            commandsInput = scanner.nextLine();
        }

        cars.entrySet().stream()
                .sorted((n1, n2) -> n2.getValue().get(0).compareTo(n1.getValue().get(0)))
                .forEach(entry -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                        entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));
    }
}
