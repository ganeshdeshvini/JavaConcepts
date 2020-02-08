package programming;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
    private static ExecutorService pool = Executors.newFixedThreadPool(10);
    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        doSomeTask();
        Future<String> contentsFuture = doSomeTaskInBackground();
        doSomeOtherTask();

        System.out.print("Waiting for Download");
        while (!contentsFuture.isDone()) {
            System.out.print(".");
            //            askUserToWait();
            //            doSomeComputationInTheMeantime();
            Thread.sleep(100);
        }
        contentsFuture.get();
        pool.shutdown();
    }

    static void doSomeTask(){
        System.out.println("Doing some task");
    }

    static void doSomeOtherTask(){
        System.out.println("Doing some other task");
    }

    static Future<String> doSomeTaskInBackground() throws ExecutionException, InterruptedException, IOException {
        System.out.println("Doing some other task in background");
//        String url = "https://dzone.com/articles/javautilconcurrentfuture";
        String url = "https://www.callicoder.com/java-8-completablefuture-tutorial/";
        return startDownloading(new URL(url));
    }

    static Future<String> startDownloading(final URL url) throws IOException {

        return pool.submit(() -> {
            try (InputStream input = url.openStream()) {
                return IOUtils.toString(input, StandardCharsets.UTF_8);
            }
        });
    }
}
