package Exercise;

import java.util.Scanner;

public class Task_03_ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] pathOfTheFile = scanner.nextLine().split("\\\\");
        String nameAndExtension = pathOfTheFile[pathOfTheFile.length - 1];

        String name = nameAndExtension.split("\\.")[0];
        String extension = nameAndExtension.split("\\.")[1];

        System.out.printf("File name: %s%n" +
                "File extension: %s", name, extension);

    }
}
