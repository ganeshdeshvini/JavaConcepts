package java8.lambda.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class PersonSolutionJava8Consumer {
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
        printConditionally(persons, person -> true);

        System.out.println("\nPrinting all persons that have last name beginning with C");
        printConditionally(persons, person -> person.getLastName().startsWith("C"));

        System.out.println("Printing all persons that have first name beginning with C");
        printConditionally(persons, person -> person.getFirstName().startsWith("C"));
    }

    private static void printConditionally(List<Person> persons, Predicate<Person> condition) {
        for (Person person : persons) {
            if (condition.test(person)) {
                System.out.println(person);
            }
        }
    }
}
