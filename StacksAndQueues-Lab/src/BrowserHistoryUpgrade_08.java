import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

public class BrowserHistoryUpgrade_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> backUrlStack = new ArrayDeque<>();
        ArrayDeque<String> forwardURLQueue = new ArrayDeque<>();

        String command = scanner.nextLine();
        while (!command.equals("Home")) {

       /*     if (command.equals("back")) {
                if (backUrlStack.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    ArrayDeque<String> forwardURLQueue = new ArrayDeque<>();
                    forwardURLQueue.offer(backUrlStack.pop());
                    System.out.println(backUrlStack.peek());
                }
            }

   */       switch (command){
                case "back":
                    if (backUrlStack.size() <= 1) {
                        System.out.println("no previous URLs");
                    }else {
                        String backUrl = backUrlStack.pop();
                        System.out.println(backUrlStack.peek());
                        forwardURLQueue.push(backUrl);
                    }
                    break;
                case "forward":
                    if (forwardURLQueue.size() == 0) {
                        System.out.println("no next URLs");
                    }else {
                        String forwardURL = forwardURLQueue.pop();
                        System.out.println(forwardURL);
                        backUrlStack.push(forwardURL);
                    }
                    break;
                default:
                    String currentUrl = command;
                    backUrlStack.push(currentUrl);
                    System.out.println(currentUrl);
                    forwardURLQueue = new ArrayDeque<>();

                    break;
            }




                command = scanner.nextLine();
            }
        }
    }
