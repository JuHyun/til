package chap15.thread;

import java.util.ArrayList;
import java.util.List;

public class LibraryMain {

    public static Library library = new Library();

    public static void main(String[] args) {
        System.out.println("main start!");
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        Student student6 = new Student();
        Student student5 = new Student();
        Student student4 = new Student();

        student1.start();
        student2.start();
        student3.start();
        student4.start();
        student5.start();
        student6.start();

        System.out.println("main end!");
    }
}

class Student extends Thread {
    public void run() {
        try {
            String lendBook = LibraryMain.library.lendBook();
            sleep(3000);
            LibraryMain.library.returnBook(lendBook);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Library {

    public List<String> books = new ArrayList<>();

    public Library() {
        books.add("books1");
        books.add("books2");
        books.add("books3");
//        books.add("books4");
//        books.add("books5");
//        books.add("books6");
//        books.add("books7");
//        books.add("books8");
//        books.add("books9");
//        books.add("books10");
    }

    public synchronized String lendBook() throws InterruptedException {
        Thread t = Thread.currentThread();

        while (books.size() == 0) {
            System.out.println(t.getName() + " is waiting...");
            wait();
            System.out.println(t.getName() + " is borrowed...");
        }
        String book = books.remove(0);
        System.out.println(t.getName() + " borrowed " + book);
        return book;
    }

    public synchronized String returnBook(String title) {
        Thread t = Thread.currentThread();
        books.add(title);
        notifyAll();

        System.out.println(t.getName() + " returned " + title);
        return title;
    }
}
