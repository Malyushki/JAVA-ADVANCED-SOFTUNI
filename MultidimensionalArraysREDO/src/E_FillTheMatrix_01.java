import java.util.Arrays;
import java.util.Scanner;

public class E_FillTheMatrix_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        int[][] matrix = new int[n][n];
        String pattern = input[1];

        if (pattern.equals("A")) {
            fillMatrixPatternA(matrix);

        } else if (pattern.equals("B")) {

            fillMatrixPatternB(matrix);
        }
        printMatrix(matrix);
    }

    private static void fillMatrixPatternA(int[][] matrix) {
        int firstNumber = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = firstNumber;
                firstNumber++;
            }
        }
    }

    private static void fillMatrixPatternB(int[][] matrix) {
        int firstNumber = 1;
        for (int col = 0; col < matrix.length; col++) {

            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = firstNumber;
                    firstNumber++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = firstNumber;
                    firstNumber++;
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] element : matrix) {
            System.out.println(Arrays.toString(element).replaceAll("[\\[\\],]", ""));
        }
    }
}
