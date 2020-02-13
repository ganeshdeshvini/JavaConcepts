package concurrency.executorsframework;

import java.util.concurrent.*;

public class UsingExecutorService {
    static class PiCalculator implements Callable<Double> {

        @Override
        public Double call() throws Exception {
            double currVal = 1.0;
            double nextVal = 0.0;
            double denominator = 1.0;

            for (int i = 0; Math.abs(nextVal - currVal) > 0.000000001d; denominator += 2.0, i++) {
                currVal = nextVal;
                if (i % 2 == 1) {
                    nextVal = currVal - (1 / denominator);
                } else {
                    nextVal = currVal + (1 / denominator);
                }
            }
            return currVal * 4;
        }

    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        long startTime = System.currentTimeMillis();
        System.out.println("Before future call");
        Future<Double> future = executorService.submit(new PiCalculator());
        System.out.println("After future call");
        final double pi = future.get(10, TimeUnit.SECONDS);
        final long stopTime = System.currentTimeMillis();
        System.out.printf("Calculated Pi in %d milliseconds: %10.9f%n", stopTime - startTime, pi);
        System.out.println("After Calculated call");
        executorService.shutdown();
    }

}
