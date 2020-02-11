package java8;

import java.util.Arrays;
import java.util.List;

public class MethodReference {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("METHOD REF");
        // simple Method reference
        list.forEach(System.out::print);

        // LAMBDA
        System.out.println("\nLAMBDA");
        list.forEach(i -> doubleIt(i));

        // METHOD REF with custom function(replacing above lambda) using STATIC METHOD
        System.out.println("\nMETHOD REF with custom method");
        list.forEach(MethodReference::doubleIt);

        // METHOD REF with custom function(replacing above lambda) using INSTANCE METHOD
        System.out.println("\nMETHOD REF with custom method");
        list.forEach(new MethodReference()::cubeIt);

    }

    static void doubleIt(int i) {
        System.out.print(i * i + " ");
    }

    void cubeIt(int i) {
        System.out.println(Math.pow(i, 3));
    }

}
