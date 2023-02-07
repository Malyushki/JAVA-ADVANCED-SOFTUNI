import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ALLCAPITALS_03 {
    public static void main(String[] args) throws IOException {
        String pathToFile = "C:\\Users\\malyu\\Documents\\GitHub\\JAVA-ADVANCED-SOFTUNI\\StreamsFilesAndDirectories-Exercises\\src\\Exercises Resources\\input.txt";
        String pathToWriteFile = "C:\\Users\\malyu\\Documents\\GitHub\\JAVA-ADVANCED-SOFTUNI\\StreamsFilesAndDirectories-Exercises\\src\\Exercises Resources\\output.txt";
        String allText = Files.readString(Path.of(pathToFile));
        Files.writeString(Path.of(pathToWriteFile), allText.toUpperCase());

    }
}
