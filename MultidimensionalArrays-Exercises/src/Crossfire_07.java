//40 / 100
import java.util.Arrays;
import java.util.Scanner;

public class Crossfire_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                matrix[row][col] = String.valueOf((row * cols + 1 + col));
            }
        }

        scanner.nextLine();
        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            int rowCoordinates = Integer.parseInt(command.split("\\s+")[0]);
            int colCoordinates = Integer.parseInt(command.split("\\s+")[1]);
            int radius = Integer.parseInt(command.split("\\s+")[2]);
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (row <= rowCoordinates + radius && (row >= (rowCoordinates - radius)) && (col == colCoordinates)) {
                        matrix[row][col] = "a";
                    }
                    if (col <= colCoordinates + radius && (col >= (colCoordinates - radius)) && (row == rowCoordinates)) {
                        matrix[row][col] = "a";
                    }


                }
            }
            for (int row = 0; row < rows; row++) {
                String[] arr = new String[rows];
                Arrays.fill(arr, "0");

                int counter = 0;
                for (int i = 0; i < cols; i++) {
                    if (!matrix[row][i].equals("a")) {

                        arr[counter] = matrix[row][i];
                        counter++;
                    }
                }
                matrix[row] = arr;
            }

            command = scanner.nextLine();
        }

        for (String [] e:matrix) {
            for (String innerElement:e) {
                if (!innerElement.equals("0")){
                    System.out.print(innerElement+" ");
                }

            }
            System.out.println();
        }

    }
}
