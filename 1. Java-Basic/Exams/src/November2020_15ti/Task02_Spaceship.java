package November2020_15ti;

import java.util.Scanner;

public class Task02_Spaceship {
    public static void main(String[] args) {
        //Да се отпечата на конзолата един ред:
        //Ако броят на астронавтите е между 3 (вкл.) и 10 (вкл.):
        //"The spacecraft holds {броя на астронавтите} astronauts."
        //Ако  броят на астронавтите е по-малък от 3:
        // "The spacecraft is too small."
        //Ако  броят на астронавтите е по-голям от 10:
        //"The spacecraft is too big."
        Scanner scanner = new Scanner(System.in);

        double widthOfShip = Double.parseDouble(scanner.nextLine());
        double lengthOfShip = Double.parseDouble(scanner.nextLine());
        double heightOfShip = Double.parseDouble(scanner.nextLine());
        double averageHigth = Double.parseDouble(scanner.nextLine());

        double sizeOfShip = widthOfShip * lengthOfShip * heightOfShip;
        double sizePerRoom = (averageHigth + 0.40) * 2 * 2;
        double numberOfPeople = Math.floor(sizeOfShip / sizePerRoom);

        if (numberOfPeople >= 3 && numberOfPeople <= 10) {
            System.out.printf("The spacecraft holds %.0f astronauts.", numberOfPeople);
        } else if (numberOfPeople < 3) {
            System.out.println("The spacecraft is too small.");
        } else if (numberOfPeople > 10) {
            System.out.println("The spacecraft is too big.");
        }
    }
}
