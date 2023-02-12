package EXAMS.JavaAdvancedExam_19February2022;

import java.util.Arrays;
import java.util.Scanner;

public class PawnWars_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [][] chessBoardMatrix = new String[8][8];
        fillMatrix(chessBoardMatrix,scanner);
        printMatrix(chessBoardMatrix);
        int[] whiteCoordinates = findElementInMatrix(chessBoardMatrix,"w");
        int whiteRow = whiteCoordinates[0];
        int whiteCol = whiteCoordinates[1];
        int[] blackCoordinates = findElementInMatrix(chessBoardMatrix,"b");
        int blackRow = blackCoordinates[0];
        int blackCol = blackCoordinates[1];
        if (blackCol+1==whiteCol || blackCol-1 == whiteCol){

        }else {

            int blackLeftMovement = 7-blackRow;
            if (whiteRow<=blackLeftMovement){
                System.out.printf("Game over! White pawn is promoted to a queen at b8%n");
            }else {
                System.out.printf("Game over! Black pawn is promoted to a queen at b1%n");
            }


        }

    }
    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
    private static void printMatrix(String[][] matrix) {
        for (String[] element : matrix) {
            System.out.println(Arrays.toString(element).replaceAll("[\\[\\],]", ""));
        }
    }
    private static int[] findElementInMatrix(String[][] matrix, String element) {
        int[] coordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col].equals(element)) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                }
            }
        }

        return coordinates;
    }
}
