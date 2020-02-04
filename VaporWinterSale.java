import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class VaporWinterSale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split("\\,\\s+");

        LinkedHashMap<String, Double> gamesWithPrice = new LinkedHashMap<>();
        LinkedHashMap<String, String> gamesWithDLC = new LinkedHashMap<>();


        for (int i = 0; i < input.length ; i++) {
            String [] currentInput = input[i].split("-|:");
            String nameOfTheGame = currentInput[0];
            String token = currentInput[1];
            double price =0;
            String DLC = "";

            if (Character.isDigit(token.charAt(0))){
                price = Double.parseDouble(token);
            }
            if (Character.isLetter(token.charAt(0))){
              DLC = token;
            }

            if (price!=0){
                if (!gamesWithPrice.containsKey(nameOfTheGame)){
                    gamesWithPrice.put(nameOfTheGame, price);
                }
            } else {
                if (gamesWithPrice.containsKey(nameOfTheGame)){
                    gamesWithDLC.put(nameOfTheGame,DLC);
                }
            }
        }

        for (Map.Entry<String, Double> entry : gamesWithPrice.entrySet()) {
            if (gamesWithDLC.containsKey(entry.getKey())){
                double currentPrice = gamesWithPrice.get(entry.getValue());
                double newPrice = currentPrice-(currentPrice*0.2);
                gamesWithPrice.put(entry.getKey(),newPrice);
                System.out.println();
            }
        }

    }
}
