package EXAMS.Java_Advanced_Exam_22October2022.src;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class EnergyDrinks_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> milligramsOfCaffeine = new ArrayDeque<>();
        ArrayDeque<Integer> energyDrinks = new ArrayDeque<>();
        //34, 2, 3
        //40, 100, 250
        int[] allCaffeine = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        for (int caffeine: allCaffeine) {
            milligramsOfCaffeine.push(caffeine);
        }
        int[] allDrinks = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        for (int drink: allDrinks) {
            energyDrinks.offer(drink);
        }

        int stamatMaxCaffeineValue = 0;
        while (!milligramsOfCaffeine.isEmpty()&&!energyDrinks.isEmpty()){
            int currentCaffeine = milligramsOfCaffeine.peek()*energyDrinks.peek();
            if (stamatMaxCaffeineValue+currentCaffeine>300){
                milligramsOfCaffeine.pop();
                energyDrinks.offer(energyDrinks.poll());
                if (stamatMaxCaffeineValue>30){
                    stamatMaxCaffeineValue-=30;
                }else {
                    stamatMaxCaffeineValue = 0;
                }

            }else {
                stamatMaxCaffeineValue+=currentCaffeine;
                milligramsOfCaffeine.pop();
                energyDrinks.poll();
            }
        }
        if (!energyDrinks.isEmpty()){
            //Drinks left: 100, 250
            System.out.printf("Drinks left: ");
            while (energyDrinks.size()>1){
                System.out.printf("%s, ",energyDrinks.poll());
            }
            System.out.println(energyDrinks.poll());

        }else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.%n",stamatMaxCaffeineValue);

    }
}
