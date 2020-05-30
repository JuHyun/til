package chap15.thread;

import java.io.IOException;

public class TerminateThread extends Thread {

    private boolean flag = false;
    private int i = 0;

    public TerminateThread(String name) {
        super(name);
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void run() {
        while (!flag) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + " end!!");
    }

    public static void main(String[] args) throws IOException {
        System.out.println("START !!");
        TerminateThread apple = new TerminateThread("apple");
        TerminateThread kiwi = new TerminateThread("kiwi");

        apple.start();
        kiwi.start();

        int in;
        while (true) {
            in = System.in.read();
            if (in == 'A') {
                apple.setFlag(true);
            } else if (in == 'B') {
                kiwi.setFlag(true);
            } else if (in == 'Z') {
                apple.setFlag(true);
                kiwi.setFlag(true);
                break;
            }
//            else {
//                System.out.println("try again!! ");
//            }
            System.out.println("main end!!");
        }
    }
}
