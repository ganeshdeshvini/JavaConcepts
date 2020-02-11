package concurrency.caveofprogramming.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//ordering Lock properly is one of the solutions
public class DeadLockSolution1 {
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();
	Account account1 = new Account();
	Account account2 = new Account();
	Random random = new Random();

	public void firstThread() {
		for (int i = 0; i < 100; i++) {
			lock1.lock();
			lock2.lock();
			try {
				Account.transfer(account1, account2, random.nextInt(100));
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	public void secondThread() {
		for (int i = 0; i < 100; i++) {
			// order is one of the solution
			lock1.lock();
			lock2.lock();
			try {
				Account.transfer(account2, account1, random.nextInt(100));
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	private void finished() {
		System.out.println("Account1 balance : " + account1.getBalance());
		System.out.println("Account2 balance : " + account2.getBalance());
		System.out.println("Total balance : " + (account1.getBalance() + account2.getBalance()));
	}

	public static void main(String[] args) {
		DeadLockSolution1 obj = new DeadLockSolution1();

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
