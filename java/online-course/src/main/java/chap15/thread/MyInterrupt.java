package chap15.thread;

public class MyInterrupt extends Thread {

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("wake up!!!");
        }
    }

    public static void main(String[] args) {
        System.out.println("start!");
        MyInterrupt thread = new MyInterrupt();
        thread.start();
        thread.interrupt();
        System.out.println("end!");
    }
}
