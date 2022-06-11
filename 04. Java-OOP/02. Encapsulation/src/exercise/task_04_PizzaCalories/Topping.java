package exercise.task_04_PizzaCalories;

public class Topping {
    //-	toppingType: String
    //-	weight: double
    private String toppingType;
    private double weight;

    //+ 	Topping (String, double)
    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    //-	setToppingType (String): void
    private void setToppingType(String toppingType) {
        switch (toppingType) {
            case "Meat":
            case "Veggies":
            case "Cheese":
            case "Sauce":
                this.toppingType = toppingType;
                break;
            default:
                String message = String.format("Cannot place %s on top of your pizza.", toppingType);
                throw new IllegalArgumentException(message);
        }
    }

    //-	setWeight (double): void
    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 50) {
            this.weight = weight;
        } else {
            String message = String.format("%s weight should be in the range [1..50].", this.toppingType);
            throw new IllegalArgumentException(message);
        }
    }

    //+	calculateCalories (): double
    public double calculateCalories() {
        // (2 * wight) * toppingType
        double toppingTypeModifier = this.getToppingTypeModifier(this.toppingType);
        return 2 * this.weight * toppingTypeModifier;
    }

    private double getToppingTypeModifier(String toppingType) {
        switch (toppingType) {
            case "Meat":
                return 1.2;
            case "Veggies":
                return 0.8;
            case "Cheese":
                return 1.1;
            case "Sauce":
                return 0.9;
            default:
                return 0;
        }
    }
}
