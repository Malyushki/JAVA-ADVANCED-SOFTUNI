import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rAndc = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rAndc][rAndc];
        for (int i = 0; i < rAndc; i++) {
            for (int j = 0; j < rAndc; j++) {
                matrix[i][j] = scanner.nextInt();
            }

        }

        String firstDiagonal = "";
        String secondDiagonal = "";

        for (int i = 0; i < rAndc; i++) {

            firstDiagonal += matrix[i][i] + " ";
            secondDiagonal += matrix[rAndc-1-i][i] + " ";
        }
        System.out.println(firstDiagonal);
        System.out.println(secondDiagonal);
    }
}

