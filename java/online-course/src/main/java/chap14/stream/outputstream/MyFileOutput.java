package chap14.stream.outputstream;

import java.io.FileOutputStream;
import java.io.IOException;

public class MyFileOutput {

    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("/Users/seongjuhyeon/workspace/til/java/online-course" +
                "/src/main/resources/output.txt", true)) {
            String hello = "hello";
            fos.write(hello.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
