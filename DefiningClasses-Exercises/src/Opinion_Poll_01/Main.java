package Opinion_Poll_01;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String,Person> personMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            //Peter 12
            String[] inputData = scanner.nextLine().split("\\s+");
            String name = inputData[0];
            int age = Integer.parseInt(inputData[1]);
            personMap.putIfAbsent(name,new Person(name,age));
        }

        for (Map.Entry<String, Person> entry : personMap.entrySet()) {
            entry.getValue().isAbove30();
        }


    }
}
