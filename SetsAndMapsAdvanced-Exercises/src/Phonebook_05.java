import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Phonebook_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputContact = scanner.nextLine();
        Map<String,String> phonebookMap = new TreeMap<>();

        while (!inputContact.equals("search")){
            String name = inputContact.split("-")[0];
            String phoneNumber = inputContact.split("-")[1];

            phonebookMap.putIfAbsent(name,phoneNumber);

            inputContact = scanner.nextLine();
        }
        String searchContact = scanner.nextLine();
        while (!searchContact.equals("stop")){

            if (phonebookMap.containsKey(searchContact)){
                System.out.printf("%s -> %s%n",searchContact,phonebookMap.get(searchContact));
            }else {
                System.out.printf("Contact %s does not exist.%n",searchContact);
            }


            searchContact = scanner.nextLine();
        }

    }
}
