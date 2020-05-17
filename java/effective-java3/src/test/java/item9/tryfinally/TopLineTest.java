package item9.tryfinally;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class TopLineTest {

    private ClassLoader classLoader;

    @BeforeEach
    void setUp() {
        classLoader = getClass().getClassLoader();
    }

    @Test
    void firstLineOfFile() throws IOException {
        String file = getFileFullPath("sample.txt");
        String firstLine = TopLine.firstLineOfFile(file);

        assertEquals("hello, this is sample file.", firstLine);
    }

    @Test
    void better_firstLineOfFile() throws IOException {
        String file = getFileFullPath("sample.txt");
        String firstLine = TopLine.betterFirstLineOfFile(file);

        assertEquals("hello, this is sample file.", firstLine);
    }

    @Test
    void betterFirstLineOfFileWithCatch() {
        String file = getFileFullPath("sample.txt");
        String firstLine = TopLine.betterFirstLineOfFileWithCatch(file, "error occurs!!!");

        assertEquals("hello, this is sample file.", firstLine);
    }

    private String getFileFullPath(String fileName) {
        return classLoader.getResource(fileName).getFile();
    }
}
