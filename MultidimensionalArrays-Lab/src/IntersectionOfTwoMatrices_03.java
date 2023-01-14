import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int r = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        char[][] AMatrices = new char[r][c];
        char[][] BMatrices = new char[r][c];
        for (int i = 0; i < r; i++) {
            AMatrices[i] = scanner.nextLine().replace(" ", "").toCharArray();
        }
        for (int i = 0; i < r; i++) {
            BMatrices[i] = scanner.nextLine().replace(" ", "").toCharArray();
        }
        char[][] CMatrices = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (AMatrices[i][j] == BMatrices[i][j]) {
                    CMatrices[i][j] = AMatrices[i][j];
                } else {
                    CMatrices[i][j] = '*';

                }
                System.out.print(CMatrices[i][j] + " ");
            }
            System.out.println();
        }
    }


}

