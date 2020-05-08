package chap6;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class PrimeNumbersCollectorTest {

    private Map<Boolean, List<Integer>> partitionPrimesCustomCollector(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(new PrimeNumbersCollector());
    }

    @Test
    public void test() {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            partitionPrimesCustomCollector(1_000_000);
            long duration = (System.nanoTime() - start) / 1_000_000;
            if (duration < fastest) {
                fastest = duration;
            }
        }
        System.out.println("Fastest execution done in " + fastest + " msecs.");
    }
}
