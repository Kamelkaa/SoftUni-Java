package exercise.vehicles;

public class Car extends Vehicles {
    private static final double AIR_CONDITIONER_FUEL_CONSUMPTION = 0.9;

    public Car(double quantity, double consumption) {
        super(quantity, consumption + AIR_CONDITIONER_FUEL_CONSUMPTION);
    }
}
