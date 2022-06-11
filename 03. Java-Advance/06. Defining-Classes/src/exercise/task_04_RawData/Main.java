package exercise.task_04_RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] inputInfo = scanner.nextLine().split("\\s+");
            String model = inputInfo[0];
            int engineSpeed = Integer.parseInt(inputInfo[1]);
            int enginePower = Integer.parseInt(inputInfo[2]);
            int cargoWeight = Integer.parseInt(inputInfo[3]);
            String cargoType = inputInfo[4];
            double tireOnePressure = Double.parseDouble(inputInfo[5]);
            int tireOneAge = Integer.parseInt(inputInfo[6]);
            double tireTwoPressure = Double.parseDouble(inputInfo[7]);
            int tireTwoAge = Integer.parseInt(inputInfo[8]);
            double tireThreePressure = Double.parseDouble(inputInfo[9]);
            int tireThreeAge = Integer.parseInt(inputInfo[10]);
            double tireFourPressure = Double.parseDouble(inputInfo[11]);
            int tireFourAge = Integer.parseInt(inputInfo[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tires tires = new Tires(tireOnePressure, tireOneAge, tireTwoPressure, tireTwoAge,
                    tireThreePressure, tireThreeAge, tireFourPressure, tireFourAge);
            Car car = new Car(model, engine, cargo, tires);

            cars.add(car);
        }

        String command = scanner.nextLine();
        if (command.equals("fragile")) {
            cars.stream()
                    .filter(p -> p.getCargo().getType().equals("fragile"))
                    .filter(p -> p.getTires().isSmallerThenOne())
                    .forEach(System.out::println);
        } else if (command.equals("flamable")) {
            cars.stream()
                    .filter(p -> p.getCargo().getType().equals("flamable"))
                    .filter(p -> p.getEngine().getPower() > 250)
                    .forEach(System.out::println);
        }
    }
}
