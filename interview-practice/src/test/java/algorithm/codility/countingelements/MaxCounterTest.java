package algorithm.codility.countingelements;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxCounterTest {

    @Test
    public void solution() {
        assertArrayEquals(new int[] {3,2,2,4,2}, MaxCounter.solution(5, new int[] {3,4,4,6,1,4,4}));
    }
}
