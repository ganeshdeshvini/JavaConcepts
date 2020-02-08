package java8.lambda.example2;

public class RunnableExample {
    public static void main(String[] args) {
        Thread myThread = new Thread(new Runnable() {
            @Override public void run() {
                System.out.println("Thread started :: Anonymous Inner class ");
            }
        });
        myThread.start();
        System.out.println("came here");

        Thread myLambdaThread = new Thread(() -> System.out.println("Thread started :: Lambda"));
        myLambdaThread.start();


    }
}
