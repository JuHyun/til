package algorithm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StairReachCountTest {

    @Test
    public void countWaysUntil() {
        assertEquals(0, StairReachCount.countWaysUntil(0));
        assertEquals(1, StairReachCount.countWaysUntil(1));
        assertEquals(2, StairReachCount.countWaysUntil(2));
        assertEquals(4, StairReachCount.countWaysUntil(3));
        assertEquals(8, StairReachCount.countWaysUntil(4));
        assertEquals(16, StairReachCount.countWaysUntil(5));
    }
}
