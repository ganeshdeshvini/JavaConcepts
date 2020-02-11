package helper;

import java.util.Date;
import java.util.Random;

public class Util {
    public static Date getRandomDate() {
        return new Date(-946771200000L + (Math.abs(new Random().nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000)));
    }

    public static long getCurrentThreadId() {
        return Thread.currentThread().getId();
    }
}
