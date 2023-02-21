package JavaAdvancedExam18February2023;

import java.util.*;

public class ApocalypsePreparation_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> textilesQueue = new ArrayDeque<>();
        ArrayDeque<Integer> medicamentStack = new ArrayDeque<>();


        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(textilesQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(medicamentStack::push);
        Map<String, Integer> medKitMap = new HashMap<>();
        medKitMap.put("Bandage", 0);
        medKitMap.put("MedKit", 0);
        medKitMap.put("Patch", 0);
        while (!textilesQueue.isEmpty() && !medicamentStack.isEmpty()) {
            int currentMed = medicamentStack.pop();
            int currentTex = textilesQueue.poll();
            int sum = currentMed + currentTex;

            if (sum == 100) {
                String currentItem = "MedKit";
                medKitMap.put(currentItem, medKitMap.get(currentItem) + 1);
            } else if (sum == 40) {
                String currentItem = "Bandage";
                medKitMap.put(currentItem, medKitMap.get(currentItem) + 1);
            } else if (sum == 30) {
                String currentItem = "Patch";
                medKitMap.put(currentItem, medKitMap.get(currentItem) + 1);


            } else if (sum > 100) {
                String currentItem = "MedKit";
                medKitMap.put(currentItem, medKitMap.get(currentItem) + 1);
                sum -= 100;
                sum += medicamentStack.pop();
                medicamentStack.push(sum);

            }
            else {
                currentMed += 10;
                medicamentStack.push(currentMed);
            }
        }

        if (medicamentStack.isEmpty() && textilesQueue.isEmpty()){
            System.out.println("Textiles and medicaments are both empty.");
        } else if (medicamentStack.isEmpty() && !textilesQueue.isEmpty()) {
            System.out.println("Medicaments are empty.");

        }else {
            System.out.println("Textiles are empty.");
        }
        medKitMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));


        if (!medicamentStack.isEmpty()){
            System.out.println("Medicaments left: "+medicamentStack.toString().replaceAll("[\\[\\]]",""));
        }

        if (!textilesQueue.isEmpty()){
            System.out.println("Textiles left: "+textilesQueue.toString().replaceAll("[\\[\\]]",""));
        }


    }
}
