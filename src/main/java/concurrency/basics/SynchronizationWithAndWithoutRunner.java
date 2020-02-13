package concurrency.basics;

public class SynchronizationWithAndWithoutRunner {
    static class CallMe {
        // Uncomment for synchronized
//         synchronized void call(String msg) {
        void call(String msg) {
            System.out.print("[" + msg);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("]");
        }
    }

    static class Caller implements Runnable {
        String msg;
        CallMe target;
        Thread t;

        public Caller(CallMe targ, String s) {
            target = targ;
            msg = s;
            t = new Thread(this);
            t.start();
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub
            target.call(msg);
        }
    }

    public static void main(String args[]) {
        CallMe target = new CallMe();
        Caller ob1 = new Caller(target, "Hello");
        Caller ob2 = new Caller(target, "Synchronized");
        Caller ob3 = new Caller(target, "World");
        // wait for threads to end
        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
