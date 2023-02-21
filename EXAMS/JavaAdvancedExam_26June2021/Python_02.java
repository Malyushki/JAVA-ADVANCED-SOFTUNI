package EXAMS.JavaAdvancedExam_26June2021;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Python_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nSize = Integer.parseInt(scanner.nextLine());
        if (nSize < 1) {
            System.out.println("You win! Final python length is 1");
            return;
        }
        String[][] screenMatrix = new String[nSize][nSize];
        int pythonLength = 1;
        String[] pythonCommands = scanner.nextLine().split(",\\s+");

        fillMatrix(screenMatrix, scanner);


        int[] playerCoordinates = findElementInMatrix(screenMatrix, "s");
        int currentPlayerRow = playerCoordinates[0];
        int currentPlayerCol = playerCoordinates[1];
        screenMatrix[currentPlayerRow][currentPlayerCol] = "*";

        for (int move = 0; move < pythonCommands.length; move++) {
            String direction = pythonCommands[move];
            playerCoordinates = playerMovement(screenMatrix, currentPlayerRow, currentPlayerCol, direction);
            currentPlayerRow = playerCoordinates[0];
            currentPlayerCol = playerCoordinates[1];


            if (screenMatrix[currentPlayerRow][currentPlayerCol].equals("f")) {
                screenMatrix[currentPlayerRow][currentPlayerCol] = "*";
                pythonLength++;

            }
            if (screenMatrix[currentPlayerRow][currentPlayerCol].equals("e")) {
                System.out.println("You lose! Killed by an enemy!");
                return;
            }

        }


        int countLeftFood = 0;
        for (int row = 0; row < screenMatrix.length; row++) {
            for (int col = 0; col < screenMatrix[0].length; col++) {
                if (screenMatrix[row][col].equals("f")) {
                    countLeftFood++;
                }
            }
        }
        String print = (countLeftFood == 0) ? String.format("You win! Final python length is %d", pythonLength) :
                String.format("You lose! There is still %d food to be eaten.", countLeftFood);

        System.out.println(print);


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
    public static int countFood(){
return 0;

    };

}
