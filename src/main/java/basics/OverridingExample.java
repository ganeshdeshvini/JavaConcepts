package basics;

/**
 * There are 5 main rules you should kept in mind while overriding a method.
 * They are,
 * <p>
 * a) Name of the method must be same as that of super class method.
 * <p>
 * b) Return type of overridden method must be compatible with the method being
 * overridden. i.e if a method has primitive type as it�s return type then it
 * must be overridden with primitive type only and if a method has derived type
 * as it�s return type then it must be overridden with same type or it�s sub
 * class types.
 * <p>
 * c) You must not reduce the visibility of a method while overriding.
 * <p>
 * d) You must not change parameter list of a method while overriding.
 * <p>
 * e) You can not increase the scope of exceptions while overriding a method
 * with throws clause.
 * <p>
 * f) Arguments Of Overrided Methods : For method to be properly overrided, You
 * must not change arguments of method in subclass. If you change the number of
 * arguments or types of arguments of overrided method in the subclass, then
 * method will be overloaded not overrided.
 */
public class OverridingExample {

    public static void main(String[] args) {
        Animal animal = new Cow();
        animal.eat();
    }

    private static abstract class Animal {
        abstract void eat();
    }

    private static class Cow extends Animal {
        @Override
        void eat() {
            System.out.println("Grass");
        }
    }
}
