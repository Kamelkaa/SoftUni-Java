package exam06_23Oct2019.healthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private List<Vegetable> products;
    private String name;

    public Salad(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    //Method getTotalCalories() – returns the sum of all vegetable calories in the salad
    public int getTotalCalories() {
        return this.products.stream().mapToInt(Vegetable::getCalories).sum();
    }

    //Method getProductCount() - returns the number of products
    public int getProductCount() {
        return this.products.size();
    }

    //Method add(Vegetable product) – adds an entity to the products
    public void add(Vegetable product) {
        this.products.add(product);
    }

    //Override toString() – by the format bellow:
    //"* Salad {name} is {calories} calories and have {product count} products:
    //{Vegetable 1}
    //{Vegetable 2}..
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("* Salad %s is %d calories and have %d products:",
                this.name, getTotalCalories(), getProductCount()))
                .append(System.lineSeparator());
        for (Vegetable vegetable : products) {
            builder.append(vegetable.toString()).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
