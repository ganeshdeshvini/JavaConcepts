package concurrency.caveofprogramming;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

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
				Thread.sleep(500);
				int val = blockingQueue.take();
				System.out.println("Taken value : " + val + " size=" + blockingQueue.size());
			}
		} catch (Exception e) {

		}
	}

	public static void main(String[] args) {
		ProducerConsumer producerConsumer = new ProducerConsumer();
		Thread t1 = new Thread(() -> producerConsumer.producer());
		Thread t2 = new Thread(() -> producerConsumer.consumer());
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
