import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int leftDiagonal = leftDiagonal(matrix,n);
        int rightDiagonal = rightDiagonal(matrix,n);
        int result = Math.abs(leftDiagonal - rightDiagonal);
        System.out.println(result);

    }

    static int leftDiagonal(int[][] matrix, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {

            sum += matrix[i][i];
        }
        return sum;
    }

    static int rightDiagonal(int[][] matrix, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {

            sum += matrix[i][n-i-1];
        }
        return sum;
    }
}
