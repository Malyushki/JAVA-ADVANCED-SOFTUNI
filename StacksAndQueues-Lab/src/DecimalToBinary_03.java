import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        if (number==0){
            System.out.println(number);
        }else {


        Stack<String> binary = new Stack<>();
        while (number!=0){
            binary.push(String.valueOf(number%2));
            number /=2;
        }
        Collections.reverse(binary);
        System.out.println(binary.toString().replaceAll("[\\[\\], ]",""));
    }
    }
}
