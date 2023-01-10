import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String parentheses = scanner.nextLine();
        if (parentheses.length() % 2 != 0 || parentheses.length()==0) {
            System.out.println("NO");
        } else {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            boolean isBalanced = true;

            for (int i = 0; i < parentheses.length(); i++) {
               if (isBalanced){
                switch (parentheses.charAt(i)) {
                    case '(':
                    case '[':
                    case '{':
                        stack.push(parentheses.charAt(i));
                        break;
                    case ')':
                        if (stack.pop() != '(') {
                            isBalanced = false;
                        }
                        break;
                    case ']':
                        if (stack.pop() != '[') {
                            isBalanced = false;
                        }
                        break;
                    case '}':
                        if (stack.pop() != '{') {
                            isBalanced = false;
                        }
                        break;
                }
               }
            }
        if (isBalanced){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

        }


    }

}
