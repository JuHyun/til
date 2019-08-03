package algorithm;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FillTheTiles3Test {

    @Test
    public void solution() {
        assertEquals(2, FillTheTiles3.solution(1));
        assertEquals(7, FillTheTiles3.solution(2));
        assertEquals(22, FillTheTiles3.solution(3));
        assertEquals(71, FillTheTiles3.solution(4));
    }

    @Test
    public void solution2() {
        assertEquals(2, FillTheTiles3.solution2(1));
        assertEquals(7, FillTheTiles3.solution2(2));
        assertEquals(22, FillTheTiles3.solution2(3));
        assertEquals(71, FillTheTiles3.solution2(4));
    }
}
