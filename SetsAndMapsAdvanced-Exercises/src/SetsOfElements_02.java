import java.util.*;

public class SetsOfElements_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] lengthOfSets = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();

        for (int i = 0; i <lengthOfSets[0] ; i++) {
            String word = scanner.nextLine();
            firstSet.add(word);
        }
        for (int i = 0; i <lengthOfSets[1] ; i++) {
            String word = scanner.nextLine();
            secondSet.add(word);
        }
        firstSet.retainAll(secondSet);

        for (String e: firstSet) {
            System.out.print(e+" ");
        }
    }
}
