package chap15.thread;

import static java.lang.Thread.sleep;

public class MySynchronization {

    public static Bank MY_BANK = new Bank();

    public static void main(String[] args) {
        Husband husband = new Husband();
        Wife wife = new Wife();

        husband.start();
        wife.start();

        System.out.println("balance = " + MySynchronization.MY_BANK.getBalance());
    }
}

class Husband extends Thread {
    public void run() {
        System.out.println("withdraw money start!!" + MySynchronization.MY_BANK.getBalance());
        MySynchronization.MY_BANK.withdrawal(1000);

        System.out.println("withdraw money end!! " + MySynchronization.MY_BANK.getBalance());
    }
}

class Wife extends Thread {

    public void run() {
        System.out.println("save money start!!" + MySynchronization.MY_BANK.getBalance());
        MySynchronization.MY_BANK.save(10000);

        System.out.println("save money end!! " + MySynchronization.MY_BANK.getBalance());
    }
}

class Bank {
    private int balance = 10000;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void save(int money) {
        synchronized (this) {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setBalance(this.balance + money);
        }
    }

    public void withdrawal(int money) {
        synchronized (this) {
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setBalance(this.balance - money);
        }
    }
}
