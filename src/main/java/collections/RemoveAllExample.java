package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveAllExample {
    public static void main(String[] args) {
        List<Integer> oldList = Arrays.asList(1);
        List<Integer> newList = new ArrayList<>();

        System.out.println(oldList.removeAll(newList));
    }
}
