///  77 / 100 точки


import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor_07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> memorizeText = new ArrayDeque<>();
        for (int i = 0; i <n ; i++) {
         String[] command = scanner.nextLine().split("\\s+");
            switch (command[0]){
                case "1":
                    text.append(command[1]);
                    memorizeText.push(text.toString());
                    break;
                case "2":
                    int count = Integer.parseInt(command[1]);
                    text = text.delete(text.length()-count,text.length());
                    memorizeText.push(text.toString());
                    break;
                case "3":
                    int index = Integer.parseInt(command[1]);
                    System.out.println(text.charAt(index-1));
                    break;
                case "4":
                    memorizeText.pop();
                    text = new StringBuilder(memorizeText.peek());

                    break;




            }

        }
    }
}
