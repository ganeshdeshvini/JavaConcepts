package generic.methods;

public class Util {
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2){
        return p1.getKey().equals(p1.getKey()) && p1.getValue().equals(p2.getValue());
    }

    public static void main(String[] args) {
        Pair<Integer, String> p1 = new Pair<>(1, "apple");
        Pair<Integer, String> p2 = new Pair<>(1, "appl");
        boolean same = Util.compare(p1, p2);
        System.out.println(same);
    }
}