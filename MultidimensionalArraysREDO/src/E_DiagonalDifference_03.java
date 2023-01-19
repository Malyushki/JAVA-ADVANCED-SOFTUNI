import java.util.Scanner;

public class E_DiagonalDifference_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        fillMatrix(matrix,scanner);
        System.out.println(Math.abs(getPrimeDiagonalSum(matrix)-getSecDiagonalSum(matrix)));

    }
    private static void fillMatrix(int [][] matrix,Scanner scanner){

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }
    private static int getPrimeDiagonalSum(int[][] matrix){
        int primeDiagonal = 0;
        for (int rowAndCol = 0; rowAndCol <matrix.length ; rowAndCol++) {
            primeDiagonal +=matrix[rowAndCol][rowAndCol];

            }
        return primeDiagonal;
        }
    private static int getSecDiagonalSum(int[][] matrix){
        int secDiagonal = 0;
        for (int rowAndCol = 0; rowAndCol <matrix.length ; rowAndCol++) {
            secDiagonal +=matrix[rowAndCol][matrix.length-rowAndCol-1];

        }
        return secDiagonal;
    }
    }


