package exercise.wildFarm;

public class Felime extends Mammal {
    protected Felime(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }
}
