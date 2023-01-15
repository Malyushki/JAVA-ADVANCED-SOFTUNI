import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scanner.next();
            }
        }
        scanner.nextLine();
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] commandType = command.split("\\s+");
            if (commandType[0].equals("swap")&&commandType.length==5) {
                int row1 = Integer.parseInt(commandType[1]);
                int col1 = Integer.parseInt(commandType[2]);
                int row2 = Integer.parseInt(commandType[3]);
                int col2 = Integer.parseInt(commandType[4]);
                if (row1>rows-1 || row1<0 || row2>rows-1 || row2<0){
                    System.out.println("Invalid input!");

                }
                else if (col1>cols-1 || col1<0  || col2>cols-1 || col2<0 ){
                    System.out.println("Invalid input!");

                }else {
                    String cell1 = matrix[row1][col1];
                    String cell2 = matrix[row2][col2];
                    matrix[row1][col1] = cell2;
                    matrix[row2][col2] = cell1;
                    for (String [] element:matrix) {
                        System.out.println(Arrays.toString(element).replaceAll("[\\[\\],]",""));
                    }
                }


            }else {
                System.out.println("Invalid input!");

            }
        command = scanner.nextLine();
        }
    }
}
