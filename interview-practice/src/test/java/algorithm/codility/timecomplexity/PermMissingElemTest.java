package algorithm.codility.timecomplexity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PermMissingElemTest {

    @Test
    public void solution() {
        assertEquals(4, PermMissingElem.solution(new int[]{2, 3, 1, 5}));
    }
}
