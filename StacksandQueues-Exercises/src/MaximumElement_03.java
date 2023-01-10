import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumElement_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         int nCommands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <nCommands ; i++) {
            int [] commands = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            switch (commands[0]){
                case 1:
                stack.push(commands[1]);
                    break;
                case 2:
                  stack.pop();
                    break;
                case 3:
                    System.out.println(maxElement(stack));
                    break;


            }
        }

    }
    static int maxElement(ArrayDeque<Integer> stack){
        int maxElement = Integer.MIN_VALUE;
        for (Integer e:stack) {
            if (e>=maxElement){
                maxElement = e;
            }
        }
     return maxElement;
    }

}
