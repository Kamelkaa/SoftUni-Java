package Exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task_07_MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String pathOne = "D:\\SoftUni\\3. JavaAdvance\\Java Advance Lectures" +
                "\\StreamsFilesAndDirectoriesResources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\inputOne.txt";

        String pathTwo = "D:\\SoftUni\\3. JavaAdvance\\Java Advance Lectures" +
                "\\StreamsFilesAndDirectoriesResources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\inputTwo.txt";

        String outputPath = "out07Exercise.txt";

        PrintWriter writer = new PrintWriter(outputPath);
        Files.readAllLines(Path.of(pathOne))
                .forEach(writer::println);
        Files.readAllLines(Path.of(pathTwo))
                .forEach(writer::println);

        writer.close();
    }
}
