package EXAMS.JavaAdvancedRetakeExam_14April2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> daffodilsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).forEach(tulipsStack::push);

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).forEach(daffodilsQueue::offer);
        int countBouquet = 0;
        int leftFlowers = 0;
        while (!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()){
          int  currentTulips = tulipsStack.pop();
          int  currentDaffodils = daffodilsQueue.poll();
          int sumOfFlowers = currentDaffodils+currentTulips;
            if (sumOfFlowers==15){
                countBouquet++;
            } else if (sumOfFlowers<15) {
                leftFlowers+=sumOfFlowers;
            }else {
                currentTulips-=2;
                tulipsStack.push(currentTulips);
                daffodilsQueue.addFirst(currentDaffodils);

            }
        }
        while (leftFlowers>=15){
            countBouquet++;
            leftFlowers-=15;
        }
      if (countBouquet>=5){
          System.out.printf("You made it! You go to the competition with %d bouquets!%n",countBouquet);
      }else {
          System.out.printf("You failed... You need more %d bouquets.",5-countBouquet);
      }
    }
}
