import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int[][] firstArr = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                firstArr[i][j] = scanner.nextInt();
            }
        }
        int r2 = scanner.nextInt();
        int c2 = scanner.nextInt();
        int[][] secondArr = new int[r][c];
        if (r != r2 || c != c2) {
            System.out.println("not equal");
            return;

        }
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                secondArr[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (firstArr[i][j] != secondArr[i][j]) {
                    System.out.println("not equal");
                    return;
                }

            }
        }


        System.out.println("equal");
    }

}
