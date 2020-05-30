package chap14.stream.inputstream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyFileCopy {

    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("/Users/seongjuhyeon/workspace/til/java/online-course/src/main" +
                "/resources/a.zip");
             FileOutputStream fos = new FileOutputStream("copy.zip");
             BufferedInputStream bis = new BufferedInputStream(fis);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            long start = System.nanoTime();

            int i = 0;
            while ((i = bis.read()) != -1) {
                bos.write(i);
            }
            long end = System.nanoTime();
            System.out.println("time = " + (end - start) / 1000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
