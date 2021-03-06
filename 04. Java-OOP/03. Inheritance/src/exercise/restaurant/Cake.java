package exercise.restaurant;

import java.math.BigDecimal;

public class Cake extends Dessert {
    //fields: name, price, grams + calories
    private static final BigDecimal CAKE_PRICE = new BigDecimal(5);
    private static final double CAKE_GRAMS = 250;
    private static final double CAKE_CALORIES = 1000;

    public Cake(String name) {
        super(name, CAKE_PRICE, CAKE_GRAMS, CAKE_CALORIES);
    }
}
