import java.util.Scanner;
import java.util.Stack;

public class MatchingBrackets_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Stack<Integer> indexes = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i)=='('){
                indexes.push(i);

            }else if (input.charAt(i)==')'){
                String partitionInput = input.substring(indexes.pop(),i+1);
                System.out.println(partitionInput);


            }


        }
    }
}
