package concurrency.executorsframework;

import enumexample.AnsiColorEnum;
import helper.Util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorServiceExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorExecuteMethod(executorService);

        executorService.shutdown();
        executorService.awaitTermination(2, TimeUnit.SECONDS);
    }

    private static void executorExecuteMethod(ExecutorService executorService) {
        Map<Long, AnsiColorEnum> mapThreadIdColorName = new ConcurrentHashMap<>();
        AtomicInteger colorCnt = new AtomicInteger(0);
        for (int i = 0; i < 50; i++) {
            Task task = new Task(i);
            executorService.execute(() -> {
                AnsiColorEnum ansiColorEnum = mapThreadIdColorName.putIfAbsent(Util.getCurrentThreadId(), AnsiColorEnum.getAnsiColorEnumById(colorCnt.getAndIncrement()));
                System.out.println(String.format("%s Task: %d %s", ansiColorEnum.getColor(), task.getId(), ansiColorEnum.name()));
            });
        }
    }

    private static class Task {
        private int id;

        public Task(int id) {
        }

        public int getId() {
            return id;
        }
    }
}
