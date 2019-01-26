import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class TwoSumTest {

    @Test
    public void findTwoSum() {
        int[] indices = TwoSum.findTwoSum(new int[]{1, 3, 5, 3, 9}, 5);
        assertNull(indices);

        int[] indices2 = TwoSum.findTwoSum(new int[]{1, 3, 5, 3, 9}, 6);
        assertArrayEquals(new int[]{0, 1}, indices2);

        int[] indices3 = TwoSum.findTwoSum(new int[]{1, 2}, 5);
        assertNull(indices3);
    }
}
