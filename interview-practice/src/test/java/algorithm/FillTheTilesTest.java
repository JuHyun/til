package algorithm;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FillTheTilesTest {

    @Test
    public void solution() {
        assertEquals(3, FillTheTiles.solution(2));
        assertEquals(0, FillTheTiles.solution(3));
        assertEquals(11, FillTheTiles.solution(4));
    }
}
