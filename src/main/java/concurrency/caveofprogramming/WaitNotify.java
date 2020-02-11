package concurrency.caveofprogramming;

import java.util.Scanner;

public class WaitNotify {

	private void producer() {
		synchronized (this) {
			System.out.println("In producer");
			try {
				System.out.println("Staring to wait()");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Resumed");
		}
	}

	private void consumer() {
		synchronized (this) {
			System.out.println("Inside consumer");
			try {
				Thread.sleep(1000);
				Scanner scanner = new Scanner(System.in);
				System.out.println("Waiting for Enter key");
				scanner.nextLine();
				System.out.println("Enter key pressed");
				notify();
				System.out.println("Statement after notify");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		WaitNotify waitNotify = new WaitNotify();
		Thread t1 = new Thread(() -> waitNotify.producer());
		Thread t2 = new Thread(() -> waitNotify.consumer());

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {

		}
	}

}
