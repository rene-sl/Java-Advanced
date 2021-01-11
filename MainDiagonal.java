

import java.util.Scanner;

public class MainDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        long [][] matrix = new long[rows][rows];


        for (int row = 0; row < rows ; row++) {
            for (int col = 0; col < rows; col++) {
                matrix[row][col] = (long) Math.pow(2, row + col);
            }
        }

        System.out.println(aggregation(matrix));


    }

    private static long aggregation (long[][] matrix){
        long sum = 0;
        for (int r = 0; r < matrix.length ; r++) {
            for (int c = r + 1; c < matrix.length ; c++) {
                sum+= matrix[r][c];
            }
        }
        return sum;
    }
}

