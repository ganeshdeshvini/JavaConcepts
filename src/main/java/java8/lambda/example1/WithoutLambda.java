package java8.lambda.example1;

public class WithoutLambda {

    public static void main(String[] args) {
        Greeting greeting = new WelcomeMessageGreeting();
        greeting.greet();

        greeting = new GoodByeMessageGreeting();
        greeting.greet();
    }
}

class WelcomeMessageGreeting implements Greeting {
    @Override
    public void greet() {
        System.out.println("Welcome");
    }
}

class GoodByeMessageGreeting implements Greeting {
    @Override
    public void greet() {
        System.out.println("GoodBye");
    }
}
