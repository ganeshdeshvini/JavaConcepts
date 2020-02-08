package miscellenous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * PRE-REQUISITES:- INSTALL Java Stream Debugger from Plugins section of intellij
 */
public class JavaStreamDebuggerExample {
    public static void main(String[] args) {
        int[] result = Arrays.stream(new int[] { 1, 2, 3, 4, 5 })
                .flatMap(JavaStreamDebuggerExample::primeFactors)
                .distinct()
                .sorted()
                .toArray();
        System.out.println(Arrays.toString(result));
    }

    public static IntStream primeFactors(int number) {
        int n = number;
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= n/i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return Arrays.stream(factors.stream().mapToInt(value -> value).toArray());
    }
}
