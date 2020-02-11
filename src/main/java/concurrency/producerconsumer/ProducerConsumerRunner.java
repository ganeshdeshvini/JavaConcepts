package concurrency.producerconsumer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ProducerConsumerRunner {
    public static void main(String[] args) {
        Message message = new Message();
        ProducerWriter producerWriter = new ProducerWriter(message);
        ConsumerReader consumerReader = new ConsumerReader(message);
    }
}

class Message {
    private String text;
    private boolean isEmpty = true;

    synchronized String read(){
        System.out.print("Waiting for contents to read: ");
        while (isEmpty) {
            System.out.print(".");
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        String message = this.text;
        isEmpty = true;
        return message;
    }

    synchronized void write() {
        System.out.print("Waiting for contents to write: ");
        while (!isEmpty) {
            System.out.print(".");
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        this.text = "Writing: " + new Random().nextInt(100);
        isEmpty = false;
    }
}

class ProducerWriter implements Runnable {
    private Message message;

    public ProducerWriter(Message message) {
        this.message = message;
    }

    @Override
    public void run() {

    }
}

class ConsumerReader implements Runnable {
    private Message message;

    public ConsumerReader(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        message.read();
    }
}

