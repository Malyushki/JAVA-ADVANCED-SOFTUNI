import java.util.*;

public class UniqueUsernames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String>uniqueWords = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            uniqueWords.add(word);
        }
        uniqueWords.forEach(System.out::println);

    }
}
