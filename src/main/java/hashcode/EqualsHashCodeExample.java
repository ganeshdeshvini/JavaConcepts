package hashcode;

import java.util.HashSet;
import java.util.Set;

public class EqualsHashCodeExample {
    public static void main(String[] args) {
        String str = "1.0";
        Object object = str;
        System.out.println(Double.parseDouble(object.toString()));
        System.exit(0);
        Set<Student> studentSet = new HashSet<>();
//        studentSet.add(new Student("Krsna", 16));
//        studentSet.add(new Student("Radha", 12));
//        studentSet.add(new Student("Krsna", 16));
//        System.out.println(studentSet.size());
//        studentSet.forEach(student -> System.out.println(student.name + " | " + student.rollNo));

        Animal animal = new Animal();
        Dog dog = new Dog();
        Animal animalForDog = new Dog();
        System.out.println("Animal get class :: " + animal.getClass());
        System.out.println("Dog get class :: " + dog.getClass());
        System.out.println("Animal with Dog object get class :: " + animalForDog.getClass());
    }
}

class Student {
    String name;
    int rollNo;

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (rollNo != student.rollNo) return false;
        return name.equals(student.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + rollNo;
        return result;
    }
}

class Animal {
    void sleep() {
        System.out.println("Animal is sleeping");
    }
}

class Dog extends Animal {
    void sleep() {
        System.out.println("Dog is sleeping");
    }
}

