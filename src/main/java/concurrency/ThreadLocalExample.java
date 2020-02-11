package concurrency;

import helper.ThreadColors;
import helper.Util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * If we don't use ThreadLocal then there will be total poolsize*4 objects of SimpleDateFormat(or any Non-ThreadSafe)
 * but we can reuse the same using ThreadLocal, which ensures that the object creation will be
 * depending on the PoolSize, so in this case there will be only 5 objects created & each thread will have
 * its own copy of SimpleDateFormat(or any non-threadSafe) object
 */
public class ThreadLocalExample {
    static Map<Long, String> threadIdColorMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        int poolSize = 5;
        int totalObject = poolSize * 4;
        ExecutorService threadPool = Executors.newFixedThreadPool(poolSize);
        AtomicInteger colorCnt = new AtomicInteger(0);
        BirthDateGenerator birthDateGenerator = new BirthDateGenerator();
        for (int i = 0; i < totalObject; i++) {
            threadPool.submit(() -> {
                long currentThreadId = Util.getCurrentThreadId();
                if (!threadIdColorMap.containsKey(currentThreadId)) {
                    threadIdColorMap.put(currentThreadId, ThreadColors.colors[colorCnt.getAndIncrement()]);
                }
                System.out.println(threadIdColorMap.get(currentThreadId) + birthDateGenerator.getBirthDate() + " from Thread: " + currentThreadId);
            });
        }
        threadPool.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("\n\n" + ThreadColors.ANSI_RESET + "Map count: " + threadIdColorMap.size());
        threadIdColorMap.forEach((key, value) -> System.out.println(value + "key: " + key));
        threadPool.shutdown();
    }

    private static class ThreadSafeWrapper {
        public static ThreadLocal<SimpleDateFormat> simpleDateFormat = ThreadLocal.withInitial(() -> {
            System.out.println(getCurrentThreadColor() + "Creating SimpleDateFormatObject");
            return new SimpleDateFormat("yyyy-MM-dd");
        });
    }

    private static class BirthDateGenerator {
        public String getBirthDate() {
            Date randomDate = Util.getRandomDate();
            return ThreadSafeWrapper.simpleDateFormat.get().format(randomDate);
        }
    }

    public static String getCurrentThreadColor() {
        return threadIdColorMap.get(Util.getCurrentThreadId());
    }
}

