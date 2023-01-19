import java.util.Arrays;
import java.util.Scanner;

public class E_MatrixOfPalindromes_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        String[][] matrix = new String[rows][cols];
        fillMatrix(matrix, rows, cols);
        printMatrix(matrix);
    }

    private static void fillMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String text =
                        Character.toString((97 + row)) + Character.toString((97 + row + col)) + Character.toString((97 + row));
                matrix[row][col] = text;
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            System.out.println(Arrays.toString(row).replaceAll("[\\[\\],]", ""));
        }
    }
}
