package concurrency.caveofprogramming;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedBlockExample {

	Object lock1 = new Object();
	Object lock2 = new Object();

	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();

	synchronized void addToList1SynchronizedMethod(int n) {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list1.add(n);
	}

	void addToList1SynchronizedBlock(int n) {
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list1.add(n);
		}
	}

	synchronized void addToList2SynchronizedMethod(int n) {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list2.add(n);
	}

	void addToList2SynchronizedBlock(int n) {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list2.add(n);
		}
	}

	void startProcessSynchronizedMethod() {
		for (int i = 0; i < 100; i++) {
			addToList1SynchronizedMethod(i);
			addToList2SynchronizedMethod(i);
		}
	}

	void startProcessSynchronizedBlock() {
		for (int i = 0; i < 100; i++) {
			addToList1SynchronizedBlock(i);
			addToList2SynchronizedBlock(i);
		}
	}

	public static void main(String[] args) {
		SynchronizedBlockExample synchronizedBlockExample = new SynchronizedBlockExample();
		long start = System.currentTimeMillis();
		// synchronizedBlockExample.startProcess();
		Thread t1 = new Thread(() -> {
			// synchronizedBlockExample.startProcessSynchronizedMethod();
			synchronizedBlockExample.startProcessSynchronizedBlock();
		});
		Thread t2 = new Thread(() -> {
			// synchronizedBlockExample.startProcessSynchronizedMethod();
			synchronizedBlockExample.startProcessSynchronizedBlock();
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("Elapsed time = " + (end - start));
		System.out.println("list1 : " + synchronizedBlockExample.list1.size());
		System.out.println("list2 : " + synchronizedBlockExample.list2.size());
	}
}