

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Bounce {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String[] sizes = scanner.readLine().split(" ");
        int rows = Integer.parseInt(sizes[0]);
        int cols = Integer.parseInt(sizes[1]);
        long[][] grid = createMatrix(rows, cols);
        long sum = 1;
        boolean changeDirectionRow = false;
        boolean changeDirectionCol = false;
        int nextRow = 1;
        int nextCol = 1;
        boolean exit = false;

        while (true) {
            if(isPositionInTheMatrix(rows, cols, nextRow, nextCol)) {
                long nextPosition = grid[nextRow][nextCol];
                sum += nextPosition;
                if(isThisExit(rows,cols,nextRow,nextCol)){
                    break;
                }
            }
            if (down(rows - 1,nextRow)){
                changeDirectionRow = true;
                nextRow--;
            } else if(up(0,nextRow)){
                changeDirectionRow = false;
                nextRow++;
            } else {
               if(changeDirectionRow){
                   nextRow--;
               } else {
                   nextRow++;
               }
            }

            if (down(cols - 1,nextCol)){
                changeDirectionCol = true;
                nextCol--;
            } else if (up(0, cols)){
                changeDirectionCol = false;
                nextCol++;
            } else {
                if(changeDirectionCol){
                    nextCol--;
                }else {
                    nextCol++;
                }
            }
        }
        System.out.println(sum);

    }

    private static long[][] createMatrix(int rows, int cols) {
        long[][] matrix = new long[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = (long) Math.pow(2, row + col);
            }
        }
        return matrix;
    }

    private static boolean up(int top, int current) {
      return 0 == current;
   }

    private static boolean down (int bottom, int current){ return current == bottom; }

    private static boolean isThisExit(int matrixRow, int matrixCol, int nextRow, int nextCol) {
        return    (nextRow == 0 && nextCol == 0)
                || (nextRow == matrixRow - 1 && nextCol == matrixCol - 1)
                || (nextRow == 0 && nextCol == matrixCol - 1)
                || (nextRow == matrixRow - 1 && nextCol == 0);
    }
    private static boolean isPositionInTheMatrix( int matrixRow, int matrixCol,
                                                  int row, int col){
        return (0 <= row && row <= matrixRow) && (0 <= col && col <= matrixCol);
    }
}
