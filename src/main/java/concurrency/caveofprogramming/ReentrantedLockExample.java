package concurrency.caveofprogramming;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantedLockExample {

	private int cnt = 0;
	private Lock lock = new ReentrantLock();

	private void incrementCnt() {
		for (int i = 0; i < 100; i++) {
			cnt++;
		}
	}

	private void firstThread() {
		lock.lock();
		try {
			incrementCnt();
		} finally {
			lock.unlock();
		}
	}

	private void secondThread() {
		lock.lock();
		try {
			incrementCnt();
		} finally {
			lock.unlock();
		}
	}

	private void finished() {
		System.out.println("Count is : " + cnt);
	}

	public static void main(String[] args) {
		ReentrantedLockExample obj = new ReentrantedLockExample();
		Thread t1 = new Thread(() -> obj.firstThread());
		Thread t2 = new Thread(() -> obj.secondThread());

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (Exception e) {

		}
		obj.finished();
	}

}
