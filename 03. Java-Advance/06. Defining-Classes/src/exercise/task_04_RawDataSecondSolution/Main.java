package exercise.task_04_RawDataSecondSolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> fragile = new ArrayList<>();
        List<Car> flamable = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] inputInfo = scanner.nextLine().split("\\s+");
            String model = inputInfo[0];
            int enginePower = Integer.parseInt(inputInfo[2]);
            String cargoType = inputInfo[4];
            double tireOnePressure = Double.parseDouble(inputInfo[5]);
            double tireTwoPressure = Double.parseDouble(inputInfo[7]);
            double tireThreePressure = Double.parseDouble(inputInfo[9]);
            double tireFourPressure = Double.parseDouble(inputInfo[11]);

            Engine engine = new Engine(enginePower);
            Tires tires = new Tires(tireOnePressure, tireTwoPressure, tireThreePressure, tireFourPressure);

            if (cargoType.equals("fragile")) {
                Car car = new Car(model, tires);
                fragile.add(car);
            } else if (cargoType.equals("flamable")) {
                Car car = new Car(model, engine);
                flamable.add(car);
            }
        }

        String secondCommand = scanner.nextLine();
        if (secondCommand.equals("fragile")) {
            fragile.stream()
                    .filter(p -> p.getTires().isSmallerThenOne())
                    .forEach(System.out::println);

        } else if (secondCommand.equals("flamable")) {
            flamable.stream()
                    .filter(p -> p.getEngine().getPower() > 250)
                    .forEach(System.out::println);
        }
    }
}
