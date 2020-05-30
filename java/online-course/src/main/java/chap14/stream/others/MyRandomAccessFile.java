package chap14.stream.others;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class MyRandomAccessFile {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "/Users/seongjuhyeon/workspace/til/java/online-course/src/main/resources/random.txt";
        try (RandomAccessFile accessFile = new RandomAccessFile(fileName, "rw")) {
            accessFile.write(100);
            System.out.println(accessFile.getFilePointer());
            accessFile.writeChar('A');
            System.out.println(accessFile.getFilePointer());
            accessFile.writeUTF("안녕하세요, 저는 파일을 쓰고 있습니다...");
            System.out.println(accessFile.getFilePointer());

            accessFile.seek(0);
            int read = accessFile.read();
            char c = accessFile.readChar();
            String s = accessFile.readUTF();

            System.out.println(read);
            System.out.println(c);
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
