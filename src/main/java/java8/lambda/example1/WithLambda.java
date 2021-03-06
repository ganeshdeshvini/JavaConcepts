package java8.lambda.example1;

public class WithLambda {
    interface Greeting {
        void greet();
    }

    public static void main(String[] args) {
        Greeting contract = () -> System.out.println("Welcome");
        contract.greet();

        contract = () -> System.out.println("GoodBye");
        contract.greet();
    }
}



