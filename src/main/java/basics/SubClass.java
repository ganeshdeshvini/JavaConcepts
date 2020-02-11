package basics;

public class SubClass extends Superclass {

    static void method() {
        // super.method(); // Super keyword will not work here. As it is not overridden method
        System.out.println("In Sub Class");
    }

    //	@SuppressWarnings("static-access") // The static method method() from the type SubClass should be accessed in a static way
    public static void main(String[] args) {
        SubClass obj = new SubClass();
        obj.method();
        SubClass.method();// It is same as above. Same method will be invoked
    }
}

class Superclass {
    static void method() {
        System.out.println("In Super Class");
    }
}