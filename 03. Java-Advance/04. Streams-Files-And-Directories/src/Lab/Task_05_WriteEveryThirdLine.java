package Lab;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Task_05_WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("D:\\SoftUni\\3. JavaAdvance\\Java Advance Lectures" +
                "\\StreamsFilesAndDirectoriesResources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources" +
                "\\input.txt");

        List<String> lines = Files.readAllLines(path);

        PrintStream printStream = new PrintStream("out05Lab.txt");
        for (int i = 0; i < lines.size(); i++) {
            if ((i + 1) % 3 == 0) {
                printStream.println(lines.get(i));
            }
        }
    }
}
