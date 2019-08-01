package algorithm;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OddOccurrencesInArrayTest {

    @Test
    public void solution() {
        assertEquals(7, OddOccurrencesInArray.solution(new int[]{9, 3, 9, 3, 9, 7, 9}));
        assertEquals(5, OddOccurrencesInArray.solution(new int[]{10, 2, 2, 10, 2, 10, 10, 2, 5}));
    }
}
