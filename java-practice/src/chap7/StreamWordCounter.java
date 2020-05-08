package chap7;

import java.util.stream.Stream;

public class StreamWordCounter {

    private final int counter;

    private final boolean lastSpace;

    public StreamWordCounter(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    public StreamWordCounter accumulate(Character c) {
        if (Character.isWhitespace(c)) {
            return lastSpace ? this : new StreamWordCounter(counter, true);
        }
        return lastSpace ? new StreamWordCounter(counter + 1, false) : this;
    }

    public StreamWordCounter combine(StreamWordCounter streamWordCounter) {
        return new StreamWordCounter(counter + streamWordCounter.counter, streamWordCounter.lastSpace);
    }

    public int getCounter() {
        return counter;
    }

    public static int countWords(Stream<Character> stream) {
        StreamWordCounter streamWordCounter = stream.reduce(new StreamWordCounter(0, true),
                StreamWordCounter::accumulate,
                StreamWordCounter::combine);

        return streamWordCounter.getCounter();
    }
}
