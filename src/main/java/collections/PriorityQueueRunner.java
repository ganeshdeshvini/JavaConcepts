package collections;

import java.util.PriorityQueue;

public class PriorityQueueRunner {
    public static void main(String[] args) {
        minPriorityDefault();
        maxPriorityQueue();
    }

    private static void minPriorityDefault() {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(100);
        minHeap.add(10);
        minHeap.add(50);
        minHeap.add(25);
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " - ");
        }
        System.out.println();
    }

    private static void maxPriorityQueue() {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (o1, o2) -> o2.compareTo(o1)
        );
        maxHeap.add(100);
        maxHeap.add(10);
        maxHeap.add(50);
        maxHeap.add(25);
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " - ");
        }
        System.out.println();
    }

}
