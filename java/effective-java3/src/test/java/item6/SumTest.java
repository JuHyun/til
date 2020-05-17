package item6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SumTest {

    @Test
    public void sum() {
        long start = System.nanoTime();
        long sum = Sum.sum();
        long duration = (System.nanoTime() - start) / 1_000_000;

        assertEquals(2305843005992468481L, sum);
        System.out.println("duration = " + duration);
    }
}
