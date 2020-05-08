package chap7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamWordCounterTest {

    private static final String SENTENCE = "Nel mezzo  del cammin  di nostra  vita mi ritrovai in una  selva oscura  " +
            "ch  la dritta  via era  smarrita ";

    @Test
    public void test() {
        Stream<Character> stream = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);
        int countW = StreamWordCounter.countWords(stream);
        assertEquals(19, countW);
    }

    @Test
    public void parallelTest() {
        Stream<Character> stream = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);
        int countW = StreamWordCounter.countWords(stream.parallel());
        assertEquals(19, countW);
    }

    @Test
    public void test2() {
        Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> stream = StreamSupport.stream(spliterator, true);

        int count = StreamWordCounter.countWords(stream);
        System.out.println(count);
    }
}
