package algorithm;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class TwoSumSolutionTest {

    @Test
    public void successIterator() {
        TwoSumSolution twoSumSolution = new TwoSumSolution();
        assertArrayEquals(new int[]{0, 1}, twoSumSolution.twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 3}, twoSumSolution.twoSum(new int[]{5, 3, 4, 7}, 10));
    }

    @Test
    public void successIteratorMap() {
        TwoSumSolution twoSumSolution = new TwoSumSolution();
        assertArrayEquals(new int[]{0, 1}, twoSumSolution.twoSum2(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 3}, twoSumSolution.twoSum2(new int[]{5, 3, 4, 7}, 10));
    }
}
