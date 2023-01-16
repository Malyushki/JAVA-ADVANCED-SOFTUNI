import java.util.Arrays;
import java.util.Scanner;

public class Crossfire_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] matrix = new int[rows][cols];
        for (int row = 0; row <rows ; row++) {
            for (int col = 0; col <cols ; col++) {
                matrix[row][col] = row*cols +1+col;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        scanner.nextLine();
        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")){
            int rowCoordinates = Integer.parseInt(command.split("\\s+")[0]);
            int colCoordinates = Integer.parseInt(command.split("\\s+")[1]);
            int radius = Integer.parseInt(command.split("\\s+")[2]);



        }
    }
}
