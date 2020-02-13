package concurrency.producerconsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueProducerConsumer {

    private BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);

    private void producer() {
        Random random = new Random();
        try {
            while (true) {
                blockingQueue.put(random.nextInt(100));
            }
        } catch (Exception e) {

        }
    }

    private void consumer() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(500);
                int val = blockingQueue.take();
                System.out.println("Taken value : " + val + " size=" + blockingQueue.size());
            }
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueueProducerConsumer blockingQueueProducerConsumer = new BlockingQueueProducerConsumer();
        Thread t1 = new Thread(() -> blockingQueueProducerConsumer.producer());
        Thread t2 = new Thread(() -> blockingQueueProducerConsumer.consumer());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
