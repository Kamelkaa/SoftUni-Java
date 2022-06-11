package spaceStation.models.astronauts;

public class Meteorologist extends BaseAstronaut {
    public static final double UNITS_OF_OXYGEN = 90;

    public Meteorologist(String name) {
        super(name, UNITS_OF_OXYGEN);
    }

    @Override
    public void breath() {
        super.breath();
    }
}
