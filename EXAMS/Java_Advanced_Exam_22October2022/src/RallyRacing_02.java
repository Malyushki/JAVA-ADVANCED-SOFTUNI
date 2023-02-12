package EXAMS.Java_Advanced_Exam_22October2022.src;

import java.util.Arrays;
import java.util.Scanner;

public class RallyRacing_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nSize = Integer.parseInt(scanner.nextLine());
        String[][] raceRoute = new String[nSize][nSize];
        String carNumber = scanner.nextLine();
        fillMatrix(raceRoute, scanner);
        int currentRowCar = 0;
        int currentColCar = 0;
        int kilometersPassed = 0;
        boolean finishedRace = false;
        String command = scanner.nextLine();
        while (true) {
            if (command.equals("End")) {
                raceRoute[currentRowCar][currentColCar] = "C";
                System.out.printf("Racing car %s DNF.%n", carNumber);
                break;
            }
            switch (command) {
                case "left":
                    currentColCar--;
                    break;
                case "right":
                    currentColCar++;

                    break;
                case "up":
                    currentRowCar--;

                    break;
                case "down":
                    currentRowCar++;
                    break;
            }

            if (raceRoute[currentRowCar][currentColCar].equals(".")) {
                kilometersPassed += 10;
            } else if (raceRoute[currentRowCar][currentColCar].equals("T")) {
                raceRoute[currentRowCar][currentColCar] = ".";
                int[] coordinatesOfTunnel = findElementInMatrix(raceRoute, "T");
                currentRowCar = coordinatesOfTunnel[0];
                currentColCar = coordinatesOfTunnel[1];
                kilometersPassed += 30;
                raceRoute[currentRowCar][currentColCar] = ".";
            } else if (raceRoute[currentRowCar][currentColCar].equals("F")) {
                kilometersPassed += 10;
                System.out.printf("Racing car %s finished the stage!%n", carNumber);
                raceRoute[currentRowCar][currentColCar] = "C";

                break;

            }


            command = scanner.nextLine();

        }
        System.out.printf("Distance covered %d km.%n",kilometersPassed);
        printMatrix(raceRoute);

    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] element : matrix) {
            System.out.println(Arrays.toString(element).replaceAll("[\\[\\], ]", ""));
        }
    }

    private static int[] findElementInMatrix(String[][] matrix, String element) {
        int[] coordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col].equals(element)) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                }
            }
        }

        return coordinates;
    }
}
