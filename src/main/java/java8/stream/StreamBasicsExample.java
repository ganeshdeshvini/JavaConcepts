package java8.stream;

import java8.lambda.exercise.Person;

import java.util.Arrays;
import java.util.List;

public class StreamBasicsExample {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Ganesh", "Deshvini", 28),
                new Person("Nilesh", "Deshvini", 18),
                new Person("Laxmi", "Deshvini", 28)
        );

        persons.stream()
                .filter(person -> person.getFirstName().startsWith("G"))
                .forEach(System.out::println);
    }
}
