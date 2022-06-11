package aquarium.entities.fish;

public class SaltwaterFish extends BaseFish {
    public static final int SIZE_FISH = 5;

    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
        setSize(SIZE_FISH);
    }

    @Override
    public void eat() {
        int newSize = getSize() + 3;
        setSize(newSize);
    }
}
