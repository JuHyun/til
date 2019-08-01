package algorithm;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class CyclicRotationTest {

    @Test
    public void solution() {
        assertArrayEquals(new int[]{3, 8, 9, 7, 6}, CyclicRotation.solution(new int[]{3, 8, 9, 7, 6}, 0));
        assertArrayEquals(new int[]{6, 3, 8, 9, 7}, CyclicRotation.solution(new int[]{3, 8, 9, 7, 6}, 1));
        assertArrayEquals(new int[]{7, 6, 3, 8, 9}, CyclicRotation.solution(new int[]{3, 8, 9, 7, 6}, 2));
        assertArrayEquals(new int[]{9, 7, 6, 3, 8}, CyclicRotation.solution(new int[]{3, 8, 9, 7, 6}, 3));
        assertArrayEquals(new int[]{8, 9, 7, 6, 3}, CyclicRotation.solution(new int[]{3, 8, 9, 7, 6}, 4));
        assertArrayEquals(new int[]{3, 8, 9, 7, 6}, CyclicRotation.solution(new int[]{3, 8, 9, 7, 6}, 5));
        assertArrayEquals(new int[]{6, 3, 8, 9, 7}, CyclicRotation.solution(new int[]{3, 8, 9, 7, 6}, 6));
    }
}
