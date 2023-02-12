package EXAMS.Java_Advanced_Retake_Exam_18August2022.src;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class TreasureHunt_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] coordinatesOfMatrix = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(coordinatesOfMatrix[0]);
        int cols = Integer.parseInt(coordinatesOfMatrix[1]);
        char[][] secretMapMatrix = new char[rows][cols];
        fillMatrix(secretMapMatrix, scanner);
        char myIdentification = 'Y';
        String command = scanner.nextLine();
        int[] myCoordinates = findElementInMatrix(secretMapMatrix, myIdentification);
        int currentRow = myCoordinates[0];
        int currentCol = myCoordinates[1];
        Deque<String> directionsQueue = new ArrayDeque<>();
        while (!command.equals("Finish")) {
            switch (command) {
                case "up":
                    if (isInBoundaries(secretMapMatrix, currentRow-1, currentCol)) {
                        if (secretMapMatrix[currentRow-1][currentCol]!='T') {
                            currentRow--;
                            directionsQueue.offer("up");
                        }
                    }

                    break;
                case "down":
                    if (isInBoundaries(secretMapMatrix, currentRow+1, currentCol)) {
                        if (secretMapMatrix[currentRow+1][currentCol]!='T') {
                            currentRow++;
                            directionsQueue.offer("down");
                        }
                    }

                    break;
                case "right":
                    if (isInBoundaries(secretMapMatrix, currentRow, currentCol+1)) {
                        if (secretMapMatrix[currentRow][currentCol+1]!='T') {
                            currentCol++;
                            directionsQueue.offer("right");
                        }
                    }

                    break;
                case "left":
                    if (isInBoundaries(secretMapMatrix, currentRow, currentCol-1)) {
                        if (secretMapMatrix[currentRow][currentCol-1]!='T') {
                            currentCol--;
                            directionsQueue.offer("left");
                        }
                    }


                    break;
                default:
                    System.out.println("ERROR");
                    break;
            }
            command = scanner.nextLine();
        }
        if (secretMapMatrix[currentRow][currentCol]!='X'){
            System.out.println("The map is fake!");
        }else {
            System.out.println("I've found the treasure!");
            System.out.print("The right path is ");
            System.out.println(directionsQueue.toString().replaceAll("[\\[\\]]",""));

        }


    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+","").toCharArray();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] element : matrix) {
            System.out.println(Arrays.toString(element).replaceAll("[\\[\\], ]", ""));
        }
    }

    private static boolean isInBoundaries(char[][] matrix, int row, int col) {
        return (row >= 0 && row < matrix.length) && (col >= 0 && col < matrix[row].length);
    }

    private static int[] findElementInMatrix(char[][] matrix, char element) {
        int[] coordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col]==element) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                }
            }
        }
        return coordinates;
    }
}

