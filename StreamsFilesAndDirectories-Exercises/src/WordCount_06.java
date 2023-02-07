import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WordCount_06 {
    public static void main(String[] args) throws IOException {
        String pathToFile = "C:\\Users\\malyu\\Documents\\GitHub\\JAVA-ADVANCED-SOFTUNI\\StreamsFilesAndDirectories-Exercises\\src\\Exercises Resources\\words.txt";
        List<String> allLines = Files.readAllLines(Path.of(pathToFile));
        Map<String, Integer> countWords = new TreeMap<>();

        for (String e : allLines) {
            String[] words = e.split("\\s+");
           Arrays.stream(words).forEach(word ->{
               countWords.put(word,0);
           });
        }
        String pathToSecondFile = "C:\\Users\\malyu\\Documents\\GitHub\\JAVA-ADVANCED-SOFTUNI\\StreamsFilesAndDirectories-Exercises\\src\\Exercises Resources\\text.txt";
        List<String> allLinesSF = Files.readAllLines(Path.of(pathToSecondFile));
        for (String e:allLinesSF) {
            String[] words = e.split("\\s+");
            Arrays.stream(words).forEach(word ->{
                for (Map.Entry<String, Integer> entry : countWords.entrySet()) {
                    if (entry.getKey().equals(word)){
                        entry.setValue(entry.getValue()+1);
                    }
                }
            });
        }
        PrintWriter writer = new PrintWriter("result.txt");
countWords.entrySet().stream().sorted((e1,e2)-> e2.getValue().compareTo(e1.getValue())).forEach(entry->writer.println(entry.getKey()+" - "+entry.getValue()));

        writer.close();

    }
}
