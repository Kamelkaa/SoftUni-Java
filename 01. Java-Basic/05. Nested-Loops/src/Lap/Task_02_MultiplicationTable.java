package Lap;

public class Task_02_MultiplicationTable {
    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {

                int multi = i * j;

                System.out.printf("%d * %d = %d%n", i, j, multi);
            }
        }
    }
}
