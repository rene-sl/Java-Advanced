

import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;
        import java.util.Scanner;

public class ThreeGroups {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        List<Integer> groupOne = new ArrayList<>();
        List<Integer> groupTwo = new ArrayList<>();
        List<Integer> groupThree = new ArrayList<>();

        for (int number : numbers) {
            if (number % 3 == 0) {
                groupOne.add(number);
            } else if (number % 3 == 1) {
                groupTwo.add(number);
            } else if (number % 3 == 2) {
                groupThree.add(number);
            }
        }
        if (groupOne.size() > 0) {
            printingGroup(groupOne);
        } else {
            System.out.println("");
        }

        if (groupTwo.size() > 0) {
            printingGroup(groupTwo);
        } else {
            System.out.println("");
        }

        if (groupThree.size() > 0) {
            printingGroup(groupThree);
        } else {
            System.out.println("");
        }
    }

    private static void printingGroup(List<Integer> list) {

        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.print(list.get(i));
            } else {
                System.out.print(list.get(i) + " ");
            }
        }
        System.out.println();
    }
}
