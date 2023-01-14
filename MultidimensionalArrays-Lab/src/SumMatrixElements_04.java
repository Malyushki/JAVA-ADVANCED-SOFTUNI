import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputDimensions = scanner.nextLine().split(",\\s+");
        int r = Integer.parseInt(inputDimensions[0]);
        int c = Integer.parseInt(inputDimensions[1]);

        System.out.println(r);
        System.out.println(c);
        int sum = 0;
        for (int i = 0; i < r; i++) {
            String[] input = scanner.nextLine().split(",\\s+");
            for (String e : input) {
                sum += Integer.parseInt(e);
            }
        }
        System.out.println(sum);
    }
}
