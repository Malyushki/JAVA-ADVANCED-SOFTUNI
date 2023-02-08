package EXAMS.JavaAdvancedExam_28June2020;

import java.util.*;

public class Bombs_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> bombEffectsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> bombCasingsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).forEach(bombEffectsQueue::offer);
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).forEach(bombCasingsStack::push);
        Map<String, Integer> bombsMap = new LinkedHashMap<>();

        bombsMap.put("Cherry Bombs", 0);
        bombsMap.put("Datura Bombs", 0);
        bombsMap.put("Smoke Decoy Bombs", 0);

        while (!bombCasingsStack.isEmpty() && !bombEffectsQueue.isEmpty()) {
            int currentCasing = bombCasingsStack.pop();
            int currentEffect = bombEffectsQueue.poll();
            int mixedValue = currentCasing + currentEffect;
            if (mixedValue == 120) {
                String currentBomb = "Smoke Decoy Bombs";
                bombsMap.put(currentBomb, bombsMap.get(currentBomb) + 1);
            } else if (mixedValue == 60) {
                String currentBomb = "Cherry Bombs";
                bombsMap.put(currentBomb, bombsMap.get(currentBomb) + 1);

            } else if (mixedValue == 40) {
                String currentBomb = "Datura Bombs";
                bombsMap.put(currentBomb, bombsMap.get(currentBomb) + 1);

            } else {
                currentCasing -= 5;
                bombCasingsStack.push(currentCasing);
                bombEffectsQueue.addFirst(currentEffect);
            }
            if (checkSucceeded(bombsMap)) {

                break;
            }
        }
        if (checkSucceeded(bombsMap)) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        System.out.print("Bomb Effects: ");
        if (!bombEffectsQueue.isEmpty()) {
            System.out.println(bombEffectsQueue.toString().replaceAll("[\\[\\]]", ""));
        } else {
            System.out.println("empty");
        }
        System.out.print("Bomb Casings: ");
        if (!bombCasingsStack.isEmpty()) {
            System.out.println(bombCasingsStack.toString().replaceAll("[\\[\\]]", ""));
        } else {
            System.out.println("empty");
        }
        bombsMap.entrySet()
                .forEach(c -> {
                            System.out.printf("%s: %d%n", c.getKey(), c.getValue());
                        }
                );

    }

    public static boolean checkSucceeded(Map<String, Integer> map) {
        int howManyToSucceed = 3;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() < howManyToSucceed) {
                return false;
            }
        }
        return true;

    }
}
