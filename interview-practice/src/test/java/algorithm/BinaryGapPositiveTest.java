package algorithm;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinaryGapPositiveTest {

    @Test
    public void solution() {
        assertEquals(0, BinaryGapPositive.solution(0));
        assertEquals(2, BinaryGapPositive.solution(9));
        assertEquals(4, BinaryGapPositive.solution(529));
        assertEquals(1, BinaryGapPositive.solution(20));
        assertEquals(0, BinaryGapPositive.solution(15));
        assertEquals(0, BinaryGapPositive.solution(32));
    }
}
