package EXAMS.JavaAdvancedRetakeExam_15December2021;

import java.util.Arrays;
import java.util.Scanner;

public class ThroneConquering_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int parisEnergy = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());
        String[][] battleFieldMatrix = new String[rows][];
        fillMatrix(battleFieldMatrix, scanner);
      //  printMatrix(battleFieldMatrix);
        int[] parisCoordinates = findElementInMatrix(battleFieldMatrix,"P");
        int parisCurrentRow  = parisCoordinates[0];
        int parisCurrentCol  = parisCoordinates[1];
        battleFieldMatrix[parisCurrentRow][parisCurrentCol] = "-";

        while (parisEnergy>0){
            String[] commandParts = scanner.nextLine().split("\\s+");
            String enemy = "S";
            int newEnemyRow = Integer.parseInt(commandParts[1]);
            int newEnemyCol = Integer.parseInt(commandParts[2]);
            battleFieldMatrix[newEnemyRow][newEnemyCol]= enemy;
            switch (commandParts[0]){
                case "up":
                    if (isInBoundaries(battleFieldMatrix,parisCurrentRow-1,parisCurrentCol)){
                        parisCurrentRow--;
                    }
                    parisEnergy--;

                    break;
                case "down":
                    if (isInBoundaries(battleFieldMatrix,parisCurrentRow+1,parisCurrentCol)){
                        parisCurrentRow++;

                    }
                    parisEnergy--;
                    break;
                case "left":
                    if (isInBoundaries(battleFieldMatrix,parisCurrentRow,parisCurrentCol-1)){
                        parisCurrentCol--;

                    }
                    parisEnergy--;
                    break;
                case "right":
                    if (isInBoundaries(battleFieldMatrix,parisCurrentRow,parisCurrentCol+1)){
                        parisCurrentCol++;
                    }
                    parisEnergy--;
                    break;

            }
            if (findHelen(battleFieldMatrix,parisCurrentRow,parisCurrentCol)){
                battleFieldMatrix[parisCurrentRow][parisCurrentCol] = "-";
                System.out.print("Paris has successfully abducted Helen! ");
                System.out.printf("Energy left: %d%n",parisEnergy);
                printMatrix(battleFieldMatrix);
                return;
            }
            if (findEnemy(battleFieldMatrix,parisCurrentRow,parisCurrentCol)){
                parisEnergy-=2;
                if (parisEnergy<=0){
                    battleFieldMatrix[parisCurrentRow][parisCurrentCol] = "X";
                    System.out.printf("Paris died at %d;%d.%n",parisCurrentRow,parisCurrentCol);
                    printMatrix(battleFieldMatrix);
                    return;
                }else {
                    battleFieldMatrix[parisCurrentRow][parisCurrentCol] = "-";
                }

            }

        }
        battleFieldMatrix[parisCurrentRow][parisCurrentCol] = "X";
        System.out.printf("Paris died at %d;%d.%n",parisCurrentRow,parisCurrentCol);
        printMatrix(battleFieldMatrix);
    }


    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }
    private static void printMatrix(String[][] matrix) {
        for (String[] element : matrix) {
            System.out.println(Arrays.toString(element).replaceAll("[\\[\\], ]", ""));
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
    private static boolean isInBoundaries(String[][] matrix, int row, int col) {
        return (row >= 0 && row < matrix.length) && (col >= 0 && col < matrix[row].length);
    }
    private static boolean findHelen(String[][] matrix, int row, int col){
        return matrix[row][col].equals("H");
    }
    private static boolean findEnemy(String[][] matrix, int row, int col){
        return matrix[row][col].equals("S");
    }
}
