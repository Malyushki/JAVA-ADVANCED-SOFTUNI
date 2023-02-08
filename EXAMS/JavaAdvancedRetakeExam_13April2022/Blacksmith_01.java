package EXAMS.JavaAdvancedRetakeExam_13April2022;

import java.util.*;

public class Blacksmith_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> steelQue = new ArrayDeque<>();
        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(steelQue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(carbonStack::push);
        Map<String,Integer> swordsMap = new HashMap<>();
        swordsMap.put("Gladius",0);
        swordsMap.put("Shamshir",0);
        swordsMap.put("Katana",0);
        swordsMap.put("Sabre",0);
        int countSwords = 0;
//Gladius	70
//Shamshir	80
//Katana	90
//Sabre	110

        while (!steelQue.isEmpty()&&!carbonStack.isEmpty()){
            int currentSteel = steelQue.poll();
            int currentCarbon = carbonStack.pop();
            //System.out.println(currentSteel + " : "+currentCarbon);

            int mixed = currentCarbon+currentSteel;
            if (mixed == 110) {
                swordsMap.put("Sabre",swordsMap.get("Sabre")+1);
                countSwords++;
            }else if (mixed==90){
                swordsMap.put("Katana",swordsMap.get("Katana")+1);
                countSwords++;
            }else if (mixed==80){
                swordsMap.put("Shamshir",swordsMap.get("Shamshir")+1);
                countSwords++;
            }else if (mixed==70){
                swordsMap.put("Gladius",swordsMap.get("Gladius")+1);
                countSwords++;
            }else {
                currentCarbon+=5;
                carbonStack.push(currentCarbon);
            }
        }
        if (countSwords>0){
            System.out.printf("You have forged %d swords.%n",countSwords);
        }else {
            System.out.println("You did not have enough resources to forge a sword.");
        }
        if (!steelQue.isEmpty()){
            System.out.print("Steel left: ");
            while (steelQue.size()>1){
                System.out.printf("%s, ",steelQue.poll());
            }
            System.out.println(steelQue.poll());
        }else {
            System.out.println("Steel left: none");
        }
        if (!carbonStack.isEmpty()){
            System.out.print("Carbon left: ");
            while (carbonStack.size()>1){
                System.out.printf("%s, ",carbonStack.pop());
            }
            System.out.println(carbonStack.pop());
        }else {
            System.out.println("Carbon left: none");
        }
        swordsMap.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(c -> {
                            if (c.getValue() > 0) {
                                System.out.printf("%s: %d%n", c.getKey(), c.getValue());
                            }
                        }
                );
    }
}
