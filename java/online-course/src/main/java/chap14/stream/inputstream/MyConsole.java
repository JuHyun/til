package main.java.chap14.stream.inputstream;

import java.io.Console;

public class MyConsole {

    public static void main(String[] args) {
        Console console = System.console();
        System.out.println("name:");
        String name = console.readLine();
        System.out.println("password:");
        char[] password = console.readPassword();
        System.out.println(name + " : " + password);
    }
}
