package concurrency.executorsframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrintSomething implements Runnable {
    private String message;

    public PrintSomething(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - " + message);
    }
}

public class ThreadPoolRunner {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService = Executors.newSingleThreadExecutor();

        int totalNoOfProcessor = Runtime.getRuntime().availableProcessors();
        System.out.println(totalNoOfProcessor);
        ExecutorService executorService = Executors.newFixedThreadPool(totalNoOfProcessor);
        executorService.submit(new PrintSomething("Message 1"));
        executorService.submit(new PrintSomething("Message 2"));
        executorService.submit(new PrintSomething("Message 3"));
        executorService.submit(new PrintSomething("Message 4"));
        executorService.shutdown();
        System.out.println("Main thread");
    }
}
