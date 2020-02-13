package concurrency.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import static enumexample.AnsiColorEnum.getColorById;
import static helper.Util.getCurrentThread;
import static helper.Util.getCurrentThreadName;

public class WaitNotifyRunner {
    static class Producer implements Runnable {
        private final Queue<Integer> sharedQueue;
        private final int MAX_QUEUE_CAPACITY;

        public Producer(Queue<Integer> sharedQueue, int maxQueueCapacity) {
            this.sharedQueue = sharedQueue;
            this.MAX_QUEUE_CAPACITY = maxQueueCapacity;
        }

        @Override
        public void run() {
            int cnt = 1;
            while (true) {
                synchronized (sharedQueue) {
                    try {
                        while (sharedQueue.size() == MAX_QUEUE_CAPACITY) {
                            Thread currentThread = getCurrentThread();
                            System.out.println(String.format("%s Thread: %d  Waiting for Consumer...", currentThread.getName(), currentThread.getId()));
                            sharedQueue.wait();
                        }
                        System.out.println(String.format("%s Producing: {%d}", getCurrentThreadName(), cnt));
                        sharedQueue.add(cnt++);
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sharedQueue.notify();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        private final Queue<Integer> sharedQueue;

        public Consumer(Queue<Integer> sharedQueue) {
            this.sharedQueue = sharedQueue;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (sharedQueue) {
                    while (sharedQueue.isEmpty()) {
                        try {
                            Thread currentThread = getCurrentThread();
                            System.out.println(String.format("%s Thread: %d  Waiting for Producer...", currentThread.getName(), currentThread.getId()));
                            sharedQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(String.format("%s Consuming {%d}", getCurrentThreadName(), sharedQueue.poll()));
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sharedQueue.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        Queue<Integer> sharedQueue = new LinkedList();
        new Thread(new Producer(sharedQueue, 4), getColorById(1)).start();
        new Thread(new Consumer(sharedQueue), getColorById(2)).start();
    }
}



