package concurrency.basics;

import enumexample.AnsiColorEnum;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchRunner {
    static class Service1 implements Runnable {
        private CountDownLatch countDownLatch;

        public Service1(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println(AnsiColorEnum.getColorById(1) + "Service1::Completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }
    }

    static class Service2 implements Runnable {
        private CountDownLatch countDownLatch;

        public Service2(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println(AnsiColorEnum.getColorById(2) + "Service2::Completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int numberOfServices = 2;
        CountDownLatch countDownLatch = new CountDownLatch(numberOfServices);
        Service1 service1 = new Service1(countDownLatch);
        Service2 service2 = new Service2(countDownLatch);
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);
        executorService.execute(service1);
        executorService.execute(service2);
        countDownLatch.await(5, TimeUnit.SECONDS);
        System.out.println(AnsiColorEnum.ANSI_RESET.getColor() + "Inside Main method Countdown completed");
        executorService.shutdown();
    }
}
