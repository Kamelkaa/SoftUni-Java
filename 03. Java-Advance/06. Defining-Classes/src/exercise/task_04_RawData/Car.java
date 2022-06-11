package exercise.task_04_RawData;


public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tires tires;

    public Car(String model, Engine engine, Cargo cargo, Tires tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
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

    public Cargo getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return this.model;
    }
}
