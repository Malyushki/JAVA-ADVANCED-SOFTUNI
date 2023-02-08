package EXAMS.Java_Advanced_Retake_Exam_18August2022.src;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class KAT_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Long> platesNumbs = new ArrayDeque<>();
        ArrayDeque<Long> carsNumbs = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToLong(Long::parseLong).forEach(platesNumbs::offer);

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToLong(Long::parseLong).forEach(carsNumbs::push);
        int countCars = 0;
        int countDays = 0;

        while (!platesNumbs.isEmpty() && !carsNumbs.isEmpty()) {
            countDays++;
            long currentDayPlates = platesNumbs.poll();
            long currentDayCars = carsNumbs.pop();

            if (currentDayPlates > currentDayCars * 2) {
                countCars += currentDayCars;
                platesNumbs.addLast(currentDayPlates - (2 * currentDayCars));


            } else if (currentDayPlates < currentDayCars * 2) {

                carsNumbs.addLast(currentDayCars - (currentDayPlates / 2));
                countCars += currentDayPlates / 2;

            } else {
                countCars += currentDayCars;

            }
        }

            System.out.printf("%d cars were registered for %d days!%n", countCars, countDays);

        if (!platesNumbs.isEmpty()) {
            long sumOfUnplacedPlates = 0;
            while (!platesNumbs.isEmpty()){
                sumOfUnplacedPlates += platesNumbs.poll();
            }
            System.out.printf("%d license plates remain!" ,sumOfUnplacedPlates);
        } else if (!carsNumbs.isEmpty()){
            long sumOfCarsWithoutPlate = 0;
            while (!carsNumbs.isEmpty()) {
                sumOfCarsWithoutPlate += carsNumbs.pop();
            }
            System.out.printf("%d cars remain without license plates!" ,sumOfCarsWithoutPlate);
        } else {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
}
