package java8.lambda.this_reference;

public class ExampleJava8Lambda {
    interface Process {
        void process(int i);
    }

    public static void main(String[] args) {
        ExampleJava8Lambda exampleJava8Lambda = new ExampleJava8Lambda();
        exampleJava8Lambda.execute();

        //error for below code
        //System.out.println("this reference " + this);
    }

    void execute() {
        this.doProcess(10, i -> {
            System.out.println(i);
            System.out.println("this reference " + this);
        });
    }

    void doProcess(int i, Process process) {
        process.process(i);
    }

    @Override
    public String toString() {
        return "Called from ExampleAnonymousInnerClass class";
    }
}
