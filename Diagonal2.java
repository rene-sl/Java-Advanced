

import java.util.Scanner;

public class Diagonal2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        long[][] matrix = new long[rows][rows];


        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                matrix[row][col] = (long) Math.pow(2, row + col);
            }
        }

        System.out.println(aggregation(matrix));


    }

    private static long aggregation(long[][] matrix) {
        long sum = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                long current = matrix[i][j];
                sum += current;
            }
        }
        return sum;
    }
}


