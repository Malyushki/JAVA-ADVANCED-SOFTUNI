package EXAMS.JavaAdvancedExam_22Feb2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Lootbox_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> firstLootBoxQueue = new ArrayDeque<>();
        Deque<Integer> secondLootBoxStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(firstLootBoxQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(secondLootBoxStack::push);
        int totalSum = 0 ;

        while (!firstLootBoxQueue.isEmpty()&&!secondLootBoxStack.isEmpty()){
            int currentItemLB1 = firstLootBoxQueue.poll();
            int currentItemLB2 = secondLootBoxStack.pop();
            int sum = currentItemLB1 + currentItemLB2;
            if (sum%2==0){
            totalSum+=sum;

            }else {
                firstLootBoxQueue.addFirst(currentItemLB1);
                firstLootBoxQueue.offer(currentItemLB2);
            }
        }
        if (firstLootBoxQueue.isEmpty()){
            System.out.println("First lootbox is empty");
        }else {
            System.out.println("Second lootbox is empty");
        }
        if (totalSum>=100){
            System.out.printf("Your loot was epic! Value: %d%n",totalSum);
        }else {
            System.out.printf("Your loot was poor... Value: %d%n",totalSum);
        }
    }
}
