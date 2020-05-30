package main.java.chap14.stream.inputstream;

import java.io.IOException;
import java.io.InputStreamReader;

public class MySystemInput {

    public static void main(String[] args) {
        System.out.println("Hello");

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            int read;
            while ((read = inputStreamReader.read()) != '\n') {
                System.out.print((char) read);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
