package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamBasic {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		// function takes 2 parameter,
		// 1st is T(Type) &
		// 2nd is R(ReturnType)
		Function<Integer, Integer> mapperFunction = new Function<Integer, Integer>() {
			public Integer apply(Integer i) {
				return i * 2;
			}
		};

		BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer i, Integer j) {
				return i + j;
			}
		};

		Stream<Integer> s = list.stream();
		Stream<Integer> s1 = s.map(mapperFunction);
		// here 0 is the initial value, just like sum=0, then go
		// on adding the value as defined in binary operator
		System.out.println(s1.reduce(0, binaryOperator));

		// reduce is use for aggregating values(addition, average etc.,)
		System.out.println(list.stream().map(i -> i * 2).reduce(0, (c, e) -> c + e));

		// use built in function
		System.out.println(list.stream().map(i -> i * 2).reduce(0, (c, e) -> Integer.sum(c, e)));

		// using method reference
		System.out.println(list.stream().map(i -> i * 2).reduce(0, Integer::sum));

		List<Integer> list2 = Arrays.asList(12, 30, 75, 34, 55);
		System.out.println(list2.stream().filter(i -> i % 5 == 0).reduce(0, Integer::sum));

		Predicate<Integer> predicate = new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				return t % 5 == 0;
			}

		};
		System.out.println(list2.stream()
								.filter(predicate)
								.reduce(0, Integer::sum));
		
		System.out.println(list2.stream()
				.filter(predicate)
				.map(i->i*2)
				.findFirst()
				.orElse(0));
	}
}
