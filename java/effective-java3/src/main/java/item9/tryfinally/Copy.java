package item9.tryfinally;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Copy {

    private static final int BUFFER_SIZE = 8 * 1024;

    static void copy(String src, String dest) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dest);
            try {
                byte[] bytes = new byte[BUFFER_SIZE];
                int n;
                while ((n = in.read(bytes)) >= 0) {
                    out.write(bytes, 0, n);
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    static void betterCopy(String src, String dest) throws IOException {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dest)) {
            byte[] bytes = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(bytes)) >= 0) {
                out.write(bytes, 0, n);
            }
        }
    }
}
