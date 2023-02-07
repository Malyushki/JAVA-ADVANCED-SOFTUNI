import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CountCharacterTypes_04 {
    public static void main(String[] args) throws IOException {
        String pathToFile = "C:\\Users\\malyu\\Documents\\GitHub\\JAVA-ADVANCED-SOFTUNI\\StreamsFilesAndDirectories-Exercises\\src\\Exercises Resources\\input.txt";
        List<String> allLines = Files.readAllLines(Path.of(pathToFile));
      long countVowels = 0;
      long countOSymbols = 0;
      long countPunctuation = 0;

        for (String text:allLines) {
            for (char chars: text.toCharArray()) {
                switch (chars){
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        countVowels++;
                        break;
                    case '!':
                    case ',':
                    case '.':
                    case '?':
                        countPunctuation++;
                        break;
                    case ' ':
                        break;
                    default:
                        countOSymbols++;
                        break;

                }
            }
        }
        System.out.println("Vowels: "+countVowels);
        System.out.println("Other symbols: "+countOSymbols);
        System.out.println("Punctuation: "+countPunctuation);
    }

}
