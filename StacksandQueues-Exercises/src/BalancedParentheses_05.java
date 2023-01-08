import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String parentheses = scanner.nextLine();
        if (parentheses.length()%2!=0){
            System.out.println("No");
        }else {
            int n = parentheses.length()/2;
            ArrayDeque<Character> stack = new ArrayDeque<>();
            boolean isBalanced = true;
            for (int i = 0; i <n ; i++) {
                stack.push(parentheses.charAt(i));
            }
            String parenthesesSubstring = parentheses.substring(n,parentheses.length());
            char symbol = 0 ;
            for (int i = 0; i <parenthesesSubstring.length() ; i++) {
                switch (parenthesesSubstring.charAt(i)){
                    case ')':
                        symbol = '(';
                        break;
                    case '}':
                        symbol = '{';
                        break;
                    case ']':
                        symbol = '[';
                        break;
                }
                if (symbol!=stack.pop()){
                    isBalanced = false;
                    break;
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
