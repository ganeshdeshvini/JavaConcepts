package concurrency;

import enumexample.ColorAnsiEnum;
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
        Map<Long, ColorAnsiEnum> mapThreadIdColorName = new ConcurrentHashMap<>();
        AtomicInteger colorCnt = new AtomicInteger(0);
        for (int i = 0; i < 50; i++) {
            Task task = new Task(i);
            executorService.execute(() -> {
                long currentThreadId = Util.getCurrentThreadId();
                if (!mapThreadIdColorName.containsKey(currentThreadId)) {
                    mapThreadIdColorName.put(currentThreadId, ColorAnsiEnum.getById(colorCnt.getAndIncrement()));
                }
                ColorAnsiEnum colorAnsiEnum = mapThreadIdColorName.get(currentThreadId);
                System.out.println(String.format("%s Task: %d %s", colorAnsiEnum.getColor(), task.getId(), colorAnsiEnum.name()));
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
