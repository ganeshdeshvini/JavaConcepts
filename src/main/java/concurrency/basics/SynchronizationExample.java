package concurrency.basics;

import static enumexample.AnsiColorEnum.getColorById;
import static helper.Util.getCurrentThread;

public class SynchronizationExample {
    static class WithoutSynchronization {
        void printNumbers() {
            for (int i = 1; i <= 10; i++) {
                System.out.println(getCurrentThread().getName() + i);
            }
        }
    }

    static class SynchronizationMethod {
        synchronized void printNumbers() {
            for (int i = 1; i <= 10; i++) {
                System.out.println(getCurrentThread().getName() + i);
            }
        }
    }

    static class SynchronizationBlock {
        void printNumbers() {
            synchronized (this) {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(getCurrentThread().getName() + i);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        withoutSynchronization();
        synchronizedMethod();
        synchronizedBlock();
    }

    private static void synchronizedBlock() {
        SynchronizationBlock synchronizationBlock = new SynchronizationBlock();
        new Thread(() -> synchronizationBlock.printNumbers(), getColorById(1)).start();
        new Thread(() -> synchronizationBlock.printNumbers(), getColorById(2)).start();
    }

    private static void synchronizedMethod() {
        SynchronizationMethod synchronizationMethod = new SynchronizationMethod();
        new Thread(() -> synchronizationMethod.printNumbers(), getColorById(1)).start();
        new Thread(() -> synchronizationMethod.printNumbers(), getColorById(2)).start();
    }

    private static void withoutSynchronization() {
        WithoutSynchronization withoutSynchronization = new WithoutSynchronization();
        new Thread(() -> withoutSynchronization.printNumbers(), getColorById(1)).start();
        new Thread(() -> withoutSynchronization.printNumbers(), getColorById(2)).start();
    }


}
