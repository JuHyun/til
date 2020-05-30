package chap14.stream.inputstream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyDataInputStream {

    public static void main(String[] args) {
        String fileName = "/Users/seongjuhyeon/workspace/til/java/online-course/src/main/resources/data.txt";
        try (FileOutputStream fos = new FileOutputStream(fileName, true);
             DataOutputStream dos = new DataOutputStream(fos);
             FileInputStream fis = new FileInputStream(fileName);
             DataInputStream dis = new DataInputStream(fis)) {
            dos.writeByte(100);
            dos.write(36);
            dos.writeChar('A');
            dos.writeUTF("안녕하세요, 한국에 오신 걸 환영합니다.");

            System.out.println(dis.readByte());
            System.out.println(dis.readByte());
            System.out.println(dis.readChar());
            System.out.println(dis.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
