import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TheHeiganDance_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double heroAttackPoints = Double.parseDouble(scanner.nextLine());
        double[][] chamber = new double[15][15];
        for (int row = 0; row < 15; row++) {
            for (int col = 0; col < 15; col++) {

                chamber[row][col] = 0;
            }
        }
        double heroHealthPoints = 18500;
        double heiganHealthPoints = 3000000;
        //     int heroRow = 7;
        //   int heroCol = 7;
        int[] heroPosition = {7, 7};
        //    System.out.println(Arrays.deepToString(chamber));
        List<List<Integer>> cloudSpellMemory = new ArrayList<>();
        while (heroHealthPoints > 0) {
            String[] command = scanner.nextLine().split("\\s+");
            heiganHealthPoints -= heroAttackPoints;
            if (heiganHealthPoints <= 0) {
                System.out.println("Heigan: Defeated!");
                System.out.printf("Player: %.0f%n", heroHealthPoints);
                System.out.printf("Final position: %d, %d%n", heroPosition[0], heroPosition[1]);
                return;
            }

            switch (command[0]) {
                case "Cloud":
                    int cloudRow = Integer.parseInt(command[1]);
                    int cloudCol = Integer.parseInt(command[2]);
                    chamber = CloudSpell(chamber, cloudRow, cloudCol);
                    heroPosition = PlayerMovement(chamber, heroPosition);
                    System.out.println(Arrays.toString(heroPosition));
                    cloudSpellMemory.add(new ArrayList<>(Arrays.asList(3, cloudRow, cloudCol)));
                    heroHealthPoints += chamber[heroPosition[0]][heroPosition[1]];
                    break;
                case "Eruption":

                    int eruptionRow = Integer.parseInt(command[1]);
                    int eruptionCol = Integer.parseInt(command[2]);
                    chamber = EruptionSpell(chamber, eruptionRow, eruptionCol);


                    heroPosition = PlayerMovement(chamber, heroPosition,eruptionRow,eruptionCol);
                    System.out.println(Arrays.toString(heroPosition));
                    heroHealthPoints += chamber[heroPosition[0]][heroPosition[1]];

                    System.out.println(heroHealthPoints);
                    chamber = EruptionSpellDeSpell(chamber, eruptionRow, eruptionCol);
                    break;


            }


            for (List<Integer> e : cloudSpellMemory) {
                e.set(0, e.get(0) - 1);
                if (e.get(0) == 0) {
                    int rows = e.get(1);
                    int cols = e.get(2);
                    for (int row = rows - 1; row <= rows + 1; row++) {
                        for (int col = cols - 1; col <= cols + 1; col++) {
                            if (row < 0 || row >= 15 || col < 0 || col >= 15) {
                                continue;
                            } else {
                                chamber[row][col] = 0;
                            }
                        }
                    }

                    e.set(0, -1);
                }

            }

        }




    }

    static double[][] EruptionSpell(double[][] chamber, int eruptionRow, int eruptionCol) {

        for (int row = eruptionRow - 1; row <= eruptionRow + 1; row++) {
            for (int col = eruptionCol - 1; col <= eruptionCol + 1; col++) {
                if (row < 0 || row >= 15 || col < 0 || col >= 15) {
                    continue;
                } else {
                    chamber[row][col] -= 6000;
                }
            }
        }


        return chamber;
    }

    static double[][] CloudSpell(double[][] chamber, int cloudRow, int cloudCol) {

        for (int row = cloudRow - 1; row <= cloudRow + 1; row++) {
            for (int col = cloudCol - 1; col <= cloudCol + 1; col++) {
                if (row < 0 || row >= 15 || col < 0 || col >= 15) {
                    continue;
                } else {
                    chamber[row][col] -= 3500;
                }
            }
        }


        return chamber;
    }

    static double[][] EruptionSpellDeSpell(double[][] chamber, int eruptionRow, int eruptionCol) {

        for (int row = eruptionRow - 1; row <= eruptionRow + 1; row++) {

            for (int col = eruptionCol - 1; col <= eruptionCol + 1; col++) {
                if (row < 0 || row >= 15 || col < 0 || col >= 15) {
                    continue;
                } else {

                    chamber[row][col] = 0;
                }
            }
        }


        return chamber;
    }

    static int[] PlayerMovement(double[][] chamber, int[] heroPosition, int attackRow, int attackCol) {
        int heroRow = heroPosition[0];
        int heroCol = heroPosition[1];

        if (chamber[heroRow][heroCol] < 0) {
            if (chamber[heroRow - 1][heroCol] == 0 && heroRow - 1 >= 0) {
                heroRow--;
            } else if (chamber[heroRow][heroCol + 1] == 0 && heroCol + 1 < 15) {
                heroCol++;
            } else if (chamber[heroRow + 1][heroCol] == 0 && heroRow + 1 < 15) {
                heroRow++;

            } else if (chamber[heroRow][heroCol - 1] == 0 && heroCol - 1 >= 0) {
                heroCol--;
            }
        }
        heroPosition[0] = heroRow;
        heroPosition[1] = heroCol;
        return heroPosition;
    }
}


/* for printing
for (double[] cell:chamber) {
                        System.out.println(Arrays.toString(cell));
                    }
                    System.out.println("****************");
 */