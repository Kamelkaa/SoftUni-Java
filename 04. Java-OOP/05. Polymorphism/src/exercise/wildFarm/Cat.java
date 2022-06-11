package exercise.wildFarm;

public class Cat extends Felime {
    private String breed;

    protected Cat(String animalName, String animalType, double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.insert(builder.indexOf(",") + 1, " " + this.breed + ",");

        return builder.toString();
    }
}
