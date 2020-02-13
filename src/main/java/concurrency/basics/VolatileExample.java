package concurrency.basics;

import java.util.Scanner;


public class VolatileExample {
    static class Processor implements Runnable {

        // private boolean isRunning = true;
        // making it volatile as Java might keep cache copy for Thread for
        // optimization purpose
        // so in some system the value might not get reflected, hence making
        // variable volatile
        // guarantees the program to use the updated copy rather than cached copy
        private volatile boolean isRunning = true;

        @Override
        public void run() {
            while (isRunning) {
                System.out.println("Hare Krsna");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        void shutDown() {
            isRunning = false;
        }
    }

    public static void main(String[] args) {
        Processor processor = new Processor();
        Thread thread1 = new Thread(processor);
        thread1.start();

        System.out.println("Press Enter key0++" + " to shutdown...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        processor.shutDown();
        scanner.close();
    }
}
