package Exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Task_05_LineNumbers {
    public static void main(String[] args) throws IOException {
        String path = "D:\\SoftUni\\3. JavaAdvance\\Java Advance Lectures" +
                "\\StreamsFilesAndDirectoriesResources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\inputLineNumbers.txt";

        String outputPath = "out05Exercise.txt";
        PrintWriter writer = new PrintWriter(outputPath);

        List<String> lines = Files.readAllLines(Path.of(path));

        int counterRow = 1;
        for (String line : lines) {
            writer.println(counterRow++ + ". " + line);
        }

        writer.close();
    }
}
