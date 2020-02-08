package java8.lambda;

public class TypeInferenceExample {
    public static void main(String[] args) {
        printStringLength(s -> s.length());
    }

    static void printStringLength(StringLengthLambda stringLengthLambda) {
        System.out.println(stringLengthLambda.getLength("Hare Krsna"));
    }

    interface StringLengthLambda {
        int getLength(String s);
    }
}
