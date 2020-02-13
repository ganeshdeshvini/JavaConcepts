package concurrency.executorsframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadPoolExecutor {
    static class Task implements Runnable {
        private String name;

        Task(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " Start. Command = " + name);
            processCommand();
            System.out.println(Thread.currentThread().getName() + " End.");
        }

        private void processCommand() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            Runnable worker = new Task("Task" + i);
            executorService.execute(worker);
        }
        executorService.shutdown();
        while (executorService.isTerminated()) {

        }
        System.out.println("All thread finished");
    }

}
