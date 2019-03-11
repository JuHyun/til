package design.pattern.flyweight;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    public void checkStringInternPool() {
        final String string1 = new String("abcd");
        final String string2 = new String("abcd");
        final String stringLiteral1 = "abcd";
        final String stringLiteral2 = "abcd";

        assertTrue(string1.equals(string2));
        assertTrue(string1.equals(stringLiteral1));
        assertFalse(string1 == string2);

        assertFalse(string1 == stringLiteral1);
        assertTrue(stringLiteral1.equals(stringLiteral2));
        assertTrue(stringLiteral1 == stringLiteral2);
    }
}
