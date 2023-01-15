import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
       String[][] matrix = new String[r][c];
        for (int i = 0; i <r ; i++) {
            for (int j = 0; j <c ; j++) {
                char[] charsArr= {(char) (i+97), (char) (j+97+i), (char) (i+97)};
              String code = new String(charsArr);
                matrix[i][j] = code;

            }
        }

        for (String []e:matrix) {
            System.out.println(Arrays.toString(e).replaceAll("[\\[,\\]]",""));
        }
    }
}
