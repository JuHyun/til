package algorithm.leetcode.section4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaximumProductOfThreeNumbersTest {

    @Test
    public void maximumProduct1() {
        assertEquals(6, MaximumProductOfThreeNumbers.maximumProduct1(new int[]{1, 2, 3}));
        assertEquals(24, MaximumProductOfThreeNumbers.maximumProduct1(new int[]{1, 2, 3, 4}));
        assertEquals(36, MaximumProductOfThreeNumbers.maximumProduct1(new int[]{-4, -3, -2, -1, 3}));
        assertEquals(6, MaximumProductOfThreeNumbers.maximumProduct1(new int[]{-4, 1, 2, 3}));
        assertEquals(720, MaximumProductOfThreeNumbers.maximumProduct1(new int[]{-4, -3, -2, -1, 60}));
        assertEquals(40000, MaximumProductOfThreeNumbers.maximumProduct1(new int[]{-100, -50, -10, -1, 8}));
        assertEquals(0, MaximumProductOfThreeNumbers.maximumProduct1(new int[]{0, 0, 0, 4}));
    }

    @Test
    public void maximumProduct2() {
        assertEquals(6, MaximumProductOfThreeNumbers.maximumProduct2(new int[]{1, 2, 3}));
        assertEquals(24, MaximumProductOfThreeNumbers.maximumProduct2(new int[]{1, 2, 3, 4}));
        assertEquals(36, MaximumProductOfThreeNumbers.maximumProduct2(new int[]{-4, -3, -2, -1, 3}));
        assertEquals(6, MaximumProductOfThreeNumbers.maximumProduct2(new int[]{-4, 1, 2, 3}));
        assertEquals(720, MaximumProductOfThreeNumbers.maximumProduct2(new int[]{-4, -3, -2, -1, 60}));
        assertEquals(40000, MaximumProductOfThreeNumbers.maximumProduct2(new int[]{-100, -50, -10, -1, 8}));
        assertEquals(0, MaximumProductOfThreeNumbers.maximumProduct2(new int[]{0, 0, 0, 4}));
    }

    @Test
    public void maximumProduct3() {
//        assertEquals(6, MaximumProductOfThreeNumbers.maximumProduct3(new int[]{1, 2, 3}));
//        assertEquals(24, MaximumProductOfThreeNumbers.maximumProduct3(new int[]{1, 2, 3, 4}));
//        assertEquals(36, MaximumProductOfThreeNumbers.maximumProduct3(new int[]{-4, -3, -2, -1, 3}));
//        assertEquals(6, MaximumProductOfThreeNumbers.maximumProduct3(new int[]{-4, 1, 2, 3}));
//        assertEquals(720, MaximumProductOfThreeNumbers.maximumProduct3(new int[]{-4, -3, -2, -1, 60}));
//        assertEquals(40000, MaximumProductOfThreeNumbers.maximumProduct3(new int[]{-100, -50, -10, -1, 8}));
//        assertEquals(0, MaximumProductOfThreeNumbers.maximumProduct3(new int[]{0, 0, 0, 4}));
        assertEquals(12, MaximumProductOfThreeNumbers.maximumProduct3(new int[]{1, 2, 3, 2}));
    }
}
