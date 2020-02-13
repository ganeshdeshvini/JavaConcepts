package concurrency.executorsframework;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureExample {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Callable<Integer> callable = () -> {
			return 11;
		};
		Future<Integer> future = executorService.submit(callable);
		Future<Integer> future2 = executorService.submit(() -> {
			return 21;
		});
		executorService.shutdown();
		try {
			System.out.println("Future 1 : " + future.get());
			System.out.println("Future 2 : " + future2.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException executionException) {
			IOException ioException = (IOException) executionException.getCause();
			ioException.getMessage();
		}

	}

}
