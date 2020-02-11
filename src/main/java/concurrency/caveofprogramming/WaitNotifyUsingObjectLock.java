package concurrency.caveofprogramming;

import java.util.LinkedList;

public class WaitNotifyUsingObjectLock {

	private LinkedList<Integer> linkedList = new LinkedList<>();
	private Object lock = new Object();
	private int limit = 10;

	private void producer() {
		int cnt = 1;
		while (true) {
			synchronized (lock) {
				try {
					while (linkedList.size() == limit) {
						lock.wait();
					}
					System.out.println("Producer push : " + cnt);
					linkedList.add(cnt++);
					lock.notify();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private void consumer() {
		while (true) {

			synchronized (lock) {
				try {
					while (linkedList.size() == 0) {
						lock.wait();
					}
					int n = linkedList.removeFirst();
					System.out.println("Consumer got : " + n + ", size : " + linkedList.size());
					lock.notify();
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		WaitNotifyUsingObjectLock obj = new WaitNotifyUsingObjectLock();
		Thread t1 = new Thread(() -> obj.producer());
		Thread t2 = new Thread(() -> obj.consumer());

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (Exception e) {

		}
	}
}
