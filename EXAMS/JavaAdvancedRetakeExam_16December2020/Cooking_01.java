package EXAMS.JavaAdvancedRetakeExam_16December2020;

import java.util.*;

public class Cooking_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();


        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(liquidsQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(ingredientsStack::push);
        Map<String, Integer> foodMap = new LinkedHashMap<>();
        foodMap.put("Bread",0);
        foodMap.put("Cake",0);
        foodMap.put("Fruit Pie",0);
        foodMap.put("Pastry",0);


        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {

            int currentLiquid = liquidsQueue.poll();
            int currentIngredient = ingredientsStack.pop();
            int mixedSum = currentLiquid + currentIngredient;
            if (mixedSum==100){
                String currentFood = "Fruit Pie";
                foodMap.put(currentFood,foodMap.get(currentFood)+1);
            } else if (mixedSum==75) {
                String currentFood = "Pastry";
                foodMap.put(currentFood,foodMap.get(currentFood)+1);

            }else if (mixedSum==50) {
                String currentFood = "Cake";
                foodMap.put(currentFood,foodMap.get(currentFood)+1);

            }else if (mixedSum==25) {
                String currentFood = "Bread";
                foodMap.put(currentFood,foodMap.get(currentFood)+1);

            }else {
                currentIngredient+=3;
                ingredientsStack.push(currentIngredient);
            }
        }
        if (checkSucceeded(foodMap)){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
        System.out.print("Liquids left: ");
        if (!liquidsQueue.isEmpty()){
            System.out.println(liquidsQueue.toString().replaceAll("[\\[\\]]",""));
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
