package exercise.task_01_CardSuit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Suits:");
        for (Card value : Card.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", value.ordinal(), value);
        }
    }
}
