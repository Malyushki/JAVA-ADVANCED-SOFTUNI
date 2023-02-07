import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SumBytes_02 {
    public static void main(String[] args) throws IOException {
            String pathToFile = "C:\\Users\\malyu\\Documents\\GitHub\\JAVA-ADVANCED-SOFTUNI\\StreamsFilesAndDirectories-Exercises\\src\\Exercises Resources\\input.txt";
            byte[] allBytes = Files.readAllBytes(Path.of(pathToFile));
long sum = 0 ;
        for (byte e:allBytes) {
            if (e!=13 && e!=10) {
                sum += e;
            }
        }
        System.out.println(sum);
    }
}
