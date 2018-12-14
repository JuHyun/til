import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertNull;

class TwoSumTest {

    @Test
    public void findTwoSum() {
        int[] indices = TwoSum.findTwoSum(new int[]{1, 3, 5, 3, 9}, 5);
        assertNull(indices);

        int[] indices2 = TwoSum.findTwoSum(new int[]{1, 3, 5, 3, 9}, 6);
        assertThat(indices2, equalTo(new int[]{0, 1}));

        int[] indices3 = TwoSum.findTwoSum(new int[] { 1, 2}, 5);
        assertNull(indices3);
    }
}