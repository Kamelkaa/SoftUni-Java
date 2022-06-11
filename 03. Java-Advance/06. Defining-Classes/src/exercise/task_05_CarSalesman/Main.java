package exercise.task_05_CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOgEngines = Integer.parseInt(scanner.nextLine());
        List<Engine> engines = new ArrayList<>();

        for (int i = 0; i < numberOgEngines; i++) {
            String[] infoEngine = scanner.nextLine().split("\\s+");
            String model = infoEngine[0];
            int power = Integer.parseInt(infoEngine[1]);

            Engine engine = null;
            if (infoEngine.length == 2) {
                engine = new Engine(model, power);
            } else if (infoEngine.length == 3) {
                String lastData = infoEngine[2];
                if (Character.isDigit(lastData.charAt(0))) {
                    int displacement = Integer.parseInt(lastData);
                    engine = new Engine(model, power, displacement);
                } else {
                    String efficiency = lastData;
                    engine = new Engine(model, power, efficiency);
                }
            } else if (infoEngine.length == 4) {
                int displacement = Integer.parseInt(infoEngine[2]);
                String efficiency = infoEngine[3];
                engine = new Engine(model, power, displacement, efficiency);
            }

            engines.add(engine);
        }

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] infoCar = scanner.nextLine().split("\\s+");
            String model = infoCar[0];
            String engine = infoCar[1];

            Car car = null;
            Engine theEngine = realEngine(engine, engines);
            if (infoCar.length == 2) {
                car = new Car(model, theEngine);
            } else if (infoCar.length == 3) {
                String lastData = infoCar[2];
                if (Character.isDigit(lastData.charAt(0))) {
                    int weight = Integer.parseInt(infoCar[2]);
                    car = new Car(model, theEngine, weight);
                } else {
                    String color = lastData;
                    car = new Car(model, theEngine, color);
                }
            } else if (infoCar.length == 4) {
                int weight = Integer.parseInt(infoCar[2]);
                String color = infoCar[3];
                car = new Car(model, theEngine, weight, color);
            }

            cars.add(car);
        }

        cars.forEach(car -> {
            System.out.println(car.getModel() + ":");
            System.out.println(car.getEngine().toString());
            System.out.println(car);
        });

    }

    public static Engine realEngine(String engine, List<Engine> engines) {
        Engine current = new Engine();
        for (Engine en : engines) {
            if (engine.equals(en.getModel())) {
                current = en;
            }
        }
        return current;
    }
}
