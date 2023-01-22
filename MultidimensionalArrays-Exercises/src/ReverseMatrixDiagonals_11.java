import java.util.Scanner;

public class ReverseMatrixDiagonals_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] matrix = new int[row][col];
        fillMatrix(matrix, scanner);
        printMatrix(matrix,row,col);
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }

    private static void printMatrix(int[][] matrix,int rows, int cols) {



            for (int col = cols-1; col >=0 ; col--) {
              int printRow= rows;
                for (int printCol = col; printCol <=cols-1 && printRow>0 ; printCol++) {

                        System.out.print(matrix[printRow-1][printCol]+" ");
                        printRow--;

            }
            System.out.println();
        }
        if(rows >= 2) {
            for (int row = rows - 2; row >= 0; row--) {
                int printRow = row;
                for (int col = 0; col <= row&col<cols; col++) {
                    System.out.print(matrix[printRow][col] + " ");
                    printRow--;
                }
                System.out.println();
            }
        }
    }
}



