package EXAMS.JavaAdvancedExam_23October2021;

import java.util.*;

public class AutumnCocktails_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> numberOfIngredientsQue = new ArrayDeque<>();
        ArrayDeque<Integer> freshnessOfIngredientsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(numberOfIngredientsQue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(freshnessOfIngredientsStack::push);

        Map<String, Integer> cocktailsMap = new TreeMap<>();
        cocktailsMap.put("Pear Sour", 0);
        cocktailsMap.put("The Harvest", 0);
        cocktailsMap.put("Apple Hinny", 0);
        cocktailsMap.put("High Fashion", 0);

        while (!numberOfIngredientsQue.isEmpty() && !freshnessOfIngredientsStack.isEmpty()) {
            while (!numberOfIngredientsQue.isEmpty() && numberOfIngredientsQue.peek() == 0) {
                numberOfIngredientsQue.poll();
            }
            if (numberOfIngredientsQue.isEmpty()) {
                break;
            }

            int currentNumber = numberOfIngredientsQue.poll();
            int currentFreshness = freshnessOfIngredientsStack.pop();
            int mixedValue = currentNumber * currentFreshness;

            if (mixedValue == 400) {
                String madeCocktail = "High Fashion";
                cocktailsMap.put(madeCocktail, cocktailsMap.get(madeCocktail) + 1);

            } else if (mixedValue == 300) {
                String madeCocktail = "Apple Hinny";
                cocktailsMap.put(madeCocktail, cocktailsMap.get(madeCocktail) + 1);
            } else if (mixedValue == 250) {
                String madeCocktail = "The Harvest";
                cocktailsMap.put(madeCocktail, cocktailsMap.get(madeCocktail) + 1);
            } else if (mixedValue == 150) {
                String madeCocktail = "Pear Sour";
                cocktailsMap.put(madeCocktail, cocktailsMap.get(madeCocktail) + 1);
            } else {
                currentNumber += 5;
                numberOfIngredientsQue.offer(currentNumber);


            }
        }

        if (checkSucceeded(cocktailsMap)) {
            System.out.println("It's party time! The cocktails are ready!");
        }else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!numberOfIngredientsQue.isEmpty()){
            int sum = 0;
            for (int e:numberOfIngredientsQue) {
                sum +=e;
            }
            System.out.println("Ingredients left: "+sum);

        }
        cocktailsMap.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(c -> {
                            if (c.getValue() > 0) {
                                System.out.printf("# %s --> %d%n", c.getKey(), c.getValue());
                            }
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
