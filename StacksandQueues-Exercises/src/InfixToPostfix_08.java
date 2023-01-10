import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfix_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> numbersQueue = new ArrayDeque<>();
        ArrayDeque<String> operationStack = new ArrayDeque<>();
        for (int i = 0; i < input.length; i++) {
            switch (input[i]) {
                case "+":
                case "-":
                case "*":
                case "/":
                operationStack.push(input[i]);
                    break;
                case "(":
                case ")":
                    break;
                default:
                    numbersQueue.offer(input[i]);
            }
        }
        System.out.println(numbersQueue);
        System.out.println(operationStack);
    }
}
