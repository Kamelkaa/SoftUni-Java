package Lab;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Task_04_ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "D:\\SoftUni\\3. JavaAdvance\\Java Advance Lectures" +
                "\\StreamsFilesAndDirectoriesResources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources" +
                "\\input.txt";

        FileReader reader = new FileReader(path);
        Scanner scanner = new Scanner(reader);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                System.out.println(scanner.nextInt());
            }
            scanner.next();
        }
    }
}
