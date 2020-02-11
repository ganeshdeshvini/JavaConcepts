package basics;

public class StaticInstanceBlock {
    public static int order1 = order(1);
    public int order4 = order(4);

    static {
        order(2);
    }

    public StaticInstanceBlock() {
        order(6);
    }

    {
        order(5);
    }

    public static void main(String[] args) {
        order(3);
        new StaticInstanceBlock();
    }

    // Just for demonstration purposes:
    public static int order(int order) {
        System.out.println("Order " + order);
        return order;
    }
}