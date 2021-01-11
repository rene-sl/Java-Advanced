

public class GameOfLife {
    public static void main(String[] args) {
        String input = "000111010";

        // Generation #0
        int generationNumber = 0;
        int[] generation0 = convertToArray(input);
        printGeneration(generation0, generationNumber);

        // Generation #1 Test
        generationNumber++;
        int[] generation1 = getNextGeneration(generation0);
        printGeneration(generation1, generationNumber);
        validateGeneration(generation1, generationNumber, "010111111");

        // Generation #2 Test
        generationNumber++;
        int[] generation2 = getNextGeneration(generation1);
        printGeneration(generation2, generationNumber);
        validateGeneration(generation2, generationNumber, "111000101");

        // Generation #3 Test
        generationNumber++;
        int[] generation3 = getNextGeneration(generation2);
        printGeneration(generation3, generationNumber);
        validateGeneration(generation3, generationNumber, "010101000");

        // Generation #4 Test
        generationNumber++;
        int[] generation4 = getNextGeneration(generation3);
        printGeneration(generation4, generationNumber);
        validateGeneration(generation4, generationNumber, "010010000");

        // Generation #5 Test
        generationNumber++;
        int[] generation5 = getNextGeneration(generation4);
        String generation5Str = convertToString(generation5);
        printGeneration(generation5Str, generationNumber);
        validateGeneration(generation5, generationNumber, "000000000");
    }

    /**
     * This method converts a String into an array of digits.<br />
     * For example "111000101" will become {1,1,1,0,0,0,1,0,1}
     *
     * @param str The input String
     * @return A one dimensional array of integers.
     */
    static int[] convertToArray(String str) {
        //  throw new UnsupportedOperationException("Converting String to integer array is not implemented!");
        int [] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            int current = Integer.parseInt(String.valueOf(str.charAt(i)));
            arr[i] = current;
        }
        return arr;
    }

    /**
     * This method converts a one dimensional array of integers into a String.<br/>
     * For example {1,1,1,0,0,0,1,0,1} will become "111000101"
     *
     * @param array A one-dimensional array of integers.
     * @return String
     */
    static String convertToString(int[] array) {
        //throw new UnsupportedOperationException("Converting integer array to String is not implemented!");
        StringBuilder result = new StringBuilder();
        for (int value : array) {
            result.append(value);
        }
        return result.toString();
    }

    /**
     * This method converts a two-dimensional array of integers into a one-dimensional array of integers.
     * For example:
     * 1 1 1
     * 0 0 0
     * 1 0 1
     * will become {1,1,1,0,0,0,1,0,1}
     *
     * @param matrix A two-dimensional array of integers.
     * @return A one-dimensional array of integers.
     */
    static int[] convertToArray(int[][] matrix) {
        //throw new UnsupportedOperationException("Converting two-dimensional to one-dimensional array of integers is not implemented.");
        int[] array = new int[matrix.length * matrix.length];
        for(int r = 0; r < matrix.length; r ++) {
            for(int c = 0; c < matrix.length; c ++){
                array[(r * matrix.length) + c] = matrix[r][c];
            }
        }
        return array;
    }

    /**
     * This method converts a one-dimensional array of integers into a two-dimensional array of integers.
     * For example {1,1,1,0,0,0,1,0,1} will become:
     * 1 1 1
     * 0 0 0
     * 1 0 1
     *
     * @param array A one-dimensional array of integers.
     * @return A two-dimensional array of integers.
     */
    static int[][] convertToMatrix(int[] array) {
       // throw new UnsupportedOperationException("Converting one-dimensional to two-dimensional array of integers is not implemented.");
        int size = (int) Math.sqrt(array.length);
        int[][] matrix = new int[size][size];

        for (int i = 0; i < array.length ; i++) {
            // 2 variant
           //int row = i/size;
          // int column = i % size;
         //  matrix[row][column] = array[i];

           int counter = 0;
            for (int r = 0; r < size; r++) {
                for (int c = 0; c < size ; c++) {
                    matrix[r][c] = array[counter++];
                }
            }
        }
        return matrix;
    }

    /**
     * This method prints String.
     * For example, "111000101" will be displayed in the Console as:
     * Generation #1
     * 1 1 1
     * 0 0 0
     * 1 0 1
     *
     * @param generation       The String representation of the generation of cells.
     * @param generationNumber The number of the generation.
     */
    static void printGeneration(String generation, int generationNumber) {
    //   throw new UnsupportedOperationException("Printing the String representation of a generation is not implemented.");



    }

    /**
     * This method prints the two-dimensional version of a one-dimensional array.
     * For example, {1,1,1,0,0,0,1,0,1} will be displayed in the Console as:
     * Generation #1
     * 1 1 1
     * 0 0 0
     * 1 0 1
     *
     * @param generation       An array representing the generation of cells to mutate.
     * @param generationNumber The number of the generation.
     */
    static void printGeneration(int[] generation, int generationNumber) {
       // throw new UnsupportedOperationException("Printing one-dimensional array representation of a generation is not implemented.");
        System.out.printf("Generation #%d%n", generationNumber);
        int [][] matrix = convertToMatrix(generation);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
        }
    }

    /**
     * This method takes a one-dimensional array representation of a generation and mutates (transforms) it into a one-dimensional array representation of the next generation.
     *
     * @param generation A one-dimensional array representing the generation of cells to mutate.
     * @return A one-dimensional array representing the generation of cells after mutation.
     */
    static int[] getNextGeneration(int[] generation) {
       // throw new UnsupportedOperationException("Mutating one-dimensional generation is not imlpemented.");
    int [][] matrix = convertToMatrix(generation);
    int [][] nextGeneration = getNextGeneration(matrix);
    return convertToArray(nextGeneration);

    }

    /**
     * This method takes a two-dimensional array representation of a generation and mutates (transforms) it into a two-dimensional array representation of the next generation.
     *
     * @param generation A two-dimensional array representing the generation of cells to mutate.
     * @return A two-dimensional array representing the generation of cells after mutation.
     */
    static int[][] getNextGeneration(int[][] generation) {
       throw new UnsupportedOperationException("Mutating two-dimensional generation is not imlpemented.");


    }

    /**
     * This method applies the rules of "Game of Life" and returns whether the cell at position [row,column] will be alive in the next generation.
     * Rules of "Game of Life":
     * 1. Any live cell with 0 or 1 live neighbors becomes dead, because of underpopulation.
     * 2. Any live cell with 2 or 3 live neighbors stays alive, because its neighborhood is just right.
     * 3. Any live cell with more than 3 live neighbors becomes dead, because of overpopulation.
     * 4. Any dead cell with exactly 3 live neighbors becomes alive, by reproduction.
     *
     * @param row        The row position of the cell on which the rules are being applied on.
     * @param column     The column position of the cell on which the rules are being applied on.
     * @param generation The two-dimensional array representing the entire generation of cells.
     * @return 0 if the cell will be dead in the next generation; <br/> 1 if the cell will be alive in the next generation;
     */
    static int applyGameRules(int row, int column, int[][] generation) {
        // throw new UnsupportedOperationException("Applying the rules of 'Game of Life' on a cell is not implemented.");
 int a=0;
        int aliveNeibource =
                getAliveNeighboursCount(row, column, generation);
        if (aliveNeibource == 2) {
            return generation[row][column];
        } else if (aliveNeibource == 3) {
            return 1;
        }
    return a;
    }

    /**
     * Given the position of a cell within the generation this method returns the number of alive neighbours.
     *
     * @param row        The row position of the cell on which the rules are being applied on.
     * @param column     The column position of the cell on which the rules are being applied on.
     * @param generation The two-dimensional array representing the entire generation of cells.
     * @return The number of alive neighbours.
     */
    static int getAliveNeighboursCount(int row, int column, int[][] generation) {
       // throw new UnsupportedOperationException("Calculating the number of alive neighbouring cells is not implemented.");
    int aliveNeibource = 0;
    int columns = generation.length;
    int rows = generation.length;

        for (int i = Math.max(row - 1, 0); i <= Math.min(row + 1, rows) ; i++) {
            for (int j =Math.max(column - 1, 0); j <= Math.min(column + 1, columns) ; j++) {
                if((i!= row || j != column) && generation[i][j]== 1 ){
                   aliveNeibource+=generation[i][j];
            }
        }
      //  for (int roundRow = row - 1; roundRow <= row + 1; roundRow++) {
        //    for (int roundCol = column - 1; roundCol <= column + 1; roundCol++) {
          //      if (roundRow == row && roundCol == column) {
           //         continue;
           //     }
                // if (isInMatrixBorders(check if the cell is in the matrix borders? )) {
              //  if (generation[roundRow][roundCol] == 1) {
                 //   sum++;
        }
        return aliveNeibource;
    }

    static void validateGeneration(int[] generation, int generationNumber, String expectedGeneration) {
        String generationStr = convertToString(generation);
        String testResult = "PASS";
        if (!generationStr.equals(expectedGeneration)) {
            testResult = "FAIL";
        }
        System.out.printf("Generation #%d Test: %s%n", generationNumber, testResult);
    }
}
