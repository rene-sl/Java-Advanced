import java.util.Scanner;

public class KnightMoves {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeMatrix = Integer.parseInt(scanner.nextLine());
        int[][] grid = new int[sizeMatrix][sizeMatrix];
        int [] startCoordinates = searchingNewStartPosition(grid);
        int counter = 1;
        grid[0][0]= counter;
        boolean startingAgain = false;


        int currentRow = startCoordinates[0];
        int currentCol = startCoordinates[1];
        int nextRow = 0;
        int nextCol = 0;


        while (counter < sizeMatrix*sizeMatrix) {
            if(startingAgain){
                startCoordinates = searchingNewStartPosition(grid);
                counter = putStartPositionWhenStart(grid, counter,startCoordinates);
                startingAgain = false;
                currentRow = startCoordinates[0];
                currentCol = startCoordinates[1];
            }

            int[] arrayRows = new int[]{-2, -2, -1, -1, 1, 1, 2, 2};
            int[] arrayCols = new int[]{-1, 1, -2, 2, -2, 2, -1, 1};
            for (int i = 0; i < 8; i++) {
                nextRow = currentRow + arrayRows[i];
                nextCol = currentCol + arrayCols[i];
                if (isInTheGrid(sizeMatrix, nextRow, nextCol)) {
                    if (isTheCellEmpty(grid, nextRow, nextCol)) {
                        grid[nextRow][nextCol] = ++counter;
                        currentRow = nextRow;
                        currentCol = nextCol;
                        break;
                    }
                }
                if(i == 7){
                    startingAgain = true;
                }
            }
        }
        pringMatrix(grid);
    }

    private static boolean isInTheGrid(int size, int currentRow, int currentCol){
        return (0 <= currentRow && currentRow < size) && (0 <= currentCol && currentCol < size);
    }
    private static boolean isTheCellEmpty (int[][] matrix, int currentRow, int currentCol){
        return matrix[currentRow][currentCol] == 0;
    }
    private static int[] searchingNewStartPosition(int[][] matrix){
        int[] coordinates = new int[2];
        for (int row = 0; row < matrix.length ; row++) {
            for (int col = 0; col < matrix.length ; col++) {
              int currentCell = matrix[col][row];
                if(currentCell == 0 ){
                  coordinates[0] = col;
                  coordinates[1] = row;
                 return coordinates;
                }
            }
        }
        return coordinates;
    }
    private static int putStartPositionWhenStart(int[][] grid, int counter, int[]coordinates){
        grid[coordinates[0]][coordinates[1]] = ++counter;
        return counter;
    }
    private static void pringMatrix(int[][]matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                int currentCell = matrix[row][col];
                System.out.print(currentCell + " ");
            }
            System.out.println();
        }
    }
}
