import java.util.*;

public class RadioactiveMutantVampireBunnies_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        char[][] lair = new char[rows][cols];
        fillMatrix(lair, scanner);
        int[] playerCoordinates = findPlayer(lair);
        lair[playerCoordinates[0]][playerCoordinates[1]] = '.';

        char[] commands = scanner.nextLine().toCharArray();

        for (int i = 0; i < commands.length; i++) {

            playerMovement(commands[i], playerCoordinates);

            List<int[]> bunnyCoordinates = new ArrayList<>();
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (lair[row][col] == 'B') {
                        bunnyCoordinates.add(new int[]{row, col});
                    }
                }
            }
            for (int[] e : bunnyCoordinates) {
                spreadBunnies(e[0], e[1], lair);
            }
            if (checkCollision(playerCoordinates, lair)) {

                printMatrix(lair);
                System.out.printf("dead: %d %d", playerCoordinates[0], playerCoordinates[1]);
                return;
            }


        }
        printMatrix(lair);
        forLastPlace(lair, playerCoordinates);
        System.out.printf("won: %d %d", playerCoordinates[0],playerCoordinates[1]);


    }

    private static boolean checkCollision(int[] playerCoordinates, char[][] matrix) {
        int row = playerCoordinates[0];
        int col = playerCoordinates[1];
        if (checkBorders(matrix, row, col)) {
            if (matrix[row][col] == 'B') {
                return true;
            }
        }
        return false;
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean checkBorders(char[][] matrix, int row, int col) {
        int rowsMatrix = matrix.length;
        int colsMatrix = matrix[0].length;
        if (0 <= row && row < rowsMatrix && 0 <= col && col < colsMatrix) {
            return true;
        }
        return false;
    }

    private static void spreadBunnies(int currentRow, int currentCol, char[][] matrix) {

        if (checkBorders(matrix, currentRow - 1, currentCol)) {
            matrix[currentRow - 1][currentCol] = 'B';
        }
        if (checkBorders(matrix, currentRow + 1, currentCol)) {
            matrix[currentRow + 1][currentCol] = 'B';
        }
        if (checkBorders(matrix, currentRow, currentCol - 1)) {
            matrix[currentRow][currentCol - 1] = 'B';
        }
        if (checkBorders(matrix, currentRow, currentCol + 1)) {
            matrix[currentRow][currentCol + 1] = 'B';
        }


    }

    private static int[] findPlayer(char[][] matrix) {
        int[] playerCoordinates = new int[2];
        playerCoordinates[0] = -30;
        playerCoordinates[1] = -30;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'P') {
                    playerCoordinates[0] = row;
                    playerCoordinates[1] = col;
                }
            }
        }
        return playerCoordinates;
    }

    private static void playerMovement(char direction, int[] playerCoordinates) {
        switch (direction) {
            case 'U':
                playerCoordinates[0]--;
                break;
            case 'D':
                playerCoordinates[0]++;
                break;
            case 'L':
                playerCoordinates[1]--;
                break;
            case 'R':
                playerCoordinates[1]++;
                break;
        }
    }

    private static void forLastPlace(char[][] matrix, int[] playersLastPlace) {


        int rowsMatrix = matrix.length;
        int colsMatrix = matrix[0].length;
        if (playersLastPlace[0] < 0) {
            playersLastPlace[0]++;
        }
        if (playersLastPlace[1] < 0) {
            playersLastPlace[1]++;
        }
        if (playersLastPlace[0] >= rowsMatrix) {
            playersLastPlace[0]--;
        }
        if (playersLastPlace[1] >= colsMatrix) {
            playersLastPlace[1]--;
        }

    }
}
