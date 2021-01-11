

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestSequenceOfEqual {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterations = Integer.parseInt(scanner.nextLine());
        List<Integer> list = new ArrayList<>();
        int counter = 0;

        for (int i = 0; i < iterations; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            list.add(currentNumber);
        }

        List<Integer> result = new ArrayList<>();
        List<Integer> resultTwo = new ArrayList<>();

        for (int i = 0; i < list.size() - 1; i++) {
            int currentNum = list.get(i);
            int nextNum = list.get(i + 1);
            if (currentNum == nextNum) {
                if(result.size() == 0){
                    result.add(currentNum);
                } else {
                    int currentResult = result.get(0);
                    if (currentNum == currentResult) {
                        result.add(currentNum);
                    } else {
                        if(result.size()==1){
                            result.set(0, currentNum);
                        } else if (resultTwo.size() == 0) {
                            resultTwo.add(currentNum);
                        } else {
                            int currentResultTwo = resultTwo.get(0);
                            if (currentNum == currentResultTwo) {
                                resultTwo.add(currentNum);
                            } else {
                                if(resultTwo.size()==1){
                                    resultTwo.set(0, currentNum);
                                }
                            }
                        }
                    }
                }
            }
            if (result.size() < resultTwo.size()){
                result.clear();
                result.addAll(resultTwo);
                resultTwo.clear();
            }
            if(result.size() > 0){
                counter = result.size() + 1;
            }

        }
        System.out.println(counter);
    }
}
