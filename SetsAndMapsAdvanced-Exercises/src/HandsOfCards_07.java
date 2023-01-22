import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Set<String>> playersMap = new LinkedHashMap<>();


        while (!input.equals("JOKER")){
            String name = input.split(":\\s+")[0];
            List<String> cards = Arrays.stream(input.split(":\\s+")[1].split(", ")).collect(Collectors.toList());
            Set<String> temSet = new HashSet<>(cards);

            if (!playersMap.containsKey(name)){
                playersMap.putIfAbsent(name,temSet);
            }else {
                temSet.addAll(playersMap.get(name));
                playersMap.put(name, temSet);
            }




            input = scanner.nextLine();
        }
            printMap(playersMap);

    }
    private static void printMap(Map<String, Set<String>> map) {
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
//трябва от сетовете да сплитна чартовете, да заместя буквите и да умножа по стойности и да върна инт