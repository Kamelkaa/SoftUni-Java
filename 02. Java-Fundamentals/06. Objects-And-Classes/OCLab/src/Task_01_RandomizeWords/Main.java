package Task_01_RandomizeWords;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arrayOfWord = scanner.nextLine().split(" ");
        Random rnd = new Random();

        for (int i = 0; i <= arrayOfWord.length - 1; i++) {
            int randomIndex = rnd.nextInt(arrayOfWord.length);
            String temp = arrayOfWord[i];
            arrayOfWord[i] = arrayOfWord[randomIndex];
            arrayOfWord[randomIndex] = temp;
        }

        for (String word : arrayOfWord) {
            System.out.println(word);
        }
    }
}
