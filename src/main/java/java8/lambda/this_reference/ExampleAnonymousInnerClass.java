package java8.lambda.this_reference;

public class ExampleAnonymousInnerClass {
    interface Process {
        void process(int i);
    }

    public static void main(String[] args) {
        ExampleAnonymousInnerClass exampleAnonymousInnerClass = new ExampleAnonymousInnerClass();
        exampleAnonymousInnerClass.doProcess(10, new Process() {
            @Override
            public void process(int i) {
                System.out.println("value of i is: " + i);
                System.out.println("this reference= " + this);
            }

            @Override
            public String toString() {
                return "Called from Process inner class";
            }
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

