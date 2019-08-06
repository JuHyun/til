package algorithm.codility;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinimumConsecutiveReversingTest {

    @Test
    public void solution() {
        assertEquals(1, MinimumConsecutiveReversing.solution(new int[]{1, 0, 1, 0, 1, 1}));
        assertEquals(2, MinimumConsecutiveReversing.solution(new int[]{0, 1, 1, 0}));
        assertEquals(0, MinimumConsecutiveReversing.solution(new int[]{0, 1, 0}));
        assertEquals(2, MinimumConsecutiveReversing.solution(new int[]{1, 1, 0, 1, 1}));
    }
}
