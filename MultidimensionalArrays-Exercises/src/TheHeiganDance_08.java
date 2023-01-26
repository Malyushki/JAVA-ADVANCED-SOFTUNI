import java.util.Arrays;
import java.util.Scanner;

public class TheHeiganDance_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double heiganHP = 3000000;
        int playerHP = 18500;
        double playerAP = Double.parseDouble(scanner.nextLine());
        int[][] chamber = new int[15][15];
        int[] playerCoordinates = {7,7};
        String command = scanner.nextLine();
        String lastSpell = "";
        int lastSpellRow = -1;
        int lastSpellCol = -1;
        while (true){
            heiganHP -= playerAP;
            String[]   commandParts =   command.split("\\s+");

            if (lastSpell.equals("Cloud")&&inDangerArea(playerCoordinates,lastSpellRow,lastSpellCol)){
                playerHP -=3500;
            }

            String spellName = commandParts[0];
            int spellRow = Integer.parseInt(commandParts[1]);
            int spellCol = Integer.parseInt(commandParts[2]);
             lastSpellRow = spellRow;
             lastSpellCol = spellCol;
            if (checkIfDead(heiganHP,  playerHP,  lastSpell, playerCoordinates)){
                return;
            }

            switch (spellName){
                case "Cloud":
<<<<<<< .mine
                    if (inDangerArea(playerCoordinates,spellRow,spellCol)){
=======
                    int cloudRow = Integer.parseInt(command[1]);
>>>>>>> .theirs
                    int cloudCol = Integer.parseInt(command[2]);
<<<<<<< .mine
                        if (inDangerArea(playerCoordinates,spellRow,spellCol)){
                            playerHP -=3500;
                        }

                    }
=======
                    chamber = CloudSpell(chamber, cloudRow, cloudCol);
                 //   heroPosition = PlayerMovement(chamber, heroPosition);
                    System.out.println(Arrays.toString(heroPosition));
                    cloudSpellMemory.add(new ArrayList<>(Arrays.asList(3, cloudRow, cloudCol)));
                    heroHealthPoints += chamber[heroPosition[0]][heroPosition[1]];
>>>>>>> .theirs
                    break;
                case "Eruption":
                    if (inDangerArea(playerCoordinates,spellRow,spellCol)){
                            heroMovement(playerCoordinates,spellRow,spellCol);
                            if (inDangerArea(playerCoordinates,spellRow,spellCol)){
                                playerHP -=6000;
                            }

                    }

                    break;
            }


           if (checkIfDead(heiganHP,  playerHP,  lastSpell, playerCoordinates)){
               return;
           }
            lastSpell = spellName;


            command = scanner.nextLine();

        }


    }
    private static boolean inDangerArea(int[] playerCoordinates , int spellRow, int spellCol){
       int playerRow = playerCoordinates[0];
       int playerCol = playerCoordinates[1];
        for (int row = spellRow-1; row <=spellRow+1 ; row++) {
            for (int col = spellCol-1; col <=spellCol+1 ; col++) {
            if (playerRow == row && playerCol == col){
                return true;
            }
            }
        }


        return false;
    }
    private static void heroMovement( int[] heroCoordinates,int damagedRow, int damagedCol ) {
        int heroRow = heroCoordinates[0];
        int heroCol = heroCoordinates[1];


            if (heroRow - 1 > damagedRow + 1 || heroRow - 1 < damagedRow - 1) {
                heroCoordinates[0] = heroRow - 1;
            }
            if (heroCol + 1 > damagedCol + 1 || heroCol + 1 < damagedCol - 1) {
                heroCoordinates[1] = heroCol + 1;

            }
            if (heroRow+1>damagedRow+1 || heroRow+1<damagedRow-1) {
                heroCoordinates[0] = heroRow + 1;
            }
            if (heroCol-1>damagedCol+1 || heroCol-1<damagedCol-1) {
                heroCoordinates[1] = heroCol - 1;

            }


    }
    private static boolean checkIfDead(double heiganHP, int playerHP, String lastSpell, int[]playerCoordinates){
        if (heiganHP<=0 || playerHP<=0){
            lastSpell = lastSpell.contains("Cloud")?"Plague Cloud":"Eruption";
            System.out.printf(heiganHP<=0 ? "Heigan: Defeated!%n" : "Heigan: %.2f%n",heiganHP);
            if (playerHP<=0){
                System.out.printf("Player: Killed by %s%n",lastSpell);
            }else {
                System.out.printf("Player: %d%n",playerHP);
            }
            System.out.printf("Final position: %d, %d%n",playerCoordinates[0],playerCoordinates[1]);
            return true;
        }
        return false;
    }
}