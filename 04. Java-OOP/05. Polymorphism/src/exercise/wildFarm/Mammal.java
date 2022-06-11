package exercise.wildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    protected String livingRegion;

    protected Mammal(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("##.##");
        return String.format(
                "%s[%s, %s, %s, %d]",
                super.animalType,
                super.animalName,
                formatter.format(super.animalWeight),
                this.livingRegion,
                super.foodEaten
        );
    }
}
