

import java.util.Arrays;
import java.util.Scanner;

public class BigNumber2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sizes = createArrayFromConsole(scanner);
        int[] firstArray = createArrayFromConsole(scanner);
        int[] secondArray = createArrayFromConsole(scanner);

        int rotations = Math.max(firstArray.length, secondArray.length);
        int keeper = 0;
        int currentNumberArr1 = 0;
        int currentNumberArr2 = 0;

        for (int i = 0; i < rotations ; i++) {
            if(firstArray.length > i){
                currentNumberArr1 = firstArray[i];
            } else {
                currentNumberArr1 = 0;
            }
            if(secondArray.length > i){
                currentNumberArr2 = secondArray[i];
            } else {
                currentNumberArr2 = 0;
            }

            int digit = (currentNumberArr1 + currentNumberArr2 + keeper) % 10 ;
            System.out.printf("%d ", digit);
            keeper = (currentNumberArr1 + currentNumberArr2) /10;

        }
    }

    public static int[] createArrayFromConsole(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}

