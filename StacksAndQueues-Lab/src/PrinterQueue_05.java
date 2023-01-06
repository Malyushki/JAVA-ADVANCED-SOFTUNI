import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrinterQueue_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Queue<String> printOrderQueue = new LinkedList<>();
        while (!input.equals("print")){
            if (input.equals("cancel")){
                if (printOrderQueue.isEmpty()){
                    System.out.println("Printer is on standby");
                }else {
                    System.out.println("Canceled "+printOrderQueue.poll());
                }

            }else {
                printOrderQueue.offer(input);
            }

            input = scanner.nextLine();
        }

            while (!printOrderQueue.isEmpty()) {
                System.out.println(printOrderQueue.poll());
            }
        }
    }

