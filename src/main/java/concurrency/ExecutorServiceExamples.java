package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExamples {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executeMethod = Executors.newSingleThreadExecutor();
        executeMethod.execute(() -> System.out.println("Running in execute()"));
        System.out.println("In execute main thread");
        executeMethod.shutdown();

        ExecutorService submitMethod = Executors.newSingleThreadExecutor();
        Future<?> future = submitMethod.submit(() -> System.out.println("Running in submit()"));
        if (future.get() == null) {
            System.out.println("Finished");
        } else {
            System.out.println("Running");
        }
        System.out.println("In submit main thread");

        ExecutorService callableSubmitMethod = Executors.newSingleThreadExecutor();
        Future<String> futureCallable = callableSubmitMethod.submit(new Callable<String>() {
            public String call() {
                return "Callable";
            }
        });
        System.out.println(futureCallable.get());

        new Thread(() -> System.out.println()).start();
    }
}
