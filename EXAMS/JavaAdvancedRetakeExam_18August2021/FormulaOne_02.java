package EXAMS.JavaAdvancedRetakeExam_18August2021;

import java.util.Arrays;
import java.util.Scanner;

public class FormulaOne_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nSize = Integer.parseInt(scanner.nextLine());
        String[][] trackMatrix = new String[nSize][nSize];
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        fillMatrix(trackMatrix, scanner);
        // printMatrix(trackMatrix);
        int[] playerCoordinates = findElementInMatrix(trackMatrix, "P");
        int currentPlayerRow = playerCoordinates[0];
        int currentPlayerCol = playerCoordinates[1];
        trackMatrix[currentPlayerRow][currentPlayerCol] = ".";


        for (int i = 0; i < numberOfCommands; i++) {
            String command = scanner.nextLine();
           
            playerCoordinates = playerMovement(trackMatrix, currentPlayerRow, currentPlayerCol, command);
            currentPlayerRow = playerCoordinates[0];
            currentPlayerCol = playerCoordinates[1];

            if (trackMatrix[currentPlayerRow][currentPlayerCol].equals("B")){
               // trackMatrix[currentPlayerRow][currentPlayerCol] = ".";
                playerCoordinates = playerMovement(trackMatrix, currentPlayerRow, currentPlayerCol, command);
                currentPlayerRow = playerCoordinates[0];
                currentPlayerCol = playerCoordinates[1];
                
            } else if (trackMatrix[currentPlayerRow][currentPlayerCol].equals("T")) {
                command = changeDirection(command);
             //   trackMatrix[currentPlayerRow][currentPlayerCol] = ".";
                playerCoordinates = playerMovement(trackMatrix, currentPlayerRow, currentPlayerCol, command);
                currentPlayerRow = playerCoordinates[0];
                currentPlayerCol = playerCoordinates[1];
                
            }
            if (trackMatrix[currentPlayerRow][currentPlayerCol].equals("F")){
                System.out.println("Well done, the player won first place!");
                trackMatrix[currentPlayerRow][currentPlayerCol] = "P";
                printMatrix(trackMatrix);
                    return;
            }
        }
        System.out.println("Oh no, the player got lost on the track!");
        trackMatrix[currentPlayerRow][currentPlayerCol] = "P";
        printMatrix(trackMatrix);
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

    private static int[] playerMovement(String[][] matrix, int row, int col, String direction) {
        int[] coordinates = new int[2];


        switch (direction) {
            case "up":
                if (isInBoundaries(matrix, row - 1, col)) {
                    row = row - 1;
                } else {
                    row = matrix[0].length - 1;
                }

                break;
            case "down":
                if (isInBoundaries(matrix, row + 1, col)) {
                    row = row + 1;
                } else {
                    row = 0;
                }

                break;
            case "left":
                if (isInBoundaries(matrix, row, col - 1)) {
                    col = col - 1;
                } else {
                    col = matrix.length - 1;
                }

                break;
            case "right":
                if (isInBoundaries(matrix, row, col + 1)) {
                    col = col + 1;
                } else {
                    col = 0;
                }

                break;
        }
        coordinates[0] = row;
        coordinates[1] = col;
        return coordinates;
    }

    private static boolean isInBoundaries(String[][] matrix, int row, int col) {
        return (row >= 0 && row < matrix.length) && (col >= 0 && col < matrix[row].length);
    }
    private static String changeDirection(String direction) {
        if (direction.equals("up")) {
            return "down";
        }
        if (direction.equals("down")) {
            return "up";
        }
        if (direction.equals("left")) {
            return "right";
        }
        if (direction.equals("right")) {
            return "left";
        }

return null;
    }
}



