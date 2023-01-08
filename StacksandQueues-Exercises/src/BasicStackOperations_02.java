    import java.util.ArrayDeque;
    import java.util.Arrays;
    import java.util.Scanner;

    public class BasicStackOperations_02 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int n = scanner.nextInt();
            int s = scanner.nextInt();
            int x = scanner.nextInt();
            scanner.nextLine();
         //   int [] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i <n ; i++) {
                stack.push(scanner.nextInt());
            }
            for (int i = 0; i <s ; i++) {
            stack.pop();
            }
           if (stack.contains(x)){
               System.out.println("true");
           }else {
               if (stack.isEmpty()) {
                   System.out.println("0");
               } else {

                   int smallestInt = Integer.MAX_VALUE;
                   for (Integer e : stack) {
                       if (e <= smallestInt) {
                           smallestInt = e;
                       }
                   }
                   System.out.println(smallestInt);

               }
           }
        }
    }
