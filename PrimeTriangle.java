import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List< Integer> primeNumbers = new ArrayList<>();


            for (int currentNumber = 1; currentNumber <= num; currentNumber++) {
                if ( isPrime(currentNumber)) {
                    primeNumbers.add(currentNumber);
                }
            }
        System.out.println();

        for (Integer primeNumber : primeNumbers) {
            printingTriangle(primeNumber, primeNumbers);
            System.out.println();
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

    public static void printingTriangle(int number, List<Integer> list){
        for (int i = 1; i <= number ; i++) {
         if(list.contains(i)){
             System.out.print(1);
         } else {
             System.out.print(0);
         }
        }
    }
}
