package Lab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayDeque;

public class Task_08_NestedFolders {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("D:\\SoftUni\\3. JavaAdvance\\Java Advance Lectures" +
                "\\StreamsFilesAndDirectoriesResources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources");

        ArrayDeque<File> files = new ArrayDeque<>();
        PrintStream printStream = new PrintStream("out08Lab.txt");

        files.offer(file);
        int count = 0;
        while (!files.isEmpty()) {
            File innerFile = files.poll();
            printStream.println(innerFile.getName());
            for (File f : innerFile.listFiles()) {
                if (f.isDirectory()) {
                    files.offer(f);
              //  } else {
              //      printStream.println(f.getName());
              }
                count++;
               // printStream.println(innerFile.getName());
            }
            printStream.println(count+  " folders");
        }
    }
}
