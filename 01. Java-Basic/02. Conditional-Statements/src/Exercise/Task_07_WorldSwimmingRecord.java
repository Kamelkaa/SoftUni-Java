package Exercise;

import java.util.Scanner;

public class Task_07_WorldSwimmingRecord {
    public static void main(String[] args) {
        //рекорда в секунди (д), разстоянието в метри (д), време в секунди за 1м (д)
        //на всеки 15м -> забавяне с 12.5 секунди
        //⦁	Ако Иван е подобрил Световния рекорд
            //"Yes, he succeeded! The new world record is {времето на Иван} seconds."
        //⦁	Ако НЕ е подобрил рекорда отпечатваме:
            //"No, he failed! He was {недостигащите секунди} seconds slower."
        Scanner scanner = new Scanner(System.in);

        double record = Double.parseDouble(scanner.nextLine());
        double meters = Double.parseDouble(scanner.nextLine());
        double timeForMeter = Double.parseDouble(scanner.nextLine());

        double timeFotAllMeter = meters * timeForMeter;
        double delayPer15Meters = Math.floor(meters / 15) * 12.5;
        double timeAfterDelay = timeFotAllMeter + delayPer15Meters;

        if (record > timeAfterDelay) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", timeAfterDelay);
        } else if (record <= timeAfterDelay) {
            double secondsSlower = timeAfterDelay - record;
            System.out.printf("No, he failed! He was %.2f seconds slower.", secondsSlower);
        }
    }
}
