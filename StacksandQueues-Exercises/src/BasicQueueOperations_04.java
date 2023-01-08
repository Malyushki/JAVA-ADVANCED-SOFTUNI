import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();
        scanner.nextLine();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            queue.offer(scanner.nextInt());
        }
        for (int i = 0; i < s; i++) {
            queue.poll();
        }
        if (queue.isEmpty()) {
            System.out.println("0");
        } else if (queue.contains(x)) {
            System.out.println("true");

        } else {
            int smallestElement = Integer.MAX_VALUE;
            for (Integer e : queue) {
                if (e <= smallestElement) {
                    smallestElement = e;
                }
            }
            System.out.println(smallestElement);
        }
    }
}
