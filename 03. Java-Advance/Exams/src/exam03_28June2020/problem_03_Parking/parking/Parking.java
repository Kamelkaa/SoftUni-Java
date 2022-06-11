package exam03_28June2020.problem_03_Parking.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    //Method add(Car car) – adds an entity to the data if there is an empty cell for the car.
    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    //Method remove(String manufacturer, String model) – removes the car by given manufacturer
    //and model, if such exists, and returns boolean.
    public boolean remove(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return this.data.remove(car);
            }
        }
        return false;
    }

    //Method getLatestCar() – returns the latest car (by year) or null if have no cars.
    public Car getLatestCar() {
        Car latest = null;
        for (Car car : data) {
            if (latest == null || latest.getYear() < car.getYear()) {
                latest = car;
            }
        }
        return latest;
    }

    //Method getCar(String manufacturer, String model) – returns the car with the given
    //manufacturer and model or null if there is no such car.
    public Car getCar(String manufacturer, String model) {
        if (this.data.size() != 0) {
            for (Car car : data) {
                if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                    return car;
                }
            }
        }
        return null;
    }

    //Getter getCount() – returns the number of cars.
    public int getCount() {
        return this.data.size();
    }

    //getStatistics() – returns a String in the following format:
    //"The cars are parked in {parking type}:
    //{Car1}
    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("The cars are parked in %s:", type)).append(System.lineSeparator());
        for (Car car : data) {
            builder.append(car).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
