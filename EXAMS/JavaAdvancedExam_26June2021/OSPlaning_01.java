package EXAMS.JavaAdvancedExam_26June2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OSPlaning_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();
        ArrayDeque<Integer> threadsQue = new ArrayDeque<>();



        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).forEach(tasksStack::push);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(threadsQue::offer);

        int taskToBeKilled = Integer.parseInt(scanner.nextLine());

        while (!tasksStack.isEmpty() && !threadsQue.isEmpty()){
            int currentTask = tasksStack.pop();
            int currentThread = threadsQue.poll();

            if (currentThread<currentTask&&currentTask!=taskToBeKilled){
                tasksStack.push(currentTask);
            }
            if (currentTask==taskToBeKilled){
                    System.out.printf("Thread with value %d killed task %d%n",currentThread,taskToBeKilled);
                    threadsQue.push(currentThread);
                    break;
            }



        }

        System.out.println(threadsQue.toString().replaceAll("[,\\[\\]]",""));


    }
}
