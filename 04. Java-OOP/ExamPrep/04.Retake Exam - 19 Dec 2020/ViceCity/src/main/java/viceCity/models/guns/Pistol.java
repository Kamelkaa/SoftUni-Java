package viceCity.models.guns;

public class Pistol extends BaseGun {
    private static final int BULLETS_PER_BARREL = 10;
    private static final int TOTAL_BULLETS = 100;

    public Pistol(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        if (getBulletsPerBarrel() > 0 && getTotalBullets() >= 0) {
            setBulletsPerBarrel(getBulletsPerBarrel() - 1);
            super.canFire = true;
        } else if (getBulletsPerBarrel() <= 0 && getTotalBullets() > 0) {
            setBulletsPerBarrel(10);
            setTotalBullets(getTotalBullets() - 10);
            setBulletsPerBarrel(getBulletsPerBarrel() - 1);
        }

        if (getTotalBullets() == 0 && getBulletsPerBarrel() == 0) {
            super.canFire = false;
        }
        return 1;
    }
}
