package java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Person {
	String name;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return name;
	}
}

class Item {

	String name;
	int qty;
	BigDecimal price;

	// constructors, getter/setters
	Item(String name, int qty, BigDecimal price) {
		this.name = name;
		this.qty = qty;
		this.price = price;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return name;
	}

}

public class StreamExamples {

	public static void main(String[] args) {
		// 3 apple, 2 banana, others 1
		List<Item> items = Arrays.asList(new Item("apple", 10, new BigDecimal("9.99")),
				new Item("banana", 20, new BigDecimal("19.99")), new Item("orang", 10, new BigDecimal("29.99")),
				new Item("watermelon", 10, new BigDecimal("29.99")), new Item("papaya", 20, new BigDecimal("9.99")),
				new Item("apple", 10, new BigDecimal("9.99")), new Item("banana", 10, new BigDecimal("19.99")),
				new Item("apple", 20, new BigDecimal("9.99")));

		Map<String, Long> counting = items.stream()
				.collect(Collectors.groupingBy(Item::getName, Collectors.counting()));
		System.out.println(counting);

		Map<BigDecimal, List<Item>> groupByPrice = items.stream().collect(Collectors.groupingBy(Item::getPrice));
		System.out.println(groupByPrice);

		System.exit(0);

		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
		myList.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).sorted().forEach(System.out::println);

		List<Person> persons = Arrays.asList(new Person("Max", 18), new Person("Peter", 23), new Person("Pamela", 23),
				new Person("David", 12));

		persons.stream().filter(p -> {
			return p.age >= 18;
		}).forEach(System.out::println);
		System.out.println();
		List<Person> newPerson = persons.stream().filter(p -> p.age >= 18).collect(Collectors.toList());
		newPerson.forEach(System.out::println);

		Map<Integer, List<Person>> personByAge = persons.stream().collect(Collectors.groupingBy(p -> p.age));

		personByAge.forEach((age, p) -> System.out.println(age + " " + p));

		List<String> list = new ArrayList<String>();
		list.add("Hello");
		list.add("Hello");
		list.add("World");

		Map<String, Long> counted = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(counted);
	}

}
