package CompanyRoster_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Department> departmentList = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            String[] dataInput = scanner.nextLine().split("\\s+");
            String name = dataInput[0];
            double salary = Double.parseDouble(dataInput[1]);
            String position = dataInput[2];
            String department  = dataInput[3];
            if (department.length()==5){
                if ( dataInput[4].contains("@")){
                    String mail = dataInput[4];
                }else {
                    int age = Integer.parseInt(dataInput[4]);
                }

            }
            if (department.length()==6){
                String mail = dataInput[4];
                int age = Integer.parseInt(dataInput[4]);
                Employee employee = new Employee(name,salary,position,department,mail,age);
                if (departmentList.isEmpty()){

                }
            }
        }


    }
}
