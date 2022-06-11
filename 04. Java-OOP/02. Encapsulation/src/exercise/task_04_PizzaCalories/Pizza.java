package exercise.task_04_PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    //-	name: String
    //-	dought:  Dough
    //-	toppings: List<Topping>
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    //+ 	Piza (String, int numberOfToppings)
    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
    }

    //-	setToppings(int) : void
    private void setToppings(int count) {
        if (count < 0 || count > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>(count);
    }

    //-	setName(String) : void
    private void setName(String name) {
        if (name.trim().isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    //+	setDough(Dough) : void
    public void setDough(Dough dough) {
        this.dough = dough;
    }

    //+	getName(): String
    public String getName() {
        return this.name;
    }

    //+	addTopping (Topping) : void
    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    //+	getOverallCalories () : double
    public double getOverallCalories() {
        return this.dough.calculateCalories() + this.toppings.stream()
                .mapToDouble(Topping::calculateCalories)
                .sum();
    }
}
