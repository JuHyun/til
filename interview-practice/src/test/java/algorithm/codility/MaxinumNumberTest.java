package algorithm.codility;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxinumNumberTest {

    @Test
    public void solution() {
        assertEquals(5268, MaxinumNumber.solution(268));
        assertEquals(50, MaxinumNumber.solution(0));
        assertEquals(5800, MaxinumNumber.solution(800));
        assertEquals(6750, MaxinumNumber.solution(670));
        assertEquals(6520, MaxinumNumber.solution(620));
        assertEquals(-5999, MaxinumNumber.solution(-999));
        assertEquals(-4567, MaxinumNumber.solution(-467));
    }
}
