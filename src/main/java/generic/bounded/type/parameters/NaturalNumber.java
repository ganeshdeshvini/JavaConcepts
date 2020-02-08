package generic.bounded.type.parameters;

public class NaturalNumber<T extends Integer> {
    private T n;

    public NaturalNumber(T n){
        this.n = n;
    }

    public boolean isEven() {
        return n.intValue() % 2 == 0;
    }

    public static void main(String[] args) {
        NaturalNumber<Integer> naturalNumber = new NaturalNumber<>(10);
        System.out.println(naturalNumber.n + " isEven: " + naturalNumber.isEven());

        naturalNumber = new NaturalNumber<>(11);
        System.out.println(naturalNumber.n  + " isEven: " + naturalNumber.isEven());
    }

    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;

        for(T e : anArray) {
            if(elem.compareTo(elem) > 0){
                ++count;
            }
        }
        return count;
    }

    public interface Comparable<T> {
        int compareTo(T o);
    }
}
