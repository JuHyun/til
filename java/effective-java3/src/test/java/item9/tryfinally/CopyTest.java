package item9.tryfinally;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class CopyTest {

    private ClassLoader classLoader;

    @BeforeEach
    void setUp() {
        classLoader = getClass().getClassLoader();
    }

    @Test
    void copy() throws IOException {
        String fileFullPath = getFileFullPath("sample.txt");
        Copy.copy(fileFullPath, "/Users/seongjuhyeon/workspace/til/java/effective-java3/src" +
                "/test/resources/dest.txt");

        String destFileFullPath = getFileFullPath("dest.txt");
        assertNotNull(destFileFullPath);
    }

    @Test
    void betterCopy() throws IOException {
        String fileFullPath = getFileFullPath("sample.txt");
        Copy.betterCopy(fileFullPath, "/Users/seongjuhyeon/workspace/til/java/effective-java3/src" +
                "/test/resources/better_dest.txt");

        String destFileFullPath = getFileFullPath("better_dest.txt");
        assertNotNull(destFileFullPath);
    }

    private String getFileFullPath(String fileName) {
        return classLoader.getResource(fileName).getFile();
    }
}
