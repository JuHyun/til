package design.pattern.flyweight;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

public class FlyweightTest {

    @Test
    public void sameIntegeInstances() {
        // Default: -128 ~ 127 numbers are cached.
        assertSame(Integer.valueOf(-128), Integer.valueOf(-128));
        assertSame(Integer.valueOf(127), Integer.valueOf(127));

        assertNotSame(Integer.valueOf(128), Integer.valueOf(128));
        assertNotSame(Integer.valueOf(-200), Integer.valueOf(-200));
    }
}
