package Task_06_VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Vehicle> vehicles = new ArrayList<>();
        double powerCars = 0;
        double powerTrucks = 0;
        int countCars = 0;
        int countTrucks = 0;

        while (!input.equals("End")) {
            //{typeOfVehicle} {model} {color} {horsepower}
            String type = input.split(" ")[0];

            String model = input.split(" ")[1];
            String color = input.split(" ")[2];
            int horsepower = Integer.parseInt(input.split(" ")[3]);

            Vehicle vehicle = new Vehicle(type, model, color, horsepower);
            vehicles.add(vehicle);

            switch (type) {
                case "Car":
                    countCars++;
                    powerCars += vehicle.getHorsepower();
                    break;
                case "Truck":
                    countTrucks++;
                    powerTrucks += vehicle.getHorsepower();
                    break;
            }

            input = scanner.nextLine();
        }

        String modelOfVehicle = scanner.nextLine();

        while (!modelOfVehicle.equals("Close the Catalogue")) {
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getModel().equals(modelOfVehicle)) {
                    //Type: {typeOfVehicle}
                    //Model: {modelOfVehicle}
                    //Color: {colorOfVehicle}
                    //Horsepower: {horsepowerOfVehicle}
                    System.out.printf("Type: %s%n" +
                                    "Model: %s%n" +
                                    "Color: %s%n" +
                                    "Horsepower: %d%n",
                            vehicle.getTypeOfVehicle(), vehicle.getModel(), vehicle.getColor(), vehicle.getHorsepower());
                }
            }

            modelOfVehicle = scanner.nextLine();
        }

        double averagePowerCars = powerCars / countCars;
        double averagePowerTrucks = powerTrucks / countTrucks;

        System.out.printf("Cars have average horsepower of %.2f.%nTrucks have average horsepower of %.2f.",
                averagePowerCars, averagePowerTrucks);
    }
}
