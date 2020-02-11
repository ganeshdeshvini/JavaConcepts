package basics;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class ReverseNumerical implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return o2 - o1;
	}
}

public class CompartorExample {

	public static void main(String[] args) {
		final List<Integer> numbers = Arrays.asList(4, 7, 1, 6, 3, 5, 4);
		final List<Integer> expected = Arrays.asList(7, 6, 5, 4, 4, 3, 1);
		Collections.sort(numbers, new ReverseNumerical());
		System.out.println(expected.equals(numbers));
	}

}
