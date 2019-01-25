package javaeight;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@DisplayName("Java8 Testing")
class JavaEightTest {

    @Nested
    @DisplayName("Comparing map and flatMap")
    class MapAndFlatMapComparing {

        @Test
        public void map() {
            // map :: Stream T -> (T -> R) -> Stream R
            Stream<Stream<Integer>> streamStream = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(10, 20, 30))
                    .map(number -> number.stream());
            List<Stream<Integer>> collect1 = streamStream.collect(Collectors.toList());
            collect1.stream().forEach(System.out::println);
        }

        @Test
        public void flatMap() {
            // flatMap :: Stream T -> (T -> Stream R) -> Stream R
            Stream<Integer> integerStream = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(10, 20, 30))
                    .flatMap(number -> number.stream());
            List<Integer> collect = integerStream.collect(Collectors.toList());
            collect.stream().forEach(System.out::println);
        }

        @Test
        public void doubled() {
            Stream<Integer> integerStream = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(10, 20, 30))
                    .flatMap(number -> number.stream())
                    .map(number -> number * 10);
            List<Integer> collect = integerStream.collect(Collectors.toList());
            collect.stream().forEach(System.out::println);
        }
    }

    @Test
    public void fileReadToStream() throws IOException {
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/revelator_eyes.log");
        StringBuilder stringBuilder = new StringBuilder();
        InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream, Charset.forName("UTF-8"));
        try (Reader reader = new BufferedReader(inputStreamReader)) {
            int c = 0;
            while ((c = reader.read()) != -1) {
                stringBuilder.append((char) c);
            }
        }

        System.out.println(stringBuilder.toString());
    }
}
