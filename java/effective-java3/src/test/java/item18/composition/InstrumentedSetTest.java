package item18.composition;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.TreeSet;

class InstrumentedSetTest {

    @Test
    void addAll() {

        InstrumentedSet<String> s = new InstrumentedSet<>(new TreeSet<>());
        s.addAll(List.of("틱", "틱틱", "탁탁", "펑", "텅텅텅"));

        assertEquals(5, s.getAddCount());
    }
}
