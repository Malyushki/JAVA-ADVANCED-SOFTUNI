import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] names = scanner.nextLine().split("\\s+");
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String e:names) {
            queue.offer(e);
        }
        int n = Integer.parseInt(scanner.nextLine());

        while (queue.size()>1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            System.out.println("Removed "+queue.poll());
        }
        System.out.println("Last is "+queue.poll());
    }
}
