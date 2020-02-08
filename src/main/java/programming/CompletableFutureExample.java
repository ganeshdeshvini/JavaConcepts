package programming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> whatsYourNameFuture = CompletableFuture.supplyAsync(() -> {
           return "Ganesh";
        });

        CompletableFuture<String> greetingFuture = whatsYourNameFuture.thenApply(name -> {
            return "Hello " + name;
        });

        System.out.println(greetingFuture.get());
    }
}
