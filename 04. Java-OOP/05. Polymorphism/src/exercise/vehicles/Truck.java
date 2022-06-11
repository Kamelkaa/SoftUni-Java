package exercise.vehicles;

public class Truck extends Vehicles {
    private static final double AIR_CONDITIONER_FUEL_CONSUMPTION = 1.6;

    protected Truck(double quantity, double consumption) {
        super(quantity, consumption + AIR_CONDITIONER_FUEL_CONSUMPTION);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * 0.95);
    }
}
