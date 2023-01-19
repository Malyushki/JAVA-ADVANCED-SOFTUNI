import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class E_StringMatrixRotation_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int command = Integer.parseInt(scanner.nextLine().replaceAll("[Rotate()]",""));

        List<String> words = new ArrayList<>();
        fillList(words, scanner);
        int rows = words.size();
        int cols = getColsSize(words);
        char[][] matrix = new char[rows][cols];
        fillMatrix(matrix, words);


            command= command%360;


        printRotation(command,matrix);
    }


    private static void fillList(List<String> words, Scanner scanner) {
        String scan = scanner.nextLine();
        while (!scan.equals("END")) {
            words.add(scan);
            scan = scanner.nextLine();
        }
    }

    private static int getColsSize(List<String> words) {
        int colsSize = Integer.MIN_VALUE;
        for (String e : words) {
            if (e.length() > colsSize) {
                colsSize = e.length();
            }
        }
        return colsSize;
    }

    private static void fillMatrix(char[][] matrix, List<String> words) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (col < words.get(row).length()) {
                    matrix[row][col] = words.get(row).charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }


            }
        }

    }

    private static void printMatrix(char[][] matrix) {
        int cols = matrix[0].length;
        int rows = matrix.length;

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
    private static void rotateMatrix90(char[][] matrix) {
        int cols = matrix[0].length;
        int rows = matrix.length;
        for (int col = 0; col < cols; col++) {
            for (int row = rows - 1; row >= 0; row--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
    private static void rotateMatrix180(char[][] matrix) {
        int cols = matrix[0].length;
        int rows = matrix.length;
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols-1; col >=0 ; col--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
    private static void rotateMatrix270(char[][] matrix) {
        int cols = matrix[0].length;
        int rows = matrix.length;

        for (int col = cols-1; col >=0 ; col--) {
            for (int row = 0; row < rows; row++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
    private static void printRotation(int command,char[][]matrix){
        switch (command){
            case 0:
                printMatrix(matrix);
                break;
            case 90:
                rotateMatrix90(matrix);
                break;
            case 180:
                rotateMatrix180(matrix);
                break;
            case 270:
                rotateMatrix270(matrix);
                break;
        }


    }
}
