package algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringUpdateTest {

    @Test
    public void success() {
        List<Object> actual1 = StringUpdate.update(Arrays.asList("abc", "a", "ab", "zyxwt"), value -> value + value.length());
        assertEquals(Arrays.asList("abc3", "a1", "ab2", "zyxwt5"), actual1);

        List<Object> actual2 = StringUpdate.update(Arrays.asList("abc", "a", "ab", "zyxwt"), value -> value.length());
        assertEquals(Arrays.asList(3, 1, 2, 5), actual2);
    }

}