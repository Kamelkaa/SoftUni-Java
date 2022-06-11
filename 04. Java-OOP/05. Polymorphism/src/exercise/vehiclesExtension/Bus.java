package exercise.vehiclesExtension;

public class Bus extends Vehicles {
    private static final double AIR_CONDITIONER_FUEL_CONSUMPTION = 1.4;

    protected Bus(double quantity, double consumption, double capacity) {
        super(quantity, consumption, capacity);
    }

    public String driveWithPassengers(double distance) {
        super.addConsumption(AIR_CONDITIONER_FUEL_CONSUMPTION);
        String out = super.drive(distance);
        super.subtractConsumptions(AIR_CONDITIONER_FUEL_CONSUMPTION);

        return out;
    }
}
