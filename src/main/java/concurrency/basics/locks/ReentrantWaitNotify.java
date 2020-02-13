package concurrency.basics.locks;

import helper.Util;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantWaitNotify {

    private int cnt = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private void incrementCnt() {
        for (int i = 0; i < 100; i++) {
            System.out.println("increment call from " + Util.getCurrentThreadName());
            cnt++;
        }
    }

    private void firstThread() {
        lock.lock();
        System.out.println("Waiting");
        try {
            condition.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Woken up");

        try {
            System.out.println("Increment 1st");
            incrementCnt();
        } finally {
            lock.unlock();
        }
    }

    private void secondThread() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        lock.lock();

        System.out.println("Press Return");
        new Scanner(System.in).nextLine();
        System.out.println("Got Return key");
        condition.signal();
        try {
            System.out.println("Increment 2nd");
            incrementCnt();
        } finally {
            lock.unlock();
        }
    }

    private void finished() {
        System.out.println("Count is : " + cnt);
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantWaitNotify obj = new ReentrantWaitNotify();
        Thread t1 = new Thread(() -> obj.firstThread(), "Thread1");
        Thread t2 = new Thread(() -> obj.secondThread(), "Thread2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        obj.finished();
    }
}
