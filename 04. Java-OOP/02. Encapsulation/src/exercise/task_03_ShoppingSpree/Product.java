package exercise.task_03_ShoppingSpree;

public class Product {
    //-	name: String
    //-	cost: double
    private String name;
    private double cost;

    //+ Product (String,  double)
    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    //-	setCost (double): void
    private void setCost(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.cost = cost;
    }

    //-	setName (String): void
    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}
