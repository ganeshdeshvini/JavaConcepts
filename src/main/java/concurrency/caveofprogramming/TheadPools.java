package concurrency.caveofprogramming;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TheadPools implements Runnable {
	int id;

	public TheadPools(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Starting : " + this.id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed : " + this.id);

	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		for (int i = 1; i <= 5; i++) {
			executorService.submit(new TheadPools(i));
		}
		executorService.shutdown();
		System.out.println("All task submitted");
		try {
			executorService.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
