import java.util.Arrays;
import java.util.Scanner;

public class E_MaximalSum_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] matrix = new int[rows][col];

        fillMatrix(matrix, scanner);

        int maxValue = getMaxSumOf3x3Matrix(matrix);
        System.out.println( "Sum = "+maxValue);
        printMatrix(matrix,getMiddleIndexesOf3x3Matrix(matrix));

    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }

    private static void printMatrix(int[][] matrix, int[] indexes) {
        int startRow = indexes[0];
        int startCol = indexes[1];


        for (int row = startRow; row <= startRow+2; row++) {
            for (int col = startCol; col <=startCol+2 ; col++) {
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }
    }

    private static int getMaxSumOf3x3Matrix(int[][] matrix) {
        int maxValue = Integer.MIN_VALUE;
        for (int row = 0; row < matrix.length-2; row++) {
            for (int col = 0; col < matrix[row].length-2; col++) {

                int value = matrix[row][col] + matrix[row][col+1] + matrix[row][col +2] +
                        matrix[row+1][col] + matrix[row+1][col+1] + matrix[row+1][col +2] +
                        matrix[row+2][col] + matrix[row+2][col+1] + matrix[row+2][col +2];
                if (value > maxValue) {
                    maxValue = value;
                    }
                }
            }

        return maxValue;
    }

    private static int[] getMiddleIndexesOf3x3Matrix(int[][] matrix) {
        int maxValue = Integer.MIN_VALUE;
        int[] indexes = new int[2];

        for (int row = 0; row < matrix.length-2; row++) {
            for (int col = 0; col < matrix[row].length-2; col++) {

                    int value = matrix[row][col] + matrix[row][col+1] + matrix[row][col +2] +
                            matrix[row+1][col] + matrix[row+1][col+1] + matrix[row+1][col +2] +
                            matrix[row+2][col] + matrix[row+2][col+1] + matrix[row+2][col +2];
                    if (value > maxValue) {
                        maxValue = value;
                        indexes[0] = row;
                        indexes[1] = col;

                }
            }
        }
        return indexes;
    }
}

