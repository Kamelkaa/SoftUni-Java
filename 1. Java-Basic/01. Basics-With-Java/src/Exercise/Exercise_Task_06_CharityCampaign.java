package Exercise;

import java.util.Scanner;

public class Exercise_Task_06_CharityCampaign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //брой дни, брой сладкари, брой торти, гофрети, палачинки
        //печалба от един сладкар за един ден = сума от торти + сума от гофрети + сума от палачинки
        //сума от торти = брой торти * 45
        //сума от гофрети = брой гофрети * 5.80
        //сума от палачинки = брой плачинки * 3.20
        //печалба от всички сладкари за един ден = печалба от един сладкар * брой сладкари
        //печалбата за всички дни  = печалба от всички сладкари * брой дни
        //събраната сума = печалбата за всички дни - печалбата за всички дни / 8

        int numberOfDays = Integer.parseInt(scanner.nextLine());
        int numberOfBakers = Integer.parseInt(scanner.nextLine());
        int numberOfCakes = Integer.parseInt(scanner.nextLine());
        int numberOfWaffles = Integer.parseInt(scanner.nextLine());
        int numberOfPancakes = Integer.parseInt(scanner.nextLine());

        double sumOfCakes = numberOfCakes * 45;
        double sumOfWaffles = numberOfWaffles * 5.80;
        double sumOfPancakes = numberOfPancakes * 3.20;
        double prizePerBaker = sumOfCakes + sumOfWaffles + sumOfPancakes;

        double prizePerAllBakers = prizePerBaker * numberOfBakers;
        double prizeForAllDays = prizePerAllBakers * numberOfDays;
        double amount = prizeForAllDays - prizeForAllDays / 8;

        System.out.printf("%.2f", amount);
    }
}
