package java8.lambda.method.reference;

public class MethodReferenceExample {
    public static void main(String[] args) {
        ZeroParameter zeroParameter = () -> printSomething();
        ZeroParameter zeroParameter2 = MethodReferenceExample::printSomething;
        zeroParameter.printSomething();
        zeroParameter2.printSomething();

        MethodReferenceExample objMethodReferenceExample = new MethodReferenceExample();
        NParameter nParameter = n -> objMethodReferenceExample.square(n);
        NParameter nParameter2 = objMethodReferenceExample::square;
        nParameter.square(2);
        nParameter2.square(2);
    }

    private static void printSomething() {
        System.out.println("Hare Krsna");
    }

    private void square(int n) {
        System.out.println(n * n);
    }
}

interface ZeroParameter {
    void printSomething();
}

interface NParameter {
    void square(int n);
}
