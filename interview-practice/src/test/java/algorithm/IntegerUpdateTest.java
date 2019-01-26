package algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegerUpdateTest {

    @Test
    public void integerUpdate() {
        List<Object> actual1 = IntegerUpdate.update(Arrays.asList(1, 3, 5, 7, 10), value -> value + 1);
        assertEquals(Arrays.asList(2, 4, 6, 8, 11), actual1);

        List<Object> actual2 = IntegerUpdate.update(Arrays.asList(1, -3, -5, 7, -10), value -> Math.abs(value));
        assertEquals(Arrays.asList(1, 3, 5, 7, 10), actual2);

        List<Object> actual3 = IntegerUpdate.update(Arrays.asList(1, 3, 5, 7), value -> {
            StringBuilder stringBuilder = new StringBuilder(value);
            for (int i = 0; i < value; i++) {
                stringBuilder.append(value);
            }
            return stringBuilder.toString();
        });
        assertEquals(Arrays.asList("1", "333", "55555", "7777777"), actual3);
    }
}