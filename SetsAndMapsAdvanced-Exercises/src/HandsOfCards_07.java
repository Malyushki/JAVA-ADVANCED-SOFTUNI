import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Set<String>> playersMap = new LinkedHashMap<>();
        Map<String, Integer> playersValueMap = new LinkedHashMap<>();


        while (!input.equals("JOKER")) {
            String name = input.split(":\\s+")[0];
            List<String> cards = Arrays.stream(input.split(":\\s+")[1].split(", ")).collect(Collectors.toList());
            Set<String> temSet = new HashSet<>(cards);

            if (!playersMap.containsKey(name)) {
                playersMap.putIfAbsent(name, temSet);
            } else {
                temSet.addAll(playersMap.get(name));
                playersMap.put(name, temSet);
            }


            input = scanner.nextLine();
        }

        printMap(playersMap);

    }

    private static void printMap(Map<String, Set<String>> map) {
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            int value = 0;
            for (String e:entry.getValue()) {
                char typeOfCard = e.toCharArray()[e.toCharArray().length-1];
                int multiplier = getMultiplier(typeOfCard);
                int currentValue = getCardValue(e);
                value +=currentValue*multiplier;

            }

            System.out.printf("%s: %s%n", entry.getKey(), value);
        }
    }

    private static int getMultiplier(char colorOfCards) {
        switch (colorOfCards) {
            case 'S':
                return 4;
            case 'H':
                return 3;
            case 'D':
                return 2;
            case 'C':
                return 1;
        }
        System.out.println("ERROR! Unreadable Type Of Card!");
        return -1;
    }
    private static int getCardValue(String card) {

    if (Character.isDigit(card.toCharArray()[0])) {
            return Integer.parseInt(card.substring(0,card.length()-1));

        } else {
            switch (card.toCharArray()[0]) {
                case 'J':
                    return  11;

                case 'Q':
                   return  12;

                case 'K':
                   return  13;

                case 'A':
                    return  14;

            }
        }
        System.out.println("ERROR! Unreadable Type Of Card!");
        return -1;
    }
}
//трябва от сетовете да сплитна чартовете, да заместя буквите и да умножа по стойности и да върна инт