package EXAMS.Java_Advanced_Exam_25June2022.src;

import java.util.*;

public class ItsChocolateTime_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //milk - que
        // cacao - stack

        ArrayDeque<Double> milkQueue = new ArrayDeque<>();
        ArrayDeque<Double> cacaoStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).forEach(milkQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).forEach(cacaoStack::push);
        Map<String, Integer> chocolatesMap = new TreeMap<>();
        chocolatesMap.put("Baking Chocolate", 0);
        chocolatesMap.put("Dark Chocolate", 0);
        chocolatesMap.put("Milk Chocolate", 0);

        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()) {
            double currentMilk = milkQueue.poll();
            double currentCacao = cacaoStack.pop();

            double currentCacaoPercentage = (currentCacao / (currentMilk + currentCacao)) * 100;
            // System.out.println(currentCacaoPercentage);
            if (currentCacaoPercentage == 100) {
                chocolatesMap.put("Baking Chocolate", chocolatesMap.get("Baking Chocolate") + 1);
            } else if (currentCacaoPercentage == 50) {
                chocolatesMap.put("Dark Chocolate", chocolatesMap.get("Dark Chocolate") + 1);
            } else if (currentCacaoPercentage == 30) {
                chocolatesMap.put("Milk Chocolate", chocolatesMap.get("Milk Chocolate") + 1);


            } else {
                milkQueue.addLast(currentMilk + 10);

            }
        }
        if (checkAllChocolatesDone(chocolatesMap)){
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        }else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        for (Map.Entry<String, Integer> entry : chocolatesMap.entrySet()) {
            if (entry.getValue()>0){
                System.out.printf("# %s --> %d%n",entry.getKey(),entry.getValue());
            }
        }

    }
    public  static boolean checkAllChocolatesDone(Map<String, Integer> chocolatesMap){
        for (Map.Entry<String, Integer> entry : chocolatesMap.entrySet()) {
            if (entry.getValue()<1){
                return false;
            }
        }
        return true;
    }
}
