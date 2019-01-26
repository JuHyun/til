package serialization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;

class PairTest {

    private static final String FILE_NAME = "serialization.test.log";

    @BeforeEach
    public void writeData() throws IOException {
        File file = getFile(FILE_NAME);
        final FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeInt(101);
        objectOutputStream.writeBoolean(true);
        objectOutputStream.writeUTF("this is a string.");

        objectOutputStream.writeObject(Pair.create(30, "Emily"));

        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();
    }

    @Test
    public void readData() throws IOException, ClassNotFoundException {
        File file = getFile(FILE_NAME);
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        final int number = objectInputStream.readInt();
        final boolean bool = objectInputStream.readBoolean();
        final String string = objectInputStream.readUTF();
        final Pair pair = (Pair) objectInputStream.readObject();

        assertEquals(101, number);
        assertTrue(bool);
        assertEquals("this is a string.", string);
        assertEquals(30, pair.getNumber());
        assertEquals("Emily", pair.getName());
    }

    private File getFile(String fileName) {
        URL resource = getUrl(fileName);
        return new File(resource.getFile());
    }

    private URL getUrl(String fileName) {
        final ClassLoader classLoader = getClass().getClassLoader();
        return classLoader.getResource(fileName);
    }
}
