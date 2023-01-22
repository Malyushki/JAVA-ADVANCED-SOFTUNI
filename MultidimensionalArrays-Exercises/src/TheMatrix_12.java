import java.util.*;

public class TheMatrix_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        String[][] matrix = new String[rows][cols];
        fillMatrix(matrix, scanner);

        String filChar = scanner.nextLine();
        String[] startValues = scanner.nextLine().split("\\s+");
        int startRow = Integer.parseInt(startValues[0]);
        int startCol = Integer.parseInt(startValues[1]);
        String charToCheck = matrix[startRow][startCol];
        ArrayDeque<Integer> saveColsIndexes = new ArrayDeque<>();
        ArrayDeque<Integer> saveColsIndexes2 = new ArrayDeque<>();
        ArrayDeque<Integer> saveColsIndexes3 = new ArrayDeque<>();
        List<int[]> coordinates = new ArrayList<>();
        saveColsIndexes.offer(startCol);
        for (int col = startCol; col < matrix[0].length; col++) {
            if (col - 1 > 0 && matrix[startRow][col].equals(matrix[startRow][col - 1])) {
                saveColsIndexes.offer(col - 1);
            }
            if (col + 1 < matrix[0].length && matrix[startRow][col].equals(matrix[startRow][col + 1])) {
                saveColsIndexes.offer(col + 1);
            }
        }
        saveColsIndexes3 =   saveColsIndexes.clone();

            for (int row = startRow; row < matrix.length; row++) {
                while (!saveColsIndexes.isEmpty()) {
                    int index = saveColsIndexes.poll();
                    if (matrix[row][index].equals(charToCheck)) {
                        coordinates.add(new int[]{row, index});
                        saveColsIndexes2.offer(index);
                    }
                }
                while (!saveColsIndexes2.isEmpty()) {
                    saveColsIndexes.offer(saveColsIndexes2.poll());
                }
            }
        saveColsIndexes = saveColsIndexes3.clone();
        for (int row = startRow; row >= 0; row--) {
            while (!saveColsIndexes.isEmpty()) {
                int index = saveColsIndexes.poll();
                if (matrix[row][index].equals(charToCheck)) {
                    coordinates.add(new int[]{row, index});
                    saveColsIndexes2.offer(index);
                }
            }
            while (!saveColsIndexes2.isEmpty()) {
                saveColsIndexes.offer(saveColsIndexes2.poll());
            }
        }

            for (int[] e : coordinates) {
                matrix[e[0]][e[1]] = filChar;
            }
            printMatrix(matrix);
        }

        private static void printMatrix (String[][]matrix){
            for (String[] element : matrix) {
                System.out.println(Arrays.toString(element).replaceAll("[\\[\\], ]", ""));
            }
        }

        private static void fillMatrix (String[][]matrix, Scanner scanner){
            for (int row = 0; row < matrix.length; row++) {
                matrix[row] = scanner.nextLine().split("\\s+");
            }
        }


    }
