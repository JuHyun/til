package algorithm.codility.countingelements;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PermCheckTest {

    @Test
    public void solution() {
        assertEquals(1, PermCheck.solution(new int[]{4, 1, 3, 2}));
        assertEquals(0, PermCheck.solution(new int[]{4, 1, 3}));
    }
}
