package generic.wildcards.lowerbound;

import java.util.Arrays;
import java.util.List;

public class LowerBoundRunner {
    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }
    public static void addNumbersRestrictiveToIntegerOnly(List<Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        List<Number> numberList = Arrays.asList(1, 2, 3);

        addNumbers(integerList);
        addNumbers(numberList);

        addNumbersRestrictiveToIntegerOnly(integerList);
        //below code will give error as it is RESTRICTED to Integer only
        //addNumbersRestrictiveToIntegerOnly(numberList);

    }
}
