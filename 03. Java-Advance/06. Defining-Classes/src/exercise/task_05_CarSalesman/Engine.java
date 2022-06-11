package exercise.task_05_CarSalesman;

public class Engine {
    private String model;
    private int power;

    private int displacement;
    private String efficiency;

    public Engine() {

    }

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = -1;
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this(model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        if (this.displacement == -1) {
            return String.format("%s:%n" +
                            "Power: %d%n" +
                            "Displacement: n/a%n" +
                            "Efficiency: %s",
                    model, power, efficiency);
        } else {
            return String.format("%s:%n" +
                            "Power: %d%n" +
                            "Displacement: %d%n" +
                            "Efficiency: %s",
                    model, power, displacement, efficiency);
        }
    }
}
