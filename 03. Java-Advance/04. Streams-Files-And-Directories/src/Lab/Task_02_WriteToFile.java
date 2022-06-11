package Lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Set;

public class Task_02_WriteToFile {
    public static void main(String[] args) throws IOException {
        String path = "D:\\SoftUni\\3. JavaAdvance\\Java Advance Lectures" +
                "\\StreamsFilesAndDirectoriesResources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources" +
                "\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        Set<Character> separators = Set.of(',', '.', '!', '?');
        int nextByte = inputStream.read();

        PrintStream printStream = new PrintStream("out02Lab.txt");
        while (nextByte != -1) {
            char symbol = (char) nextByte;
            nextByte = inputStream.read();

            if (!separators.contains(symbol)) {
                printStream.print(symbol);
            }
        }
    }
}
