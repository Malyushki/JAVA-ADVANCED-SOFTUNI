package EXAMS.JavaAdvancedRetakeExam_19August2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> rosesQueue = new ArrayDeque<>();
        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).forEach(liliesStack::push);

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).forEach(rosesQueue::offer);
        int countWreaths = 0;
        int leftFlowers = 0;
        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()){
            int  currentTulips = liliesStack.pop();
            int  currentDaffodils = rosesQueue.poll();
            int sumOfFlowers = currentDaffodils+currentTulips;
            if (sumOfFlowers==15){
                countWreaths++;
            } else if (sumOfFlowers<15) {
                leftFlowers+=sumOfFlowers;
            }else {
                currentTulips-=2;
                liliesStack.push(currentTulips);
                rosesQueue.addFirst(currentDaffodils);

            }
        }
        while (leftFlowers>=15){
            countWreaths++;
            leftFlowers-=15;
        }
        if (countWreaths>=5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n",countWreaths);
        }else {
            System.out.printf("You didn't make it, you need %d wreaths more!",5-countWreaths);
        }
    }
}
