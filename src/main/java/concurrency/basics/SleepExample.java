package concurrency.basics;

import enumexample.AnsiColorEnum;

import java.util.concurrent.TimeUnit;

public class SleepExample {
    final static String THREAD_NAME1 = "Thead1";
    final static String THREAD_NAME2 = "Thead2";

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(getCurrentThreadColor() + i);
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(runnable, THREAD_NAME1).start();
        new Thread(runnable, THREAD_NAME2).start();
    }

    static String getCurrentThreadColor() {
        return getThreadColorByName(Thread.currentThread().getName());
    }

    static String getThreadColorByName(String threadName) {
        switch (threadName) {
            case THREAD_NAME1:
                return AnsiColorEnum.ANSI_BLUE.getColor();
            case THREAD_NAME2:
                return AnsiColorEnum.ANSI_GREEN.getColor();
            default:
                return AnsiColorEnum.ANSI_BLACK.getColor();
        }
    }
}
