package concurrency.basics;

import java.util.concurrent.TimeUnit;

public class JoinExample {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("First Task started");
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("First Task completed");
        });
        Thread t2 = new Thread(() -> {
            System.out.println("Second Task completed");
        });
        t1.start();
        //Comment me to see the difference
        t1.join();
        t2.start();
    }
}
