package java8.lambda;

public class ClosureExample {
    interface Process {
        void process(int x);
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        doProcess(a, x -> System.out.println(x * b));
    }

    static void doProcess(int i, Process process) {
        process.process(i);
    }
}

