package erasure.genericmethods;

public class ErasureGenericMethod {

    public static <T> int count(T[] anArray, T elem) {
        int cnt = 0;
        for (T e : anArray)
            if (e.equals(elem))
                ++cnt;
        return cnt;
    }
    /*
    Because T is unbounded, the Java compiler replaces it with Object:

    compiled code
    public static int count(Object[] anArray, Object elem) {
        int cnt = 0;
        for (Object e : anArray)
            if (e.equals(elem))
                ++cnt;
            return cnt;
    }
     */

    public static <T extends Shape> void draw(T shape) { /* ... */ }
    /*
    compiled code
    public static void draw(Shape shape) { ... }
     */

    public static void main(String[] args) {
        // Counts the number of occurrences of elem in anArray.
//

    }

    class Shape { /* ... */
    }

    class Circle extends Shape { /* ... */
    }

    class Rectangle extends Shape { /* ... */
    }
}


