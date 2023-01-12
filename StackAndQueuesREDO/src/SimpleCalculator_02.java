import java.util.*;

public class SimpleCalculator_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        Deque<String> calculator = new ArrayDeque<>();
        if (input.length==1){
            System.out.println(input[0]);

            return;
        }


        for (int i = input.length-1; i >=0 ; i--) {
            calculator.push(input[i]);
        }


        while (calculator.size() > 1) {
            int firstNumber = Integer.parseInt(calculator.pop());
            String operator = calculator.pop();
            int secondNumber = Integer.parseInt(calculator.pop());
            int result = 0;
            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                default:
                    System.out.println("invalid operator: " + operator);
                    return;
            }
            calculator.push("" + result);

        }
        System.out.println(calculator.peek());
    }
}
