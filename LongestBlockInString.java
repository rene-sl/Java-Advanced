import java.util.Scanner;

public class LongestBlockInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        char[] array = createArrayFromText(word);

        int result = 0;
        int counter = 1;
        char resultChar = '0';

        for (int i = 1; i < array.length; i++) {
            char currentChar = array[i];
            char previousChar = array[i - 1];
            if (currentChar == previousChar) {
                counter++;
                if (result < counter) {
                    result = counter;
                    resultChar = currentChar;
                }
            } else {
                counter = 1;
            }
        }
        printResult(resultChar, result);
    }

    public static char[] createArrayFromText(String string) {
        char[] arr = new char[string.length()];
        for (int i = 0; i < string.length(); i++) {
            char current = string.charAt(i);
            arr[i] = current;
        }
        return arr;
    }

    public static void printResult(char ch, int rotation) {
        for (int i = 0; i < rotation; i++) {
            System.out.print(ch);
        }
    }
}
