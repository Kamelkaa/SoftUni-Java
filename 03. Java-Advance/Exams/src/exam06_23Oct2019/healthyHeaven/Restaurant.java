package exam06_23Oct2019.healthyHeaven;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Restaurant {
    private List<Salad> data;
    private String name;

    public Restaurant(String name) {
        this.name = name;
        this.data = new ArrayList<>();
    }

    //Method add(Salad salad) – adds an entity to the data
    public void add(Salad salad) {
        this.data.add(salad);
    }

    //Method buy(String name) – removes a salad by given name, if such exists, and returns boolean
    public boolean buy(String name) {
        return this.data.removeIf(salad -> salad.getName().equals(name));
    }

    //Mehod getHealthiestSalad() – returns the healthiest salad
    public Salad getHealthiestSalad() {
        return this.data.stream().min(Comparator.comparing(Salad::getTotalCalories)).orElse(null);
    }

    //Method generateMenu() - returns a string in the following format:
    //"{name} have {salad count} salads:
    //{Salad 1}
    //{Salad 2}
    public String generateMenu() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s have %d salads:", this.name, this.data.size()))
                .append(System.lineSeparator());
        for (Salad salad : data) {
            builder.append(salad.toString()).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
