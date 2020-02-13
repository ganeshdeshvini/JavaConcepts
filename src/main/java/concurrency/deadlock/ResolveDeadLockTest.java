package concurrency.deadlock;


public class ResolveDeadLockTest {
    static class ResourceA {
        int a = 10;
    }

    static class ResourceB {
        int b = 20;
    }

    public static void main(String[] args) {
        ResourceA resourceA = new ResourceA();
        ResourceB resourceB = new ResourceB();

        new Thread(() -> {
            synchronized (resourceA) {
                System.out.println("Thread1 ResourceA");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resourceB) {
                    System.out.println("Thread1 ResourceB");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (resourceB) {
                System.out.println("Thread2 ResourceB");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resourceA) {
                    System.out.println("Thread2 ResourceA");
                }
            }
        }).start();
    }
}
