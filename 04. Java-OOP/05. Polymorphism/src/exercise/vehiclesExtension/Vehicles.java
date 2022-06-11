package exercise.vehiclesExtension;

import java.text.DecimalFormat;

public class Vehicles {
    protected double quantity;
    protected double consumption;
    protected double capacity;

    protected Vehicles(double quantity, double consumption, double capacity) {
        this.capacity = capacity;
        this.setQuantity(quantity);
        this.consumption = consumption;
    }

    private void setQuantity(double quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (quantity > this.capacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.quantity = quantity;
    }

    protected void addConsumption(double consumption) {
        this.consumption += consumption;
    }

    protected void subtractConsumptions(double consumption) {
        this.consumption -= consumption;
    }

    public String drive(double distance) {
        double fuelNeeded = this.consumption * distance;
        return driveWithFuelNeeded(distance, fuelNeeded);
    }

    private String driveWithFuelNeeded(double distance, double fuelNeeded) {
        if (fuelNeeded > this.quantity) {
            return String.format("%s needs refueling",
                    this.getClass().getSimpleName());
        }

        this.setQuantity(this.quantity - fuelNeeded);

        DecimalFormat format = new DecimalFormat("##.##");
        return String.format("%s travelled %s km",
                this.getClass().getSimpleName(),
                format.format(distance));
    }

    public void refuel(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (liters > this.capacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.setQuantity(this.quantity + liters);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",
                this.getClass().getSimpleName(),
                this.quantity);
    }
}
