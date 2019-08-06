package algorithm.leetcode.section2;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class TwoSumTest {

    @Test
    public void twoSum1() {
        assertArrayEquals(new int[]{0, 1}, TwoSum.twoSum1(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 3}, TwoSum.twoSum1(new int[]{1, 3, 5, 6}, 9));
        assertArrayEquals(new int[]{0, 3}, TwoSum.twoSum1(new int[]{2, 7, 11, 15}, 17));
    }

    @Test
    public void twoSum2() {
        assertArrayEquals(new int[]{0, 1}, TwoSum.twoSum2(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 3}, TwoSum.twoSum2(new int[]{1, 3, 5, 6}, 9));
        assertArrayEquals(new int[]{0, 3}, TwoSum.twoSum2(new int[]{2, 7, 11, 15}, 17));
    }

    @Test
    public void twoSum3() {
        assertArrayEquals(new int[]{0, 1}, TwoSum.twoSum3(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 3}, TwoSum.twoSum3(new int[]{1, 3, 5, 6}, 9));
        assertArrayEquals(new int[]{0, 3}, TwoSum.twoSum3(new int[]{2, 7, 11, 15}, 17));
    }

    @Test
    public void twoSum4() {
        assertArrayEquals(new int[]{0, 1}, TwoSum.twoSum4(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 3}, TwoSum.twoSum4(new int[]{1, 3, 5, 6}, 9));
        assertArrayEquals(new int[]{0, 3}, TwoSum.twoSum4(new int[]{2, 7, 11, 15}, 17));

        // not sorting
        assertArrayEquals(new int[]{2, 3}, TwoSum.twoSum4(new int[]{15, 11, 7, 2}, 9));
        assertArrayEquals(new int[]{1, 2}, TwoSum.twoSum4(new int[]{7, 2, 15, 11}, 17));
    }
}
