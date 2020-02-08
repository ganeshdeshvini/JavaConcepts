package wildcards.unbound;

import java.util.Arrays;
import java.util.List;

public class UnboundWildCardRunner {

    static void printListUsingObject(List<Object> list) {
        for (Object elem : list)
            System.out.println(elem + " ");
        System.out.println();
    }

    static void printListUsingUnbound(List<?> list) {
        for (Object elem : list)
            System.out.println(elem + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        List<Object> objectList = Arrays.asList(1, 2, 3);

        printListUsingObject(objectList);
        //code will not compile as List<Integer> is not subtype of List<Object>
        //printListUsingObject(integerList);

        printListUsingUnbound(integerList);
        printListUsingUnbound(objectList);
    }
}
