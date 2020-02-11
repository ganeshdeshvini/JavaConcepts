package concurrency;

public class ThreadJoinExample {
	static class PrintTest implements Runnable {
		public void run() {
			System.out.println("Thread started::" + Thread.currentThread().getName());

			for (int i = 1; i <= 3; i++) {
				System.out.println(Thread.currentThread().getName() + " " + i);
			}

			System.out.println("Thread ended::" + Thread.currentThread().getName());
		}
	}
	public static void main(String[] args) {
		PrintTest p1 = new PrintTest();
		Thread t1 = new Thread(p1, "T1");
		Thread t2 = new Thread(p1, "T2");
		t1.start();

		try {
//			t1.join();
			System.out.println("T1 Done");
			t2.start();
//			t2.join();
			System.out.println("T2 Done");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}