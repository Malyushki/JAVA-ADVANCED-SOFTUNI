import java.util.Scanner;

public class RecursiveFibonacci_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(getFibonacci(n));

    }
    static long getFibonacci(int n){
        long fibonacciNumber = 1;
        if (n>1){
            long num1 = 1;
            long num2 = 1;
            for (int i = 2; i <= n; i++) {

                fibonacciNumber = num1 + num2;
                num1 = num2;
                num2 = fibonacciNumber;


            }
        }
    return fibonacciNumber;
    }
}
