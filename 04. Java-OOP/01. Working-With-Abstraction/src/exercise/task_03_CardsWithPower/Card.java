package exercise.task_03_CardsWithPower;

public class Card {
    private final CardRanks rank;
    private final CardSuits suit;

    public Card(CardRanks rank, CardSuits suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getPower() {
        return this.rank.getPowerRank() + this.suit.getPowerSuit();
    }

    public CardRanks getRank() {
        return rank;
    }

    public CardSuits getSuit() {
        return suit;
    }
}
