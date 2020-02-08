package java8.lambda.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PersonSolutionJava8Predicate {
    public static void main(String[] args) {
        System.out.println(Integer.compare(11, 2));
        List<Person> persons = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 60),
                new Person("Thomas", "Carlyle", 60),
                new Person("Charlotte", "Bronte", 60)
        );

        Collections.sort(persons, (person1, person2) -> person1.getLastName().compareTo(person2.getLastName()));

        System.out.println("Printing all persons");
        performConditionally(persons, person -> true, person -> System.out.println(person));

        System.out.println("\nPrinting all persons that have last name beginning with C");
        performConditionally(persons, person -> person.getLastName().startsWith("C"),
                person -> System.out.println(person.getLastName()));

        System.out.println("Printing all persons that have first name beginning with C");
        performConditionally(persons, person -> person.getFirstName().startsWith("C"),
                person -> System.out.println(person.getFirstName()));
    }

    private static void performConditionally(List<Person> persons, Predicate<Person> condition,
            Consumer<Person> behaviour) {
        for (Person person : persons) {
            if (condition.test(person)) {
                behaviour.accept(person);
            }
        }
    }
}
