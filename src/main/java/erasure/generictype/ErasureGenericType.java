package erasure.generictype;


class Node<T> {

    private T data;
    private Node<T> next;

    Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }
}

/*
Because the type parameter T is unbounded, the Java compiler replaces it with Object:

class Node {

    private Object data;
    private Node next;

    Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() { return data; }
    // ...
}
*/


class Node2<T extends Comparable<T>> {

    private T data;
    private Node<T> next;

    Node2(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() { return data; }
    // ...
}

/*
The Java compiler replaces the bounded type parameter T with the first bound class, Comparable:

class Node2 {

    private Comparable data;
    private Node next;

    Node2(Comparable data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Comparable getData() { return data; }
    // ...
}
 */

public class ErasureGenericType {
    public static void main(String[] args) {

    }
}
