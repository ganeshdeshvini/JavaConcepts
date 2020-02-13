package java8.lambda.example1;

public class WithoutLambda {
    interface Greeting {
        void greet();
    }

    static class WelcomeMessageGreeting implements Greeting {
        @Override
        public void greet() {
            System.out.println("Welcome");
        }
    }

    static class GoodByeMessageGreeting implements Greeting {
        @Override
        public void greet() {
            System.out.println("GoodBye");
        }
    }

    public static void main(String[] args) {
        Greeting greeting = new WelcomeMessageGreeting();
        greeting.greet();

        greeting = new GoodByeMessageGreeting();
        greeting.greet();
    }
}


