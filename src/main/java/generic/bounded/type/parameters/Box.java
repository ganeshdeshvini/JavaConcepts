package generic.bounded.type.parameters;

public class Box<T> {
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get(){
        return t;
    }

    public <U extends Number> void inspect(U u) {
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }

    public static void main(String[] args) {
        Box<Double> integerBox = new Box<>();
        integerBox.set(11.0);
        integerBox.inspect(11);

        Box<Number> numberBox = new Box<>();
        numberBox.set(112);
        integerBox.boxTest(numberBox);
//        integerBox.boxTest(integerBox);
    }

    public void boxTest(Box<Number> n){
        System.out.println(n.get());
    }
}
