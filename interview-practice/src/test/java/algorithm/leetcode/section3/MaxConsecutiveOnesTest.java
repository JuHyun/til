package algorithm.leetcode.section3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxConsecutiveOnesTest {

    @Test
    public void findMaxConsecutiveOnes1() {
        assertEquals(3, MaxConsecutiveOnes.findMaxConsecutiveOnes1(new int[]{1, 1, 0, 1, 1, 1}));
        assertEquals(2, MaxConsecutiveOnes.findMaxConsecutiveOnes1(new int[]{1, 0, 1, 1, 0, 1}));
        assertEquals(5, MaxConsecutiveOnes.findMaxConsecutiveOnes1(new int[]{1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1,
                0, 0}));
        assertEquals(16, MaxConsecutiveOnes.findMaxConsecutiveOnes1(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1}));
    }

    @Test
    public void findMaxConsecutiveOnes2() {
        assertEquals(3, MaxConsecutiveOnes.findMaxConsecutiveOnes2(new int[]{1, 1, 0, 1, 1, 1}));
        assertEquals(2, MaxConsecutiveOnes.findMaxConsecutiveOnes2(new int[]{1, 0, 1, 1, 0, 1}));
        assertEquals(5, MaxConsecutiveOnes.findMaxConsecutiveOnes2(new int[]{1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1,
                0, 0}));
        assertEquals(16, MaxConsecutiveOnes.findMaxConsecutiveOnes2(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1}));
    }

    @Test
    public void findMaxConsecutiveOnes() {
        assertEquals(3, MaxConsecutiveOnes.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
        assertEquals(2, MaxConsecutiveOnes.findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));
        assertEquals(5, MaxConsecutiveOnes.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1,
                0, 0}));
        assertEquals(16, MaxConsecutiveOnes.findMaxConsecutiveOnes(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1}));
    }
}
