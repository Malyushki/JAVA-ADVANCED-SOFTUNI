
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SumLines_01 {
    public static void main(String[] args) throws IOException {
        String pathToFile = "C:\\Users\\malyu\\Documents\\GitHub\\JAVA-ADVANCED-SOFTUNI\\StreamsFilesAndDirectories-Exercises\\src\\Exercises Resources\\input.txt";
       List<String> allLines = Files.readAllLines(Path.of(pathToFile));
       allLines.stream().map(line -> line.toCharArray()).forEach(arr->{
           int sum = 0;
           for (char symbol:arr) {
               sum+=symbol;
           }
           System.out.println(sum);
       });
    }
}
