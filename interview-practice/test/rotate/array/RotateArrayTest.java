package rotate.array;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RotateArrayTest {

    @Test
    public void shouldRotate() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};

        int[] result = RotateArray.rotate(array, 3);
        int[] expected = {5, 6, 7, 1, 2, 3, 4};

        assertArrayEquals(result, expected);
        assertArrayEquals(RotateArray.rotate(new int[]{}, 0), new int[]{});
        assertArrayEquals(RotateArray.rotate(array, array.length + 1), new int[]{7, 1, 2, 3, 4, 5, 6});
    }
}