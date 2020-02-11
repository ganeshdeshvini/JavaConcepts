package concurrency.caveofprogramming;

public class SynchronizationExample {
	private int count = 0;

	private void incrementCounterWithoutSynchronized() {
		this.count++;
	}

	private synchronized void incrementCounterWithSynchronized() {
		// No need of making count as volatile as in synchronized block, Java
		// makes sure that you receive the updated copy every time
		this.count++;
	}

	public static void main(String[] args) {
		SynchronizationExample synchronizationExample = new SynchronizationExample();
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				// synchronizationExample.incrementCounterWithoutSynchronized();
				synchronizationExample.incrementCounterWithSynchronized();
			}
		});
		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				// synchronizationExample.incrementCounterWithoutSynchronized();
				synchronizationExample.incrementCounterWithSynchronized();
			}
		});

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Count is " + synchronizationExample.count);
	}
}
