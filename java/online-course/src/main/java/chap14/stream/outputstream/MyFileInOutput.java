package chap14.stream.outputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class MyFileInOutput {

    public static void main(String[] args) {
        ClassLoader classLoader = MyFileInOutput.class.getClassLoader();
        URL resource = classLoader.getResource("alpha.txt");

        try (FileOutputStream fos = new FileOutputStream("/Users/seongjuhyeon/workspace/til/java/online-course/src/main" +
                "/resources/alpha.txt", true);
             FileInputStream fis = new FileInputStream(resource.getFile())) {
            fos.write(byteData());

            int ch;
            while ((ch = fis.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[] byteData() {
        byte data = 65;
        byte[] bs = new byte[26];
        for (int i = 0; i < bs.length; i++) {
            bs[i] = data;
            data++;
        }
        return bs;
    }
}
