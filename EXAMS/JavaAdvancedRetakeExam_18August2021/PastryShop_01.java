package EXAMS.JavaAdvancedRetakeExam_18August2021;

import java.util.*;

public class PastryShop_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> liquidsQue = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(liquidsQue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(ingredientsStack::push);

        Map<String, Integer> foodMap = new LinkedHashMap<>();
        foodMap.put("Biscuit", 0);
        foodMap.put("Cake", 0);
        foodMap.put("Pie", 0);
        foodMap.put("Pastry", 0);

        while (!ingredientsStack.isEmpty() && !liquidsQue.isEmpty()) {
            int currentIngredient = ingredientsStack.pop();
            int currentLiquid = liquidsQue.poll();
            int mixedValue = currentLiquid + currentIngredient;
            if (mixedValue == 100) {
                String currentMeal = "Pie";
                foodMap.put(currentMeal, foodMap.get(currentMeal) + 1);

            } else if (mixedValue == 75) {
                String currentMeal = "Pastry";
                foodMap.put(currentMeal, foodMap.get(currentMeal) + 1);

            } else if (mixedValue == 50) {
                String currentMeal = "Cake";
                foodMap.put(currentMeal, foodMap.get(currentMeal) + 1);

            } else if (mixedValue == 25) {
                String currentMeal = "Biscuit";
                foodMap.put(currentMeal, foodMap.get(currentMeal) + 1);

            } else {
                currentIngredient+=3;
                ingredientsStack.push(currentIngredient);

            }
        }
        if (checkSucceeded(foodMap)){
            System.out.println("Great! You succeeded in cooking all the food!");
        }else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        System.out.print("Liquids left: ");
        if (!liquidsQue.isEmpty()){
            System.out.println(liquidsQue.toString().replaceAll("[\\[\\]]",""));
        }else {
            System.out.println("none");
        }
        System.out.print("Ingredients left: ");
        if (!ingredientsStack.isEmpty()){
            System.out.println(ingredientsStack.toString().replaceAll("[\\[\\]]",""));
        }else {
            System.out.println("none");
        }
        foodMap.entrySet().forEach(c -> {

                                System.out.printf("%s: %d%n", c.getKey(), c.getValue());

                        }
                );



    }
    public static boolean checkSucceeded(Map<String, Integer> map) {
        int howManyToSucceed = 1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() < howManyToSucceed) {
                return false;
            }
        }
        return true;

    }
}
