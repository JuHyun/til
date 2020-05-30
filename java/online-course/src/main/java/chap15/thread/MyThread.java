package chap15.thread;

import static java.lang.Thread.sleep;

import java.util.stream.IntStream;

public class MyThread {

    public static void main(String[] args) {
        System.out.println("start!!");
//        CustomExThread cthread1 = new CustomExThread();
//        CustomExThread cthread2 = new CustomExThread();
//
//        cthread1.start();
//        cthread2.start();
//
//        Thread thread1 = new Thread(new CustomInfThread());
//        Thread thread2 = new Thread(new CustomInfThread());
//
//        thread1.start();
//        thread2.start();

        Thread thread = Thread.currentThread();
        System.out.println(thread);

        System.out.println("end!!");
    }
}

class CustomExThread extends Thread {

    public void run() {
        IntStream.rangeClosed(0, 10000).forEach(i -> {
            System.out.println(i);
            if (i / 10 == 0) {
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

class CustomInfThread implements Runnable {

    @Override
    public void run() {
        IntStream.rangeClosed(0, 10000).forEach(i -> {
            System.out.println(i);
            if (i / 10 == 0) {
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
