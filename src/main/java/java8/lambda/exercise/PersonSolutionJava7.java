package java8.lambda.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonSolutionJava7 {
    public static void main(String[] args) {
        System.out.println(Integer.compare(11, 2));
        List<Person> persons = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 60),
                new Person("Thomas", "Carlyle", 60),
                new Person("Charlotte", "Bronte", 60)
        );

        Collections.sort(persons, new Comparator<Person>() {
            @Override public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });

        System.out.println("Printing all persons");
        printAll(persons);

        System.out.println("\nPrinting all persons that have last name beginning with C");
        printConditionally(persons, new Condition() {
            @Override public boolean test(Person person) {
                return person.getLastName().startsWith("C");
            }
        });

        System.out.println("Printing all persons that have first name beginning with C");
        printConditionally(persons, new Condition() {
            @Override public boolean test(Person person) {
                return person.getFirstName().startsWith("C");
            }
        });
    }

    private static void printConditionally(List<Person> persons, Condition condition) {
        for (Person person : persons) {
            if (condition.test(person)) {
                System.out.println(person);
            }
        }
    }

    private static void printAll(List<Person> persons) {
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}

