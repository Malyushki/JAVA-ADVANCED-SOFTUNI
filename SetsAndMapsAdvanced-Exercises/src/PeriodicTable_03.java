import java.util.*;
import java.util.stream.Collectors;

public class PeriodicTable_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> chemicalElements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            List<String> input = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
            chemicalElements.addAll(input);
        }

       printSet(chemicalElements);
    }
    private static void printSet(Set<String> set){
        for (String e: set) {
            System.out.print(e+" ");
        }
    }
}
