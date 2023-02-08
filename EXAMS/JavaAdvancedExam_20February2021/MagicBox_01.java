package EXAMS.JavaAdvancedExam_20February2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MagicBox_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> magicBox1Queue = new ArrayDeque<>();
        ArrayDeque<Integer> magicBox2Stack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(magicBox1Queue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(magicBox2Stack::push);
        int totalSumOfClaimed = 0;
        while (!magicBox1Queue.isEmpty() && !magicBox2Stack.isEmpty()) {
            int currentItemMB1 = magicBox1Queue.poll();
            int currentItemMB2 = magicBox2Stack.pop();
            int sumOfItems = currentItemMB1 + currentItemMB2;
            if (sumOfItems % 2 == 0) {
                totalSumOfClaimed += sumOfItems;
            } else {
                magicBox1Queue.addFirst(currentItemMB1);
                magicBox1Queue.offer(currentItemMB2);
            }
        }

        if (magicBox1Queue.isEmpty()) {
            System.out.println("First magic box is empty.");
        }
        if (magicBox2Stack.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }

        if (totalSumOfClaimed>=90){
            System.out.printf("Wow, your prey was epic! Value: %d%n",totalSumOfClaimed);
        }else {
            System.out.printf("Poor prey... Value: %d%n",totalSumOfClaimed);
        }


    }

}
