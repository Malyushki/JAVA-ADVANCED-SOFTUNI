package EXAMS.JavaAdvancedRetakeExam_17Dec2019;

import java.util.*;

public class SantaPresentFactory_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> materialsStack = new ArrayDeque<>();
        Deque<Integer> magicQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(materialsStack::push);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(magicQueue::offer);
        Map<String,Integer> presentsMap = new LinkedHashMap<>();
presentsMap.put("Bicycle",0);
presentsMap.put("Doll",0);
presentsMap.put("Teddy bear",0);
presentsMap.put("Wooden train",0);


        while (!magicQueue.isEmpty()&&!materialsStack.isEmpty()){
            while (!magicQueue.isEmpty()&&magicQueue.peek()==0){
                magicQueue.poll();

            }
            while (!materialsStack.isEmpty()&&materialsStack.peek()==0){
                materialsStack.pop();

            }
            if (materialsStack.isEmpty()){
                break;
            }
            if (magicQueue.isEmpty()){
                break;
            }

            int currentMagic = magicQueue.poll();
            int currentMaterial = materialsStack.pop();
            int totalMagic = currentMagic*currentMaterial;



            if (totalMagic==400){
                String currentPresent = "Bicycle";
                presentsMap.put(currentPresent,presentsMap.get(currentPresent)+1);
            }else if (totalMagic==300){
                String currentPresent = "Teddy bear";
                presentsMap.put(currentPresent,presentsMap.get(currentPresent)+1);
            }else if (totalMagic==250){
                String currentPresent = "Wooden train";
                presentsMap.put(currentPresent,presentsMap.get(currentPresent)+1);
            }else if (totalMagic==150){
                String currentPresent = "Doll";
                presentsMap.put(currentPresent,presentsMap.get(currentPresent)+1);
            }else if (totalMagic<0){
                int newMaterial = currentMaterial+currentMagic;
                materialsStack.push(newMaterial);

            } else if (totalMagic>0) {
                currentMaterial+=15;
                materialsStack.push(currentMaterial);
            }


        }
        if (presentsMap.get("Doll")>=1&&presentsMap.get("Wooden train")>=1||presentsMap.get("Teddy bear")>=1&&presentsMap.get("Bicycle")>=1){
            System.out.println("The presents are crafted! Merry Christmas!");
        }else {
            System.out.println("No presents this Christmas!");
        }

        if (!materialsStack.isEmpty()){
            System.out.print("Materials left: ");
            System.out.println(materialsStack.toString().replaceAll("[\\[\\]]",""));
        }
        if (!magicQueue.isEmpty()){
            System.out.print("Magic left: ");
            System.out.println(magicQueue.toString().replaceAll("[\\[\\]]",""));
        }
        presentsMap.entrySet()
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
