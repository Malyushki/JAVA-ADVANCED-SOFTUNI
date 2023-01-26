import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<Character,Integer> charMap = new TreeMap<>();


        for (int i = 0; i <input.length() ; i++) {
            if (!charMap.containsKey(input.charAt(i))) {
                charMap.putIfAbsent(input.charAt(i), 0);
            }
            charMap.put(input.charAt(i), charMap.get(input.charAt(i)) + 1);
        }
            printMap(charMap);



    }
    private static void printMap(Map<Character,Integer> map){
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.printf("%s: %d time/s%n",entry.getKey(),entry.getValue());
        }


    }
}
