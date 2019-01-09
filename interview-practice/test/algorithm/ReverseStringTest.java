package algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseStringTest {

    @Test
    public void success() {
        assertEquals("olleh", ReverseString.reverse("hello"));
    }
}