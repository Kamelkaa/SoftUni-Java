package Exercise;

import java.util.Scanner;

public class Exercise_Task_08_FishTank {
    public static void main(String[] args) {
        //дължина, широчина, височина в см и зает процент
        //1.обема на аквариум = дължина * широчина * височина в см
        //1л = 1 куб.дм  1 куб.дм = 0.001 см
        //2.общо литри = обема на аквариум * 0.001
        //3.литри които ще се съберат в аквариума = общо литри * (1 - зает процент * 0.01)
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());

        int volume = length * width * height;
        double allLitres = volume * 0.001;
        double neededLitres = allLitres * ( 1 - percent * 0.01 );

        System.out.printf("%.2f", neededLitres);
    }
}
