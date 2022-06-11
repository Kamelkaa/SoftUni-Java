package exercise.vehiclesExtension;

public class Truck extends Vehicles {
    private static final double AIR_CONDITIONER_FUEL_CONSUMPTION = 1.6;

    protected Truck(double quantity, double consumption, double capacity) {
        super(quantity, consumption + AIR_CONDITIONER_FUEL_CONSUMPTION, capacity);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * 0.95);
    }
}
