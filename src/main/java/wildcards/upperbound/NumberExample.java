package wildcards.upperbound;

import java.util.ArrayList;
import java.util.List;

public class NumberExample {

    static void restrictive(List<Number> numberList){
        System.out.println("I can accept only Number");
    }

    static void lessRestrictive(List<? extends Number> numberList){
        System.out.println("I can accept only Number + anything which is-a Number relationship");
    }

    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        restrictive(numberList);
        //below code will cause error as it is more restrictive to Number type only
        //restrictive(integerList);

        lessRestrictive(numberList);
        lessRestrictive(integerList);
    }
}
