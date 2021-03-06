package CounterStriker.models.guns;

public class Rifle extends GunImpl {
    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (super.getBulletsCount() > 0) {
            super.setBulletsCount(super.getBulletsCount() - 10);
            return 10;
        } else {
            super.setBulletsCount(0);
            return 0;
        }
    }
}
