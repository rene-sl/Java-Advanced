import java.util.Arrays;
import java.util.Scanner;

public class Move {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int position = Integer.parseInt(scanner.nextLine());
        int [] array = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();

        long forward = 0;
        long backward = 0;


        while (!input.equals("exit")) {
            String[] commands = input.split(" ");
            String command = commands[1];
            int movements = Integer.parseInt(commands[0]);
            int stepSize = Integer.parseInt(commands[2]);


            switch (command){
                case "forward": {
                    for (int i = 0; i < movements  ; i++) {
                       position = (position + stepSize) % array.length;
                        forward+=array[position];
                    }
                    break;
                }
                case "backwards":{
                    for (int i = 0; i < movements ; i++) {
                        position = (position - stepSize);
                        while (position < 0){
                            position += array.length;
                        }
                        backward+=array[position];
                    }
                    break;
                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("Forward: %d%n" +
                "Backwards: %d", forward,backward);
    }
}
