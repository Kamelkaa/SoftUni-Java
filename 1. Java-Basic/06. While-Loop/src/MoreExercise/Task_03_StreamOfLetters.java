package MoreExercise;

import java.util.Scanner;

public class Task_03_StreamOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String word = "";
        int counterC = 0;
        int counterO = 0;
        int counterN = 0;

        while (!text.equals("End")) {
            char letter = text.charAt(0);

            if ((letter >= 97 && letter <= 122) || (letter >= 65 && letter <= 90)) {
                switch (letter) {
                    case 'c':
                        word = word + "";

                        if (counterC > 0) {
                            word = word + 'c';
                        }

                        counterC++;
                        break;

                    case 'o':
                        word = word + "";

                        if (counterO > 0) {
                            word = word + 'o';
                        }

                        counterO++;
                        break;

                    case 'n':
                        word = word + "";

                        if (counterN > 0) {
                            word = word + 'n';
                        }

                        counterN++;
                        break;
                    default:
                        word = word + letter;
                }


                if (counterC > 0 && counterN > 0 && counterO > 0) {
                    System.out.print(word + " ");
                    counterC = 0;
                    counterN = 0;
                    counterO = 0;
                    word = "";
                }
            }
            text = scanner.nextLine();
        }
    }
}
