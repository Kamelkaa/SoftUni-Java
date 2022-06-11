package exercise.vehicles;

import java.text.DecimalFormat;

public class Vehicles {
    protected double quantity;
    protected double consumption;

    protected Vehicles(double quantity, double consumption) {
        this.quantity = quantity;
        this.consumption = consumption;
    }

    public String drive(double distance) {
        //Car/Truck needs refueling
        DecimalFormat format = new DecimalFormat("##.##");
        double fuelNeeded = this.consumption * distance;
        if (fuelNeeded > this.quantity) {
            return String.format("%s needs refueling",
                    this.getClass().getSimpleName());
        }

        //Car/Truck travelled {distance} km
        this.quantity -= fuelNeeded;
        return String.format("%s travelled %s km",
                this.getClass().getSimpleName(),
                format.format(distance));
    }

    public void refuel(double liters) {
        this.quantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",
                this.getClass().getSimpleName(),
                this.quantity);
    }
}
