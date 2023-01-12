
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistory_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Deque<String> history = new ArrayDeque<>();
        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (history.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    history.pop();
                    System.out.println(history.peek());
                }
            }else {

                history.push(input);
                System.out.println(history.peek());
            }


            input = scanner.nextLine();
        }
    }
}
