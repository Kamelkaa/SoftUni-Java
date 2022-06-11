package exercise.task_04_RawDataSecondSolution;


public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tires tires;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public Car(String model, Tires tires) {
        this.model = model;
        this.tires = tires;
    }

    public String getModel() {
        return model;
    }

    public Tires getTires() {
        return tires;
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return model;
    }
}
