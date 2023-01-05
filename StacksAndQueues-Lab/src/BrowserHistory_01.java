import java.util.Scanner;
import java.util.Stack;

public class BrowserHistory_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Stack<String> urlStack = new Stack<>();
        while (!command.equals("Home")){
            if (command.equals("back")){
                if (urlStack.size()<=1){
                    System.out.println("no previous URLs");
                }else {
                    urlStack.pop();
                    System.out.println(urlStack.peek());
                }
            }else {
                System.out.println(urlStack.push(command));
            }
            command = scanner.nextLine();
        }
    }
}
