package exercise.task_03_ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    //-	name: String
    //-	money:  double
    //-	products:  List<Product>
    private String name;
    private double money;
    private List<Product> products;

    //+ 	Person (String ,  double)
    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    //-	setName (String) : void
    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    //-	setMoney (double) : void
    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }

    //+	buyProduct (Product) : void
    public void buyProduct(Product product) {
        if (this.money >= product.getCost()) {
            this.products.add(product);
            this.money -= product.getCost();
        } else {
            String massage = String.format("%s can't afford %s", this.name, product.getName());
            throw new IllegalArgumentException(massage);
        }
    }
}
