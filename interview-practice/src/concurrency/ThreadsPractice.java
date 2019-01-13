package concurrency;

public class ThreadsPractice {

    public static void main(String[] args) throws InterruptedException {
        final Thread seperatedThread = new Thread(new ThreadPrinter());
        seperatedThread.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("From the main thread:" + Thread.currentThread().getName());
            Thread.sleep(1000);
        }
    }
}
