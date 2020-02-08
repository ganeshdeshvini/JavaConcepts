package generic.type;

public class Test {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();
        integerBox.set(10);
        int x = integerBox.get();
        System.out.println(x);

        //raw type
        Box rawBox = new Box();
        rawBox.set("Hello");
        System.out.println(rawBox.get());

        integerBox = rawBox;
        Integer y = integerBox.get();
        System.out.println(y);

        Box<String> stringBox = new Box<>();
        Box rawBoxString = stringBox;
        rawBox.set(8);  // warning: unchecked invocation to set(T)

    }
}
