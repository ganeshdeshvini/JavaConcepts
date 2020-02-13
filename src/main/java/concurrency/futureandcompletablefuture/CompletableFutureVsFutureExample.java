package concurrency.futureandcompletablefuture;

import enumexample.AnsiColorEnum;
import helper.Util;

import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CompletableFutureVsFutureExample {
    private static class Task {
        private int id;

        public Task(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public int processAndReturn() throws InterruptedException {
            TimeUnit.MILLISECONDS.sleep(50);
            return id;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        futureExample(executorService);
        completableFutureExample(executorService);

        executorService.shutdown();
        executorService.awaitTermination(2, TimeUnit.SECONDS);
    }

    private static void futureExample(ExecutorService executorService) throws ExecutionException, InterruptedException {
        Map<Long, AnsiColorEnum> mapThreadIdColorName = new ConcurrentHashMap<>();
        AtomicInteger colorCnt = new AtomicInteger(0);
        System.out.println("========Before For Loop========");
        for (int i = 0; i < 10; i++) {
            Task task = new Task(i);
            System.out.println(AnsiColorEnum.ANSI_RESET.getColor() + "Submitting Task with ID: " + i);
            Future<Integer> future = executorService.submit(() -> {
                long currentThreadId = Util.getCurrentThreadId();
                AnsiColorEnum ansiColorEnum = mapThreadIdColorName.computeIfAbsent(currentThreadId, aLong -> AnsiColorEnum.getAnsiColorEnumById(colorCnt.getAndIncrement()));
                System.out.println(String.format("%s Task: %d %s ThreadId: %d", ansiColorEnum.getColor(), task.getId(), ansiColorEnum.name(), currentThreadId));
                return task.processAndReturn();
            });
            //This will get Blocked until a Result is Obtained, due to which cannot simulate async operation
            System.out.println("Post Processing for Task: " + future.get());
        }
        System.out.println("========After For Loop========");
    }

    private static void completableFutureExample(ExecutorService executorService) throws ExecutionException, InterruptedException {
        System.out.println(AnsiColorEnum.ANSI_RESET.getColor() + "\n\n Completable Future------\n\n");
        Map<Long, AnsiColorEnum> mapThreadIdColorName = new ConcurrentHashMap<>();
        AtomicInteger colorCnt = new AtomicInteger(0);
        System.out.println("========Before For Loop========");
        for (int i = 0; i < 10; i++) {
            Task task = new Task(i);
            System.out.println(AnsiColorEnum.ANSI_RESET.getColor() + "Submitting Task with ID: " + i);
            CompletableFuture.supplyAsync(() -> {
                long currentThreadId = Util.getCurrentThreadId();
                AnsiColorEnum ansiColorEnum = mapThreadIdColorName.computeIfAbsent(currentThreadId, aLong -> AnsiColorEnum.getAnsiColorEnumById(colorCnt.getAndIncrement()));
                System.out.println(String.format("%s Task: %d %s ThreadId: %d", ansiColorEnum.getColor(), task.getId(), ansiColorEnum.name(), currentThreadId));
                return task.getId();
            }, executorService).thenAccept((taskId) -> {
                System.out.println(mapThreadIdColorName.get(Util.getCurrentThreadId()).getColor() + "Post Processing for Task: " + taskId);
            });
        }
        System.out.println("========After For Loop========");
    }
}
