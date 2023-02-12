package EXAMS.Java_Advanced_Exam_25June2022.src;

import java.util.Arrays;
import java.util.Scanner;

public class StickyFingers_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[][] filedMatrix = new String[size][size];
        String[] moves = scanner.nextLine().split(",");
        fillMatrix(filedMatrix, scanner);
        int[] dillingersCoordinates = findElementInMatrix(filedMatrix, "D");
        int dillingerRow = dillingersCoordinates[0];
        int dillingerCol = dillingersCoordinates[1];
        filedMatrix[dillingerRow][dillingerCol] = "+";
        int totalRobbed = 0;

        for (int i = 0; i < moves.length; i++) {
            String command = moves[i];
            switch (command) {
                case "up":
                    if (isInBoundaries(filedMatrix, dillingerRow - 1, dillingerCol)) {

                        dillingerRow--;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }


                    break;
                case "down":
                    if (isInBoundaries(filedMatrix, dillingerRow + 1, dillingerCol)) {
                        dillingerRow++;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }

                    break;
                case "left":
                    if (isInBoundaries(filedMatrix, dillingerRow, dillingerCol - 1)) {
                        dillingerCol--;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }

                    break;
                case "right":
                    if (isInBoundaries(filedMatrix, dillingerRow, dillingerCol + 1)) {
                        dillingerCol++;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }

                    break;

            }
            if (caughtCheck(filedMatrix, dillingerRow, dillingerCol)) {
                System.out.printf( "You got caught with %d$, and you are going to jail.%n",totalRobbed );
                filedMatrix [dillingerRow][dillingerCol] = "#";
                printMatrix(filedMatrix);
                return;
            }
            if (checkForHouse(filedMatrix, dillingerRow, dillingerCol)) {
                int moneyStolen = dillingerRow*dillingerCol;
                totalRobbed +=moneyStolen;
                System.out.printf( "You successfully stole %d$.%n",moneyStolen);
                filedMatrix [dillingerRow][dillingerCol] = "+";

            }

        }
        filedMatrix [dillingerRow][dillingerCol] = "D";
        System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n",totalRobbed);
        printMatrix(filedMatrix);


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

    private static boolean caughtCheck(String[][] matrix, int row, int col) {
        return matrix[row][col].equals("P");
    }
    private static boolean checkForHouse(String[][] matrix, int row, int col){
        return matrix[row][col].equals("$");


    }
}
