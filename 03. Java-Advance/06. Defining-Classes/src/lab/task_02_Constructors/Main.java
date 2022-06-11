package lab.task_02_Constructors;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        while (numberOfCars-- > 0) {
            String[] infoCar = scanner.nextLine().split("\\s+");

            Car car;
            if (infoCar.length == 1) {
                car = new Car(infoCar[0]);
            } else {
                car = new Car(infoCar[0], infoCar[1], Integer.parseInt(infoCar[2]));
            }

            cars.add(car);
        }

        System.out.println(cars
                .stream()
                .map(Car::toString)
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
