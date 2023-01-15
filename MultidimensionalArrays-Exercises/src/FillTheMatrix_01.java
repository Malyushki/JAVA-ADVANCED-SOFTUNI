import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",\\s+");
        int n = Integer.parseInt(input[0]);
        char option = input[1].charAt(0);
        switch (option){
            case 'A':
            caseA(n);
                break;
            case 'B':
                caseB(n);
                break;
        }

    }
    static void caseA(int n){
        int [][] matrix = new int[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 1 + j*n + i;
            }
            }
        for (int [] e:matrix) {
            System.out.println(Arrays.toString(e).replaceAll("[\\[,\\]]",""));
        }
        }
    static void caseB(int n){
        int [][] matrix = new int[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < n; j++) {
                if (j%2==0){
                    matrix[i][j] = 1 + j*n + i;
                }else {

                    matrix[i][j] = n*(j+1) - i;
                }


            }
        }
        for (int [] e:matrix) {
            System.out.println(Arrays.toString(e).replaceAll("[\\[,\\]]",""));
        }
    }


    }


