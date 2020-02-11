package concurrency.howtodoinjava.deadlock;

class ResourceA {
	int a = 10;
}

class ResourceB {
	int b = 20;
}

public class ResolveDeadLockTest {

	public static void main(String[] args) {
		ResourceA resourceA = new ResourceA();
		ResourceB resourceB = new ResourceB();

		Thread thread1 = new Thread(() -> {
			synchronized (resourceA) {
				System.out.println("Thread1 ResourceA");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (resourceB) {
					System.out.println("Thread1 ResourceB");
				}
			}
		});

		Thread thread2 = new Thread(() -> {
			synchronized (resourceB) {
				System.out.println("Thread2 ResourceB");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (resourceA) {
					System.out.println("Thread2 ResourceA");
				}
			}
		});

		thread1.start();
		thread2.start();
	}
}
