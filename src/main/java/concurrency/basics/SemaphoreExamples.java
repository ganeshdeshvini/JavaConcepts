package concurrency.basics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;


public class SemaphoreExamples {
    static class Connection {
        private static Connection instance = new Connection();
        private Semaphore semaphore = new Semaphore(10);
        private int connections = 0;

        private Connection() {
        }

        public static Connection getConnection() {
            return instance;
        }

        public void connect() {
            try {
                semaphore.acquire();
            } catch (Exception e) {
            }
            try {
                doConnect();
            } finally {
                semaphore.release();
            }
        }

        public void doConnect() {
            synchronized (this) {
                connections++;
                System.out.println("Current Connections : " + connections);
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            synchronized (this) {
                connections--;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 200; i++) {
            executorService.submit(() -> Connection.getConnection().connect());
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
