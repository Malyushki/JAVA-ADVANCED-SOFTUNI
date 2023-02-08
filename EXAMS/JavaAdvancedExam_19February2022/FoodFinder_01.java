package EXAMS.JavaAdvancedExam_19February2022;

import java.util.*;

public class FoodFinder_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> vowelsQue = new ArrayDeque<>();
        ArrayDeque<String> consonantsStack = new ArrayDeque<>();
        String[] words = new String[]{"pear", "flour", "pork", "olive"};
        ArrayList<String> wordsFound = new ArrayList<>();
        int countFoundWords = 0;

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(vowelsQue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(consonantsStack::push);
        List<Character> lettersList = new ArrayList<>();

        while (!consonantsStack.isEmpty()) {
            String currentVowel = vowelsQue.poll();
            String currentConsonant = consonantsStack.pop();
            lettersList.add(currentVowel.toCharArray()[0]);
            lettersList.add(currentConsonant.toCharArray()[0]);
            vowelsQue.offer(currentVowel);
        }
        for (String word : words) {
            if (isContained(word, lettersList)) {
                wordsFound.add(word);
                countFoundWords++;
            }
        }
        System.out.println("Words found: " + countFoundWords);
        for (String e:wordsFound) {
            System.out.println(e);
        }
    }

    public static boolean isContained(String word, List<Character> lettersList) {
        char[] wordArr = word.toCharArray();
        String letters = lettersList.toString();
        // System.out.println(letters);

        for (int i = 0; i < wordArr.length; i++) {
            if (!letters.contains(wordArr[i] + "")) {
                return false;
            }
        }
        return true;
    }
}
