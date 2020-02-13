package concurrency.deadlock.caveofprogramming;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Custom method for Acquiring Locks(Checking if already locked then unlock)
public class DeadLockSolution2 {
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();
	Account account1 = new Account();
	Account account2 = new Account();
	Random random = new Random();

	private void acquireLocks(Lock firstLock, Lock secondLock) {
		while (true) {

			boolean gotFirstLock = false;
			boolean gotSecondLock = false;
			//
			try {
				gotFirstLock = firstLock.tryLock();
				gotSecondLock = secondLock.tryLock();

			} finally {
				if (gotFirstLock && gotSecondLock)
					return;
				if (gotFirstLock) {
					firstLock.unlock();
				}
				if (gotSecondLock) {
					secondLock.unlock();
				}
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void firstThread() {
		for (int i = 0; i < 100; i++) {
			acquireLocks(lock1, lock2);
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
			acquireLocks(lock1, lock2);
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
		DeadLockSolution2 obj = new DeadLockSolution2();

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
