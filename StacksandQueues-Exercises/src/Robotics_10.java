import java.util.*;

public class Robotics_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] robotsArr = scanner.nextLine().split(";");
        //  System.out.println(Arrays.toString(robotsArr));
        TreeMap<String, Integer> robotsMap = new TreeMap<>();
        for (String e : robotsArr) {
            String nameRobot = e.split("-")[0];
            int processTimeRobot = Integer.parseInt(e.split("-")[1]);
            robotsMap.put(nameRobot, processTimeRobot);
        }
        int[] startingTimeArr = Arrays.stream(scanner.nextLine().split(":")).mapToInt(Integer::parseInt).toArray();
        int stringTimeMinutes = startingTimeArr[0]*60*60+startingTimeArr[1]*60+startingTimeArr[2];
        System.out.println(stringTimeMinutes);
        String inputProduct = scanner.nextLine();
        ArrayDeque<String> products = new ArrayDeque<>();
        ArrayDeque<Map.Entry<String, Integer>> robotsQueue = new ArrayDeque<>();
        for (Map.Entry<String, Integer> element : robotsMap.entrySet()) {
                robotsQueue.offer(element);
        }
        System.out.println(robotsQueue);
        System.out.println(robotsQueue.pop().getValue());
        System.out.println(robotsMap);
        while (!inputProduct.equals("End")) {

            System.out.println(inputProduct);
            inputProduct = scanner.nextLine();
        }


    }
}
