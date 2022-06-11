package viceCity.models.guns;

public class Rifle extends BaseGun {
    private static final int BULLETS_PER_BARREL = 50;
    private static final int TOTAL_BULLETS = 500;

    public Rifle(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        if (getBulletsPerBarrel() > 0 && getTotalBullets() >= 0) {
            setBulletsPerBarrel(getBulletsPerBarrel() - 5);
            super.canFire = true;
        } else if (getBulletsPerBarrel() <= 0 && getTotalBullets() > 0) {
            setBulletsPerBarrel(50);
            setTotalBullets(getTotalBullets() - 50);
            setBulletsPerBarrel(getBulletsPerBarrel() - 5);
        }

        if (getTotalBullets() == 0 && getBulletsPerBarrel() == 0) {
            super.canFire = false;
        }
        return 5;
    }
}