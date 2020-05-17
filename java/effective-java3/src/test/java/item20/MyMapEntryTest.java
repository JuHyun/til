package item20;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.AbstractMap;

class MyMapEntryTest {

    @Test
    public void test() {
        MyMapEntry entry = new MyMapEntry(new AbstractMap.SimpleEntry("Korean", String.valueOf("standard")));
        entry.setValue(String.valueOf("no.1")
        );
        assertEquals(String.valueOf("no.1"), entry.getValue());

    }
}
