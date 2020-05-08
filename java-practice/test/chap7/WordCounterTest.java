package chap7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WordCounterTest {

    private static final String SENTENCE = "Nel mezzo  del cammin  di nostra  vita mi ritrovai in una  selva oscura  " +
            "ch  la dritta  via era  smarrita ";

    @Test
    public void countWordsIteratively() {
        int count = WordCounter.countWordsIteratively(SENTENCE);
        assertEquals(19, count);
    }
}
