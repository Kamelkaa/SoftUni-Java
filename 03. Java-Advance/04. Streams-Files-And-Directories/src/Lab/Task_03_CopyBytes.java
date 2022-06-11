package Lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Task_03_CopyBytes {
    public static void main(String[] args) throws IOException {
        String path = "D:\\SoftUni\\3. JavaAdvance\\Java Advance Lectures" +
                "\\StreamsFilesAndDirectoriesResources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources" +
                "\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        int nextByte = inputStream.read();

        PrintStream printStream = new PrintStream("out03Lab.txt");

        while ((nextByte != -1)) {
            if (nextByte == ' ') {
                printStream.print((char) nextByte);
            } else if (nextByte == 10) {
                printStream.println();
            } else {
                printStream.print(nextByte);
            }

            nextByte = inputStream.read();
        }

    }
}
