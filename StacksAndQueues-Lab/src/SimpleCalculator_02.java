import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class SimpleCalculator_02 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String [] input = scanner.nextLine().split(" ");
        Stack<String> stack= new Stack<>();
        for (String e :input) {
            stack.push(e);
        }
        Collections.reverse(stack);

        int sum = Integer.parseInt(stack.pop());
       while (!stack.isEmpty()){
            switch (stack.pop()){
                case "+":
                    sum +=Integer.parseInt(stack.pop());
                    break;
                case "-":
                    sum -=Integer.parseInt(stack.pop());
                    break;

            }
        }
        System.out.println(sum);
    }
}
