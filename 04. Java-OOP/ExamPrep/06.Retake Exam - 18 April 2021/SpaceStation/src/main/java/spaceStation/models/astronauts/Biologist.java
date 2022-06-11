package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {
    public static final double UNITS_OF_OXYGEN = 70;

    public Biologist(String name) {
        super(name, UNITS_OF_OXYGEN);
    }

    @Override
    public void breath() {
        if (getOxygen() - 5 >= 0) {
            setOxygen(getOxygen() - 5);
        }
    }
}
