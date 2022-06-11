package exam06_23Oct2019.healthyHeaven;

public class Vegetable {
    //name: String
    //calories: int
    private String name;
    private int calories;

    public Vegetable(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    //" - {name} have {calories} calories"
    @Override
    public String toString() {
        return String.format(" - %s have %d calories", this.name, this.calories);
    }
}
