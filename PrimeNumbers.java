import java.io.BufferedReader;
import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);


        int num = scanner.nextInt();


        for (int i = 1; i <= num; i++) {
            if ( isPrime(i)) {
                System.out.print(i + " ");
            }
        }

    }

    public static boolean isPrime(int i) {
        boolean isPrime = true;
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}