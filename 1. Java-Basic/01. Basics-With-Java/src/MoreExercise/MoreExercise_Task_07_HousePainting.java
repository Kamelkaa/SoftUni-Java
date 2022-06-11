package MoreExercise;

import java.util.Scanner;

public class MoreExercise_Task_07_HousePainting {
    public static void main(String[] args) {
        //височина на къщата (x), дължина (y), височина на покрива (h)
        //1.предна стена = (x * x) - (1.2 * 2)
        //2.задна стена = x * x
        //3.странични стени  = (x * y) - (1.5 * 1.5) / *2
        //4.покрив = ((x * y) * 2 ) + ((h * x)/2)*2
        //5.литри зелена боя = (задна стена + предна стена + странични стени)/ 3.4
        //6.литри червена боя = покрив / 4.3
        Scanner scanner = new Scanner(System.in);

        double houseHeight = Double.parseDouble(scanner.nextLine());
        double houseLength = Double.parseDouble(scanner.nextLine());
        double roofHeight = Double.parseDouble(scanner.nextLine());

        double frontAndBackWall = (houseHeight * houseHeight) - (1.2 * 2) + (houseHeight * houseHeight);
        double sideWalls = ((houseHeight * houseLength) - (1.5 * 1.5)) * 2;
        double roof = ((houseHeight * houseLength) + ((roofHeight * houseHeight) / 2)) * 2;
        double greenPaintLiters = (frontAndBackWall + sideWalls) / 3.4;
        double redPaintLiters = roof / 4.3;

        System.out.printf("%.2f%n%.2f", greenPaintLiters, redPaintLiters);
    }
}
