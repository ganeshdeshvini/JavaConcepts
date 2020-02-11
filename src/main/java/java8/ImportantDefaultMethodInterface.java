package java8;

public class ImportantDefaultMethodInterface {
    public static void main(String[] args) {
        B b = new C();
        A a = new C();
        b.show();
        a.show();
        a.test();
        b.test();
        new C().test();
    }

    class X {
        void show() {
            System.out.println("show of class X");
        }
    }

    class Y extends X implements A, B {

        @Override
        public void show() {
            System.out.println("Show of Y");
        }

        @Override
        public void test() {

        }
    }

    interface A {
        void show();

        default void test() {
            System.out.println("test of interface A");
        }
    }

    interface B {
        void show();

        default void test() {
            System.out.println("test of interface B");
        }
    }

    private static class C implements A, B {
        @Override
        public void show() {
            System.out.println("Show from C class called");
        }

        /**
         * NEED to compulsory override/implement default method test()
         * as test is defined in interface A & B both, so there is ambiguity, same like Java Multiple Inheritance Diamond problem
         * so to  resolve the ambiguity we have to override the method
         */
        @Override
        public void test() {
            System.out.println("test method of CLass C");
        }
    }
}



