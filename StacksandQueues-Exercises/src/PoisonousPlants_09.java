import java.util.*;

public class PoisonousPlants_09 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] plantsArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> plantsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> newPlantsQueue = new ArrayDeque<>();
        for (Integer e:plantsArr) {
            plantsQueue.offer(e);
        }
        int daysCount = 0;


        while (newPlantsQueue.size()!=plantsQueue.size()){
            daysCount++;
            int memoryLastPlant = plantsQueue.poll();
            newPlantsQueue.offer(memoryLastPlant);

            int rotations = plantsQueue.size();
            for (int i = 0; i <rotations ; i++) {

                if (!plantsQueue.isEmpty()) {
                    memoryLastPlant = plantsQueue.poll();
                    if (memoryLastPlant < plantsQueue.peek() && !plantsQueue.isEmpty()) {
                        newPlantsQueue.offer(memoryLastPlant);
                    }
                }
            }
            plantsQueue = new ArrayDeque<>(newPlantsQueue);
            newPlantsQueue = new ArrayDeque<>();


        }
        System.out.println(daysCount);
        System.out.println(newPlantsQueue);
    }
}
