import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int [][] matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int maxMatrixValue = Integer.MIN_VALUE;
        int maxStartingRow = -1;
        int maxStartingCol = -1;
        for (int i = 0; i < r-2; i++) {
            for (int j = 0; j < c-2; j++) {
                int sum = matrix[i][j] +matrix[i][j+1] +matrix[i][j+2]
                        + matrix[i+1][j] +matrix[i+1][j+1] +matrix[i+1][j+2]
                        +matrix[i+2][j] +matrix[i+2][j+1] +matrix[i+2][j+2];

                if (sum>maxMatrixValue){
                    maxMatrixValue = sum;
                    maxStartingRow = i;
                    maxStartingCol = j;
                }
            }
        }

        System.out.println("Sum = "+maxMatrixValue);
        for (int row = maxStartingRow; row <maxStartingRow+3 ; row++) {
            for (int col = maxStartingCol; col <maxStartingCol+3 ; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
