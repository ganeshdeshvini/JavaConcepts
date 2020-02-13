package concurrency.basics;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RunnableExample {

    public static void main(String[] args) {
        // final Thread thread1 = new Thread(new ThreadPrinter());
        // thread1.start();
        //
        final Executor executor = Executors.newCachedThreadPool();
        executor.execute(new ThreadPrinter());
        executor.execute(new ThreadPrinter());
        executor.execute(new ThreadPrinter());
    }

    static class ThreadPrinter implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadPrinter " + Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
