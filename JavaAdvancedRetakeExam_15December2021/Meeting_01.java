package JavaAdvancedRetakeExam_15December2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Meeting_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        ArrayDeque<Integer> femalesQue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(malesStack::push);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(femalesQue::offer);
        int matcherCounter = 0;
        while (!malesStack.isEmpty() && !femalesQue.isEmpty()) {
            while (!malesStack.isEmpty() && malesStack.peek() <= 0) {
                malesStack.pop();
            }
            while (!femalesQue.isEmpty() && femalesQue.peek() <= 0) {
                femalesQue.poll();
            }
            if (malesStack.isEmpty() || femalesQue.isEmpty()) {
                break;
            }

           while (!malesStack.isEmpty() && malesStack.peek() % 25 == 0) {
                malesStack.pop();
                if (!malesStack.isEmpty()) {
                    malesStack.pop();
                }
            }
            while (!femalesQue.isEmpty() && femalesQue.peek() % 25 == 0) {
                femalesQue.poll();
                if (!femalesQue.isEmpty()) {
                    femalesQue.poll();
                }
            }

            if (malesStack.isEmpty() || femalesQue.isEmpty()) {
                break;
            }

            int currentMale = malesStack.pop();
            int currentFemale = femalesQue.poll();
            if (currentFemale != currentMale) {
                currentMale -= 2;
                malesStack.push(currentMale);

            } else {
                matcherCounter++;
            }


        }

        System.out.println("Matches: " + matcherCounter);
        System.out.print("Males left: ");
        if (!malesStack.isEmpty()) {
            System.out.println(malesStack.toString().replaceAll("[\\[\\]]",""));
          /*  while (malesStack.size() > 1) {
                System.out.printf("%d, ", malesStack.pop());
            }
            System.out.println(malesStack.pop());

           */
        }else {
            System.out.println("none");
        }
        System.out.print("Females left: ");
        if (!femalesQue.isEmpty()) {
            System.out.println(femalesQue.toString().replaceAll("[\\[\\]]",""));
          /*  while (femalesQue.size() > 1) {
                System.out.printf("%d, ", femalesQue.poll());
            }
            System.out.println(femalesQue.poll());

           */
        }else {
            System.out.println("none");
        }






    }

}
