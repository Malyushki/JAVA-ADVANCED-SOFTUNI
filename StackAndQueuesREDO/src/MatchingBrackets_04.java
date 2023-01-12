import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MatchingBrackets_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Deque<Integer> bracketsHistory = new ArrayDeque<>();
        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)){
                case '(':
                    bracketsHistory.push(i);
                    break;
                case ')':
                    int firstIndex = bracketsHistory.pop();
                    String substring = text.substring(firstIndex,i+1);
                    System.out.println(substring);


        }
        }
    }
}
