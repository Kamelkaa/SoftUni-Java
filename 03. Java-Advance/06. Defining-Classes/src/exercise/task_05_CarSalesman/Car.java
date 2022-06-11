package exercise.task_05_CarSalesman;

public class Car {
    private String model;
    private Engine engine;

    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = -1;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        if (this.weight == -1) {
            return String.format("Weight: n/a%n" +
                    "Color: %s", color);
        } else {
            return String.format("Weight: %d%n" +
                    "Color: %s", weight, color);
        }
    }
}
