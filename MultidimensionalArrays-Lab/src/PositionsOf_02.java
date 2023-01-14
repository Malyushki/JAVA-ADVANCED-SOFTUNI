import java.util.Scanner;

public class PositionsOf_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int [][] matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix [i][j] = scanner.nextInt();
            }
        }
        int checkNumber = scanner.nextInt();
        boolean notFound = true;
        for (int i = 0; i <r ; i++) {
            for (int j = 0; j <c ; j++) {
                if (matrix[i][j] == checkNumber){
                    System.out.println(i + " "+j);
                    notFound = false;
                }
            }
        }
        if (notFound){
            System.out.println("not found");
        }
    }
}
