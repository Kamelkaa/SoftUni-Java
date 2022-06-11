package exercise.task_04_RawDataSecondSolution;

public class Tires {
    private double tireOnePressure;
    private double tireTwoPressure;
    private double tireThreePressure;
    private double tireFourPressure;

    public Tires(double tireOnePressure, double tireTwoPressure, double tireThreePressure, double tireFourPressure) {
        this.tireOnePressure = tireOnePressure;
        this.tireTwoPressure = tireTwoPressure;
        this.tireThreePressure = tireThreePressure;
        this.tireFourPressure = tireFourPressure;
    }

    public boolean isSmallerThenOne() {
        return tireOnePressure < 1 || tireTwoPressure < 1 || tireThreePressure < 1 || tireFourPressure < 1;
    }
}
