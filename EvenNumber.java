import java.util.Arrays;
import java.util.Scanner;

public class EvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = (scanner.nextLine());

        System.out.println(maxEvenNumber(text));

    }


    public static int maxEvenNumber(String text) {
        int maxEvenDigit = -1;
        int currentEvenDigit = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (Character.isDigit(currentChar)) {
                result.append(currentChar);

            } else {
                if (result.length() == 0) {
                    continue;
                } else {
                    currentEvenDigit = Integer.parseInt(String.valueOf(result));
                    if (currentEvenDigit % 2 == 0) {
                        if (maxEvenDigit < currentEvenDigit) {
                            maxEvenDigit = currentEvenDigit;
                            currentEvenDigit = 0;
                            result.setLength(0);
                        }
                    } else {
                        result.setLength(0);
                        currentEvenDigit = 0;
                    }
                }
            }
        }
        return maxEvenDigit;
    }

}
