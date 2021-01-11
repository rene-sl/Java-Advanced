import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestIncreasingSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rotationsCount = Integer.parseInt(scanner.nextLine());
        List<Integer> collection = createArrayList(rotationsCount, scanner);


        int max = sequenceCount(collection);
        System.out.println(max);

    }

    public static List<Integer> createArrayList(int rotations, Scanner scanner) {
        List<Integer> collection = new ArrayList<>();

        for (int i = 0; i < rotations; i++) {
            int current = Integer.parseInt(scanner.nextLine());
            collection.add(current);
        }
        return collection;
    }

    public static int sequenceCount(List<Integer> collection) {
        int max = 0;
        int counter = 0;
        for (int i = 1; i < collection.size(); i++) {
            int second= collection.get(i);
            int first = collection.get(i - 1);

            if (first < second) {
                counter++;
                if (max < counter) {
                    max = counter;
                }
            } else {
                counter = 1;
            }
    }
        return max;
}

}
