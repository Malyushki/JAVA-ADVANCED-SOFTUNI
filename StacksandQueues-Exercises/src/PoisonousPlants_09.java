import java.util.*;

public class PoisonousPlants_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] plantsArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> plantsQueue = new ArrayDeque<>();

        for (Integer e : plantsArr) {
            plantsQueue.offer(e);
        }
        int daysCount = -1;
        int m = 0;
        while (m != plantsQueue.size()) {
            int leftPlant = plantsQueue.poll();
            plantsQueue.offer(leftPlant);
            daysCount++;
            m = plantsQueue.size();
            for (int i = 0; i < m - 1; i++) {
                int rightPlant = plantsQueue.poll();
                if (rightPlant <= leftPlant) {
                    plantsQueue.offer(rightPlant);
                }
                leftPlant = rightPlant;

            }


        }

        System.out.println(daysCount);

    }

}

