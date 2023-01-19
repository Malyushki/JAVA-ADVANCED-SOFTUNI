import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/// 20 / 100 -- НЕ РАЗБИРАМ ЗАЩО?
public class E_TheHeiganDance_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] chamber = new int[15][15];
        int[] heroCoordinates = {7, 7};
        int heroHP = 18500;
        double heroDP = Double.parseDouble(scanner.nextLine());
        double bossHP = 3000000;
        String bossAttack = scanner.nextLine();

        List<int[]> cloudSpellMemory = new ArrayList<>();
        while (heroHP > 0) {
            bossHP -= heroDP;

            String currentSpell = bossAttack.split("\\s+")[0];
            String lastSpell = currentSpell.contains("Cloud")? "Plague Cloud" : "Eruption";
            int spellRow = Integer.parseInt(bossAttack.split("\\s+")[1]);
            int spellCol = Integer.parseInt(bossAttack.split("\\s+")[2]);

            if (checkBossHP(bossHP, heroHP, lastSpell, heroCoordinates)) {
                return;
            }
            switch (currentSpell) {
                case "Eruption":
                    eruptionSpell(chamber, spellRow, spellCol);
                    heroMovement( heroCoordinates,spellRow, spellCol);
                    heroHP += chamber[heroCoordinates[0]][heroCoordinates[1]];
                    if(checkHeroHP(heroHP,bossHP,lastSpell,heroCoordinates)){
                        return;
                    }
                    eruptionDeSpell(chamber, spellRow, spellCol);

                    break;
                case "Cloud":
                    cloudSpell(chamber, spellRow, spellCol);
                    cloudSpellMemory.add(new int[] {2,spellRow,spellCol});
                    heroMovement(heroCoordinates,spellRow, spellCol);
                    heroHP += chamber[heroCoordinates[0]][heroCoordinates[1]];
                    if(checkHeroHP(heroHP,bossHP,lastSpell,heroCoordinates)){
                        return;
                }
                    break;

            }

            removeTimedOutCloudSpells(cloudSpellMemory,chamber);
            bossAttack = scanner.nextLine();


        }

    }

    private static void printMatrix(int[][] matrix) {
        for (int[] element : matrix) {
            System.out.println(Arrays.toString(element).replaceAll("[\\[\\],]", ""));
        }
    }

    private static boolean checkBossHP(double bossHP, int heroHP, String spellName, int[] heroCoordinates) {
        if (bossHP <= 0) {
            System.out.println("Heigan: Defeated!");
            if (heroHP <= 0) {
                System.out.printf("Player: Killed by %s%n", spellName);
            } else {
                System.out.printf("Player: %d%n", heroHP);
            }
            System.out.printf("Final position: %d, %d%n", heroCoordinates[0], heroCoordinates[1]);
            return true;
        } else {
            return false;
        }

    }

    private static void heroMovement( int[] heroCoordinates,int damagedRow, int damagedCol ) {
        int heroRow = heroCoordinates[0];
        int heroCol = heroCoordinates[1];

            if (checkHeroCoordinates(heroRow - 1, heroCol)) {
                if (heroRow - 1 > damagedRow + 1 || heroRow - 1 < damagedRow - 1) {
                    heroCoordinates[0] = heroRow - 1;
                    return;
                }
            }
              if (checkHeroCoordinates(heroRow, heroCol + 1)) {
                  if (heroCol + 1 > damagedCol + 1 || heroCol + 1 < damagedCol - 1) {
                      heroCoordinates[1] = heroCol + 1;
                      return;
                  }
              }
             if (checkHeroCoordinates(heroRow + 1, heroCol)) {
                if (heroRow+1>damagedRow+1 || heroRow+1<damagedRow-1) {
                    heroCoordinates[0] = heroRow + 1;
                    return;
                }
            }
             if (checkHeroCoordinates(heroRow, heroCol - 1)) {
                if (heroCol-1>damagedCol+1 || heroCol-1<damagedCol-1) {
                    heroCoordinates[1] = heroCol - 1;
                    return;
                }

        }
    }

    private static boolean checkHeroCoordinates(int row, int col) {
        if (row < 0 || col < 0) {
            return false;
        }
        if (row > 14 || col > 14) {
            return false;
        }



        return true;
    }


    private static void eruptionSpell(int[][] matrix, int spellRow, int spellCol) {
        int startRow = spellRow - 1;
        int startCol = spellCol - 1;
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                if (checkSpellCoordinates(row, col)) {
                    matrix[row][col]  -=6000;
                }
            }
        }


    }

    private static boolean checkSpellCoordinates(int row, int col) {
        if (row < 0 || col < 0) {
            return false;
        }
        if (row > 14 || col > 14) {
            return false;
        }

        return true;
    }

    private static void eruptionDeSpell(int[][] matrix, int spellRow, int spellCol) {
        int startRow = spellRow - 1;
        int startCol = spellCol - 1;
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                if (checkSpellCoordinates(row, col)) {
                    matrix[row][col] +=6000 ;
                }
            }
        }
    }
    private static void cloudSpell(int[][] matrix, int spellRow, int spellCol) {
        int startRow = spellRow - 1;
        int startCol = spellCol - 1;
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                if (checkSpellCoordinates(row, col)) {
                    matrix[row][col]  -=3500;
                }
            }
        }
    }
    private static void removeTimedOutCloudSpells(List<int[]> cloudMemory, int[][] matrix ){
        for (int[] e:cloudMemory) {
            e[0] -=1;
            if (e[0]==0){
                int spellStartRow = e[1]-1;
                int spellStartCol = e[2]-1;
                for (int row = spellStartRow; row <spellStartRow+3 ; row++) {
                    for (int col = spellStartCol; col <spellStartCol+3 ; col++) {
                        matrix[row][col] += 3500;
                    }
                }

            }
        }


    }
    private static boolean checkHeroHP(int heroHP,double bossHP, String spellName, int[] heroCoordinates) {

        if (heroHP<=0) {
            System.out.printf("Heigan: %.2f%n", bossHP);
            System.out.printf("Player: Killed by %s%n", spellName);
            System.out.printf("Final position: %d, %d%n", heroCoordinates[0], heroCoordinates[1]);
        return true;
        }
    return false;
    }

}


