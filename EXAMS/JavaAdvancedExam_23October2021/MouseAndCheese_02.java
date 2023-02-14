package EXAMS.JavaAdvancedExam_23October2021;

import java.util.Arrays;
import java.util.Scanner;

public class MouseAndCheese_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nSize = Integer.parseInt(scanner.nextLine());
        String[][] territoryMatrix = new String[nSize][nSize];
        fillMatrix(territoryMatrix, scanner);
        //printMatrix(territoryMatrix);
        int[] mouseCoordinates = findElementInMatrix(territoryMatrix, "M");
        int currentRow = mouseCoordinates[0];
        int currentCol = mouseCoordinates[1];
        territoryMatrix[currentRow][currentCol] = "-";
        int eatenCheese = 0;
        boolean mouseIsOut = false;
        String command = scanner.nextLine();
        while (!command.equals("end")) {

            switch (command) {
                case "up":
                    if (isInBoundaries(territoryMatrix, currentRow - 1, currentCol)) {
                        currentRow--;
                    } else {
                        mouseIsOut = true;
                    }
                    break;
                case "down":
                    if (isInBoundaries(territoryMatrix, currentRow + 1, currentCol)) {
                        currentRow++;
                    } else {

                        mouseIsOut = true;

                    }
                    break;
                case "left":
                    if (isInBoundaries(territoryMatrix, currentRow, currentCol - 1)) {
                        currentCol--;
                    } else {

                        mouseIsOut = true;
                    }

                    break;
                case "right":
                    if (isInBoundaries(territoryMatrix, currentRow, currentCol + 1)) {
                        currentCol++;
                    } else {

                        mouseIsOut = true;
                    }

                    break;
            }
            if (mouseIsOut) {
                System.out.println("Where is the mouse?");
                break;
            }

            if (territoryMatrix[currentRow][currentCol].equals("c")) {
                eatenCheese++;
                territoryMatrix[currentRow][currentCol] = "-";
            }
            if (territoryMatrix[currentRow][currentCol].equals("B")) {
                territoryMatrix[currentRow][currentCol] = "-";

                switch (command) {
                    case "up":
                        if (isInBoundaries(territoryMatrix, currentRow - 1, currentCol)) {
                            currentRow--;
                        } else {
                            mouseIsOut = true;
                        }
                        break;
                    case "down":
                        if (isInBoundaries(territoryMatrix, currentRow + 1, currentCol)) {
                            currentRow++;
                        } else {

                            mouseIsOut = true;

                        }
                        break;
                    case "left":
                        if (isInBoundaries(territoryMatrix, currentRow, currentCol - 1)) {
                            currentCol--;
                        } else {

                            mouseIsOut = true;
                        }

                        break;
                    case "right":
                        if (isInBoundaries(territoryMatrix, currentRow, currentCol + 1)) {
                            currentCol++;
                        } else {

                            mouseIsOut = true;
                        }

                        break;
                }







            }
            if (territoryMatrix[currentRow][currentCol].equals("c")) {
                eatenCheese++;
                territoryMatrix[currentRow][currentCol] = "-";
            }

            command = scanner.nextLine();
        }
        if (!mouseIsOut) {
           territoryMatrix[currentRow][currentCol] = "M";
        }

        String print = (eatenCheese<5)? String.format("The mouse couldn't eat the cheeses, she needed %d cheeses more.",5-eatenCheese):
                String.format("Great job, the mouse is fed %d cheeses!",eatenCheese);
        System.out.println(print);
        printMatrix(territoryMatrix);
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


}
///Трябва да разбера какво пправи този бонус и да го имплементирам в задачата