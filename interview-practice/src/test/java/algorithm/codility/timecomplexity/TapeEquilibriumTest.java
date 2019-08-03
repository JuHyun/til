package algorithm.codility.timecomplexity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TapeEquilibriumTest {

    @Test
    public void solution() {
        assertEquals(1, TapeEquilibrium.solution(new int[]{3, 1, 2, 4, 3}));
    }

    @Test
    public void solution2() {
        assertEquals(1, TapeEquilibrium.solution2(new int[]{3, 1, 2, 4, 3}));
    }
}
