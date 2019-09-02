package javaeight.stream.data.collect;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class PrimeNumberCollectorTest {

    @Test
    public void partitionPrimesWithCustomCollector() {
        Map<Boolean, List<Integer>> collect =
                IntStream.rangeClosed(2, 10).boxed().collect(new PrimeNumberCollector());
        List<Integer> primes = collect.get(true);
        assertArrayEquals(new Integer[]{2, 3, 5, 7}, primes.toArray());
    }

    @Test
    public void hardness() {
        long fastest = Long.MAX_VALUE;
    }
}
