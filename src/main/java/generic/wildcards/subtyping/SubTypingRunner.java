package generic.wildcards.subtyping;

import java.util.ArrayList;
import java.util.List;

public class SubTypingRunner {
    public static void main(String[] args) {
        List<? extends Integer> intList = new ArrayList<>();
        List<? extends Number> numbers = intList;
        //will throw compile time error
//        List<Number> numberListRestrictive = intList;
    }
}
