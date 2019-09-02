package javaeight.stream.seven;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CustomSpliteratorTest {

    private static final String SENTENCE = " Nel  mezzo del cammin    di nostra  vita  " +
            "mi     ritrovai in una     selva oscura" +
            " ch la dritta  via era    smarrita";

    @Test
    public void countWordsIteratively() {
        assertEquals(19, CustomSpliterator.countWordsIteratively(SENTENCE));
    }

    @Test
    public void countWordsStream() {
        Stream<Character> stream = IntStream.range(0, SENTENCE.length())
                .mapToObj(SENTENCE::charAt);

        assertEquals(19, WordCounter.countWords(stream));
    }

    @Test
    public void countWordsParallelStream() {
        Stream<Character> stream = IntStream.range(0, SENTENCE.length())
                .parallel()
                .mapToObj(SENTENCE::charAt);

        assertEquals(19, WordCounter.countWords(stream));
    }
}
