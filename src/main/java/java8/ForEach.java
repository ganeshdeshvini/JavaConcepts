package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class ForEach {
    public static void main(String[] args) {
        List<Integer> listData = Arrays.asList(1, 2, 3, 4);
        listData.forEach(System.out::println);

        // alternate method for FOREACH using Consumer interface with
        // implemented class
        Consumer<Integer> consumer = new ConsumerImpl<Integer>();
        listData.forEach(consumer);

        // alternate method for FOREACH using Consumer interface & anonymous
        // class
        consumer = new Consumer<Integer>() {
            public void accept(Integer i) {
                System.out.println(i);
            }
        };
        listData.forEach(consumer);

        // ForEach takes a Consumer object as parameter, which has accept()
        consumer = x -> System.out.println(x);
        listData.forEach(consumer);

        // ForEach takes a Consumer object as parameter, which has accept()
        listData.forEach(x -> System.out.println(x));
    }

    private static class ConsumerImpl<T> implements Consumer<T> {
        @Override
        public void accept(T t) {
            System.out.println(t);
        }
    }
}
