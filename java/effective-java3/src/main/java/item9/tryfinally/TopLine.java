package item9.tryfinally;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLine {

    // 기기에 물리적인 문제가 생기면, readLine 메서드가 예외를 던지고, 같은 이유로 close 메서드도 실패한다.
    // 이런 상황이면, 두 번째 예외가 첫 번째 예외를 완전히 집어삼켜 버린다.
    // 그러면 스택 ㅊ적 내역에 첫 번째 예외에 관한 정보는 남지 않게 되어, 실제 시스템에서의 디버깅을 몹시 어렵게 만든다.
    public static String firstLineOfFile(String path) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        try {
            return bufferedReader.readLine();
        } finally {
            bufferedReader.close();
        }
    }

    // try-with-resources
    public static String betterFirstLineOfFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    public static String betterFirstLineOfFileWithCatch(String path, String defaultValue) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        } catch (IOException e) {
            return defaultValue;
        }
    }
}
