package java8.lambda.exercise;

import java.util.function.BiConsumer;

public class ExceptionHandlingUsingLambda {
    public static void main(String[] args) {
        int[] someNumbers = { 1, 2, 3, 4 };
        int divideBy = 0;

        process(someNumbers, divideBy, wrapperLambda((value, key) -> System.out.println(value / key)));
    }

    static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> biConsumer) {
        for (int number : someNumbers) {
            biConsumer.accept(number, key);
        }
    }

    static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> biConsumer) {
        return (value, key) -> {
            try {
                biConsumer.accept(value, key);
            } catch (ArithmeticException e) {
                System.out.println("Exception in wrapper lambda");
            }
        };
    }
}
