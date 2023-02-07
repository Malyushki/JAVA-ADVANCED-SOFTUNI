import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class LineNumbers_05 {
    public static void main(String[] args) throws IOException {
        //inputLineNumbers.txt
        String pathToFile = "C:\\Users\\malyu\\Documents\\GitHub\\JAVA-ADVANCED-SOFTUNI\\StreamsFilesAndDirectories-Exercises\\src\\Exercises Resources\\inputLineNumbers.txt";
        List<String> allLines = Files.readAllLines(Path.of(pathToFile));
       File file = new File("C:\\Users\\malyu\\Documents\\GitHub\\JAVA-ADVANCED-SOFTUNI\\StreamsFilesAndDirectories-Exercises\\src\\Exercises Resources\\outputLineNumbers.txt");
        FileWriter fileWriter = new FileWriter(file);
        int count = 1;
        for (String e:allLines) {

            fileWriter.write(count + ". " + e +System.lineSeparator()  );



            count++;
        }

       fileWriter.close();
    }
}
