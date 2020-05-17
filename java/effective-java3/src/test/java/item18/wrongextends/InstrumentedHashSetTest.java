package item18.wrongextends;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

class InstrumentedHashSetTest {

    @Test
    void addAll() {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        List<String> strings = List.of("틱", "틱틱", "탁탁", "펑", "텅텅텅");
        s.addAll(strings);

        assertEquals(5, s.getAddCount());
    }
}
