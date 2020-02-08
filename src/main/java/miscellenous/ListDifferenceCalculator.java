package miscellenous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class ListDifferenceCalculator {

    private ListDifferenceCalculator() {
    }

    public static class ListDifferences<T> {
        private final List<T> addedItems;
        private final List<T> deletedItems;

        private ListDifferences(List<T> addedItems, List<T> deletedItems) {
            this.addedItems = unmodifiableList(addedItems);
            this.deletedItems = unmodifiableList(deletedItems);
        }

        public List<T> getAddedItems() {
            return addedItems;
        }

        public List<T> getDeletedItems() {
            return deletedItems;
        }

    }

    public static <T> ListDifferences<T> compareLists(List<T> currentItems, List<T> newItems) {
        ArrayList<T> deletedItems = new ArrayList<>(currentItems);
        deletedItems.removeAll(newItems);

        ArrayList<T> addedItems = new ArrayList<>(newItems);
        addedItems.removeAll(currentItems);

        return new ListDifferences<>(addedItems, deletedItems);
    }

    public static void main(String[] args) {
        List<Integer> oldItems = Arrays.asList(1, 2, 3);
        List<Integer> newItems = Arrays.asList(1, 2, 4);
        ListDifferences<Integer> diff = compareLists(oldItems, newItems);

        System.out.println(diff.getAddedItems());
        System.out.println(diff.getDeletedItems());
    }
}

