import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();
        int [] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        if (numbers.length==1){
            System.out.println(numbers[0]);
        }else {

            for (int e : numbers) {
                numbersStack.push(e);
            }
            for (int e : numbersStack) {
                System.out.print(numbersStack.pop() + " ");
            }
        }
    }
}
