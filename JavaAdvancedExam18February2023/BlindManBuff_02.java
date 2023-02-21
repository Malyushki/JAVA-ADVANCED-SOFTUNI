package JavaAdvancedExam18February2023;

import java.util.Arrays;
import java.util.Scanner;

public class BlindManBuff_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        String[][] playgroundMatrix = new String[rows][cols];
        fillMatrix(playgroundMatrix, scanner);
        //printMatrix(playgroundMatrix);
        String direction = scanner.nextLine();
        int touchedOpponents = 0;
        int movesMade = 0;
        int[] playerCoordinates = findElementInMatrix(playgroundMatrix, "B");
        int playerRow = playerCoordinates[0];
        int playerCol = playerCoordinates[1];

        while (!direction.equals("Finish")) {
            playgroundMatrix[playerRow][playerCol] = "-";
            switch (direction) {
                case "up":
                    if (isInBoundaries(playgroundMatrix, playerRow - 1, playerCol) && !isThereObstacle(playgroundMatrix, playerRow - 1, playerCol)) {
                        playerRow = playerRow - 1;
                        movesMade++;
                    }
                    break;
                case "down":
                    if (isInBoundaries(playgroundMatrix, playerRow + 1, playerCol) && !isThereObstacle(playgroundMatrix, playerRow + 1, playerCol)) {
                        playerRow = playerRow + 1;
                        movesMade++;
                    }
                    break;
                case "left":
                    if (isInBoundaries(playgroundMatrix, playerRow, playerCol - 1) && !isThereObstacle(playgroundMatrix, playerRow, playerCol - 1)) {
                        playerCol = playerCol - 1;
                        movesMade++;
                    }
                    break;
                case "right":
                    if (isInBoundaries(playgroundMatrix, playerRow, playerCol + 1) && !isThereObstacle(playgroundMatrix, playerRow, playerCol + 1)) {
                        playerCol = playerCol + 1;
                        movesMade++;
                    }
                    break;
            }


            if (playgroundMatrix[playerRow][playerCol].equals("P")) {
                touchedOpponents++;

                if (touchedOpponents == 3) {
                    System.out.println("Game over!");
                    System.out.printf("Touched opponents: %d Moves made: %d", touchedOpponents, movesMade);
                    return;
                }
            }
       //     System.out.println(movesMade);
       //     playgroundMatrix[playerRow][playerCol] = "B";
        //   System.out.println("----------");
        //    printMatrix(playgroundMatrix);
            direction = scanner.nextLine();
        }
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", touchedOpponents, movesMade);

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

    private static boolean isInBoundaries(String[][] matrix, int row, int col) {
        return (row >= 0 && row < matrix.length) && (col >= 0 && col < matrix[row].length);
    }

    private static boolean isThereObstacle(String[][] matrix, int row, int col) {
        return matrix[row][col].equals("O");
    }
}
