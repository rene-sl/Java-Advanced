
import java.util.Scanner;

public class SpiralMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];
        int counter = 0;

        int startRow = 0;
        int endRow = size - 1;
        int startCol = 0;
        int endCol = size - 1;

        while (counter < size*size) {
            counter = rightMovement(matrix, counter, startRow,startCol,endCol);
            startRow++;
            counter = downMovement(matrix, counter, endCol, startRow , endRow);
            endCol--;
            counter = leftMovement(matrix, counter, endRow, startCol,endCol);
            endRow--;
            counter = upMovement(matrix, counter, startCol, startRow, endRow);
            startCol++;
        }
        printMatrix(matrix);
    }

    private static int rightMovement(int[][] matrix, int number, int row, int startCol, int endCol) {
        for (int col = startCol; col <= endCol; col++) {
            matrix[row][col] = ++number;
        }
        return number;
    }

    private static int downMovement(int[][] matrix, int number, int col, int rowStart, int rowEnd) {
        for (int row = rowStart; row <= rowEnd; row++) {
            matrix[row][col] = ++number;
        }
        return number;
    }

    private static int leftMovement(int[][] matrix, int number, int row, int startCol, int endCol){
        for (int col = endCol; col >= startCol; col--) {
          matrix[row][col] = ++number;
        }
        return number;
    }

    private static int upMovement(int[][] matrix, int number, int col, int rowStart, int rowEnd) {
        for (int row = rowEnd; row >= rowStart; row--) {
            matrix[row][col] = ++number;
        }
        return number;
    }
    private static void printMatrix(int[][] matrix){
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%d ", anInt);
            }
            System.out.println();
        }

    }
}
