package exercise.wildFarm;

public abstract class Food {
    protected int quantity;

    protected Food(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
