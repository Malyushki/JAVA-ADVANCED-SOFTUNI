import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, String> mailMap = new LinkedHashMap<>();
        while (!command.equals("stop")) {
            String mail = scanner.nextLine();
            if (!mail.toLowerCase().contains(".us") && !mail.toLowerCase().contains(".uk") &&
                    !mail.toLowerCase().contains(".com")) {
                mailMap.putIfAbsent(command, mail);
            }
            command = scanner.nextLine();
        }
        printMap(mailMap);
    }

    private static void printMap(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
