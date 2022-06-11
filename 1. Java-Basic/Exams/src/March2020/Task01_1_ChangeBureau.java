package March2020;

import java.util.Scanner;

public class Task01_1_ChangeBureau {
    public static void main(String[] args) {
        //брой биткойни(инт), брой китаиски юана(д), комисионна(д)
        //1 биткойн = 1168 лева.
        //1 китайски юан = 0.15 долара.
        //1 долар = 1.76 лева.
        //1 евро = 1.95 лева.
        Scanner scanner = new Scanner(System.in);

        int numberOfBitcoins = Integer.parseInt(scanner.nextLine());
        double numbersOfChineseYuan = Double.parseDouble(scanner.nextLine());
        double commission = Double.parseDouble(scanner.nextLine());

        double bitcoinToBgn = numberOfBitcoins * 1168;
        double chineseYuanToBgn = (numbersOfChineseYuan * 0.15) * 1.76;
        double allMoneyToEuro = (bitcoinToBgn + chineseYuanToBgn) / 1.95;
        double exchangeCurrency = allMoneyToEuro - (allMoneyToEuro * commission * 0.01);

        System.out.printf("%.2f", exchangeCurrency);
    }
}
