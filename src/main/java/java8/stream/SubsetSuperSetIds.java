package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SubsetSuperSetIds {
    public static void main(String[] args) {
        solution2();
    }

    static void solution2(){
        List<DataHolder> subset = Arrays.asList(
                new DataHolder(1L),
                new DataHolder(2L));
        List<Long> superset = Arrays.asList(1L, 2L, 3L);
        List<Long> subsetIds = subset.stream().map(dataHolder -> dataHolder.id).collect(Collectors.toList());
        System.out.println(superset.stream().filter(id -> !subsetIds.contains(id)).collect(Collectors.toList()));
    }

    static void solution1(){
        List<DataHolder> subset = Arrays.asList(
                new DataHolder(1L),
                new DataHolder(2L));
        List<Long> superset = Arrays.asList(1L, 2L, 3L);

        List<Long> subsetIds = subset.stream().map(dataHolder -> dataHolder.id).collect(Collectors.toList());

        List<Long> newList = superset.stream().filter(
                negate(subsetIds::contains)
        ).collect(Collectors.toList());
        System.out.println(newList);
    }
    private static <T> Predicate<T> negate(Predicate<T> predicate) {
        return predicate.negate();
    }
}
