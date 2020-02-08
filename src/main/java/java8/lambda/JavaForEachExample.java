package java8.lambda;

import java8.lambda.exercise.Person;

import java.util.Arrays;
import java.util.List;

public class JavaForEachExample {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Ganesh", "Deshvini", 28),
                new Person("Nilesh", "Deshvini", 23),
                new Person("Sachin", "Vichare", 24)
        );

        forInLoop(persons);
        System.out.println("=====================");
        forEachLoop(persons);
    }

    private static void forInLoop(List<Person> persons) {
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    private static void forEachLoop(List<Person> persons) {
        persons.forEach((person) -> System.out.println(person));
    }
}
