package lab.task_01_CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        while (numberOfCars-- > 0) {
            String[] infoCar = scanner.nextLine().split("\\s+");

            Car car = new Car();
            car.setBrand(infoCar[0]);
            car.setModel(infoCar[1]);
            car.setHorsePower(Integer.parseInt(infoCar[2]));

            System.out.println(car);
        }
    }
}
