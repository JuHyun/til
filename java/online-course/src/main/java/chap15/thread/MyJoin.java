package chap15.thread;

public class MyJoin extends Thread {

    private int start;
    private int end;
    private int total;

    public MyJoin(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i < end; i++) {
            total += i;
        }
    }

    public static void main(String[] args) {
        MyJoin join1 = new MyJoin(1, 50);
        MyJoin join2 = new MyJoin(51, 100);

        join1.start();
        join2.start();

        try {
            join1.join();
            join2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int total = join1.total + join2.total;
        System.out.println("join1  total = " + join1.total);
        System.out.println("join2  total = " + join2.total);
        System.out.println("total = " + total);
    }
}
