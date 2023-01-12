import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

public class BrowserHistoryUpgrade_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        ArrayDeque<String> backUrlStack = new ArrayDeque<>();
        while (!command.equals("Home")){
            if (command.equals("back")){
                if (backUrlStack.size()<=1){
                    System.out.println("no previous URLs");
                }else {
                    ArrayDeque<String>forwardURLQueue = new ArrayDeque<>();
                   forwardURLQueue.offer(backUrlStack.pop());
                    System.out.println(backUrlStack.peek());
                }

                backUrlStack.isEmpty() ?  System.out.println("no previous URLs") :



            }else {
                System.out.println(backUrlStack.push());
            }
            command = scanner.nextLine();
        }
    }
}