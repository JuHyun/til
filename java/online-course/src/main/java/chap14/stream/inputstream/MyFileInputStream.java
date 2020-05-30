package chap14.stream.inputstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

public class MyFileInputStream {

    public static void main(String[] args) {
        ClassLoader classLoader = new MyFileInputStream().getClass().getClassLoader();
        URL resource = classLoader.getResource("input.txt");
        try (FileInputStream fis = new FileInputStream(resource.getFile())) {
            int i = 0;
            while ((i = fis.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
