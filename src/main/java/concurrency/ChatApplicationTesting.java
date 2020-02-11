package concurrency;

public class ChatApplicationTesting {

    public static void main(String[] args) {
        Chat c = new Chat();
        Thread1 objT1 = new Thread1(c);
        Thread2 objT2 = new Thread2(c);
    }

    static class Thread1 implements Runnable {
        Chat c;
        String[] arrStr = {"1", "3"};

        Thread1(Chat c) {
            this.c = c;
            new Thread(this, "Question").start();
        }

        public void run() {
            for (String str : arrStr) {
                c.question(str);
            }
        }
    }

    static class Thread2 implements Runnable {
        Chat c;
        String[] arrStr = {"2", "4"};

        Thread2(Chat c) {
            this.c = c;
            new Thread(this, "Answer").start();
        }

        public void run() {
            for (String str : arrStr) {
                c.answer(str);
            }
        }
    }

    static class Chat {
        boolean isQuestionDone = false;

        public synchronized void question(String msg) {
            if (isQuestionDone) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println(msg);
            isQuestionDone = true;
            notify();
        }

        public synchronized void answer(String msg) {
            if (!isQuestionDone) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println(msg);
            isQuestionDone = false;
            notify();
        }
    }
}
