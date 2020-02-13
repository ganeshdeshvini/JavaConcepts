package miscellenous;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class MaximumNumberFromArray {
    static class MaxUsingIndividualDigit {
        Map<Integer, Integer> numberWithIndividualCount = new TreeMap<>(Collections.reverseOrder());

        long convertToMax(int[] arr) {
            for (int num : arr) {
                String currentNum = String.valueOf(num);
                for (int i = 0, n = currentNum.length(); i < n; i++) {
                    updateNumberCount(Character.getNumericValue(currentNum.charAt(i)));
                }
            }
            return Long.parseLong(getMaxString());
        }

        String getMaxString() {
            String maxNumber = "";
            for (Map.Entry<Integer, Integer> entry : numberWithIndividualCount.entrySet()) {
                int number = entry.getKey();
                int count = entry.getValue();
                maxNumber += String.join("", Collections.nCopies(count, String.valueOf(number)));
            }
            return maxNumber;
        }

        void updateNumberCount(int number) {
            int count = 1;
            if (numberWithIndividualCount.containsKey(number)) {
                count = numberWithIndividualCount.get(number) + 1;
            }
            numberWithIndividualCount.put(number, count);
        }
    }

    static class MaxUsingIndividualNumber {
        Map<Integer, Integer> numberWithIndividualCount = new TreeMap<>(Collections.reverseOrder());

        long convertToMax(int[] arr) {
            for (int num : arr) {
                numberWithIndividualCount.put(num, 1);
            }
            return Long.parseLong(getMaxString());
        }

        String getMaxString() {
            String maxNumber = "";
            for (Map.Entry<Integer, Integer> entry : numberWithIndividualCount.entrySet()) {
                maxNumber += entry.getKey();
            }
            return maxNumber;
        }
    }

    public static void main(String[] args) {
        int[] arr = {99, 8, 76, 45, 66, 9, 7, 33, 5, 42};
        System.out.println("Max Individual Digit is: " + new MaxUsingIndividualDigit().convertToMax(arr));
        System.out.println("Max Individual Number is: " + new MaxUsingIndividualNumber().convertToMax(arr));
    }
}