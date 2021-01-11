

import java.util.Scanner;

public class BigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] sizes = scanner.nextLine().split(" ");
        String[] firstArray = scanner.nextLine().split(" ");
        String[] secondArray = scanner.nextLine().split(" ");
        int rotations = Math.max(firstArray.length, secondArray.length);

        String result = "";
        int keeper = 0;
        for (int i = 0; i < rotations; i++) {
            int currentNumberArr1 = 0;
            int currentNumberArr2 = 0;
            if (firstArray.length > i) {
                currentNumberArr1 = Integer.parseInt(firstArray[i]);
            }
            if (secondArray.length > i) {
                currentNumberArr2 = Integer.parseInt(secondArray[i]);
            }

            int digit = (currentNumberArr1 + currentNumberArr2 + keeper) % 10;
            result+=String.valueOf(digit);
            result+= " ";
            keeper = (currentNumberArr1 + currentNumberArr2) / 10;
        }

        for (int i = result.length() - 1; i >= 0 ; i--) {
            System.out.print(result.charAt(i));
        }
    }

}
