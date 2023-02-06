import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][];
        int[][] matrix2 = new int[n][];

        fillMatrix(matrix,matrix2, scanner);

        int[] mistakenNumberCoordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int mistakenNumber = matrix[mistakenNumberCoordinates[0]][mistakenNumberCoordinates[1]];
       repairMatrix(matrix,mistakenNumber,matrix2);
        printMatrix(matrix2);
        printMatrix(matrix);

    }

    private static void fillMatrix(int[][] matrix, int[][] matrix2,Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {

             matrix2[row] =  matrix[row] =  Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            }
        }

    private static void repairMatrix(int[][] matrix, int mistakenNumber,int[][] matrix2) {
        for (int row = 0; row < matrix2.length; row++) {
            for (int col = 0; col < matrix2[0].length; col++) {
               if (matrix2[row][col]==mistakenNumber){
                   int newNumber = 0;
                   if (checkBorders(matrix2,col+1,row)){
                       if (matrix2[row][col+1]!=mistakenNumber) {
                           newNumber += matrix2[row][col + 1];
                       }
                   }
                   if (checkBorders(matrix2,col-1,row)){
                       if (matrix2[row][col-1]!=mistakenNumber) {
                           newNumber += matrix2[row][col - 1];
                       }
                   }
                   if (checkBorders(matrix2,col,row+1)){
                       if (matrix2[row+1][col]!=mistakenNumber) {
                           newNumber += matrix2[row+1][col];
                       }
                   }
                   if (checkBorders(matrix2,col,row-1)){
                       if (matrix2[row-1][col]!=mistakenNumber) {
                           newNumber += matrix2[row-1][col];
                       }
                   }

                  matrix[row][col] = newNumber;
               }

            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] element : matrix) {
            System.out.println(Arrays.toString(element).replaceAll("[\\[\\],]", ""));
        }
    }

    private static boolean checkBorders(int[][] matrix, int col , int row) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (row < 0 || row >= rows) {
            return false;
        }
        if (col < 0 || col >= cols) {
            return false;
        }
        return true;
    }
}


/// ne znam zashto i dvete matrici se upgredvat