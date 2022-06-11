package exercise.task_04_RawData;

public class Tires {
    private double tireOnePressure;
    private int tireOneAge;
    private double tireTwoPressure;
    private int tireTwoAge;
    private double tireThreePressure;
    private int tireThreeAge;
    private double tireFourPressure;
    private int tireFourAge;

    public Tires(double tireOnePressure, int tireOneAge, double tireTwoPressure, int tireTwoAge, double tireThreePressure,
                 int tireThreeAge, double tireFourPressure, int tireFourAge) {
        this.tireOnePressure = tireOnePressure;
        this.tireOneAge = tireOneAge;
        this.tireTwoPressure = tireTwoPressure;
        this.tireTwoAge = tireTwoAge;
        this.tireThreePressure = tireThreePressure;
        this.tireThreeAge = tireThreeAge;
        this.tireFourPressure = tireFourPressure;
        this.tireFourAge = tireFourAge;
    }

    public boolean isSmallerThenOne() {
        return tireOnePressure < 1 || tireTwoPressure < 1 || tireThreePressure < 1 || tireFourPressure < 1;
    }
}
