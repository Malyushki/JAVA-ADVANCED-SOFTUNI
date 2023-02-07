import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFiles_07 {
    public static void main(String[] args) throws IOException {
        String pathToFile1 = "C:\\Users\\malyu\\Documents\\GitHub\\JAVA-ADVANCED-SOFTUNI\\StreamsFilesAndDirectories-Exercises\\src\\Exercises Resources\\inputOne.txt";
        List<String> allLines1 = Files.readAllLines(Path.of(pathToFile1));
        String pathToFile2 = "C:\\Users\\malyu\\Documents\\GitHub\\JAVA-ADVANCED-SOFTUNI\\StreamsFilesAndDirectories-Exercises\\src\\Exercises Resources\\inputTwo.txt";
        List<String> allLines2 = Files.readAllLines(Path.of(pathToFile2));
        File file = new File("C:\\Users\\malyu\\Documents\\GitHub\\JAVA-ADVANCED-SOFTUNI\\StreamsFilesAndDirectories-Exercises\\src\\Exercises Resources\\mergedFile.txt");
        PrintWriter writer = new PrintWriter(file);
        for (String element:allLines1) {
            writer.println(element);
        }
        for (String element:allLines2) {
            writer.println(element);
        }
        writer.close();
    }
}
