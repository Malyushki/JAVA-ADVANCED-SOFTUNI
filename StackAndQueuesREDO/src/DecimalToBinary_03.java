import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DecimalToBinary_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimal = Integer.parseInt(scanner.nextLine());
        Deque<Integer> binary = new ArrayDeque<>();
        if (decimal==0){
            System.out.println("0");
            return;
        }
        while (decimal>0){
            binary.push(decimal%2);
            decimal /=2;

        }
        for (Integer e: binary) {
            System.out.print(binary.pop());
        }
    }
}
