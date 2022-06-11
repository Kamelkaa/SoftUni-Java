package exercise.task_03_CardsWithPower;

public enum CardSuits {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private final int powerSuit;

    CardSuits(int powerSuit) {
        this.powerSuit = powerSuit;
    }

    public int getPowerSuit() {
        return powerSuit;
    }
}
