import java.util.Arrays;
import java.util.Scanner;

public class E_MatrixShuffling_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dimensions = scanner.nextLine();
        int rows = Integer.parseInt(dimensions.split("\\s+")[0]);
        int cols = Integer.parseInt(dimensions.split("\\s+")[1]);
        String[][] matrix = new String[rows][cols];
        fillMatrix(matrix, scanner);
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            if (validateCommand(command,rows,cols)){
                swapInMatrix(matrix,command);
            }else {
                System.out.println("Invalid input!");
            }

            command = scanner.nextLine();
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

    private static boolean validateCommand(String command, int rows, int cols) {
        String[] commandParts = command.split("\\s+");
        if (commandParts.length != 5) {
            return false;
        }
        if (!command.contains("swap")) {
            return false;
        }
        int row1 = Integer.parseInt(commandParts[1]);
        int col1 = Integer.parseInt(commandParts[2]);
        int row2 = Integer.parseInt(commandParts[3]);
        int col2 = Integer.parseInt(commandParts[4]);

        if (row1 < 0 || row2 < 0 || col1 < 0 || col2 < 0) {
            return false;
        }

        if (row1 >= rows || row2 >= rows) {
            return false;
        }
        if (col1 >= cols || col2 >= cols) {
            return false;
        }
        return true;
    }
    private static void swapInMatrix(String[][] matrix,String command){
        String[] commandParts= command.split("\\s+");
        int row1 = Integer.parseInt(commandParts[1]);
        int col1 = Integer.parseInt(commandParts[2]);
        int row2 = Integer.parseInt(commandParts[3]);
        int col2 = Integer.parseInt(commandParts[4]);
        String firstElement = matrix[row1][col1];
        String secondElement = matrix[row2][col2];
        matrix[row1][col1] = secondElement;
        matrix[row2][col2] = firstElement;
        printMatrix(matrix);
    }
}
