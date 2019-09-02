package javaeight.stream.eight;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ParallelStreamPracticeTest {

    @Test
    public void sequentialSum() {
        assertEquals(55, ParallelStreamPractice.sequentialSum(10));
    }

    @Test
    public void iterativeSum() {
        assertEquals(55, ParallelStreamPractice.iterativeSum(10));
    }

    @Test
    public void parallelSum() {
        assertEquals(55, ParallelStreamPractice.parallelSum(10));
    }

    @Test
    public void rangedSum() {
        assertEquals(55, ParallelStreamPractice.rangedSum(10));
    }

    @Test
    public void measureSumPerformance() {
        ParallelStreamPractice parallelStreamPractice = new ParallelStreamPractice();
        System.out.println("Sequential sum done in: " +
                parallelStreamPractice.measureSumPerformance(ParallelStreamPractice::sequentialSum, 10_000_000));

        System.out.println("Iterative sum done in: " +
                parallelStreamPractice.measureSumPerformance(ParallelStreamPractice::iterativeSum, 10_000_000));

        System.out.println("Parallel sum done in: " +
                parallelStreamPractice.measureSumPerformance(ParallelStreamPractice::parallelSum, 10_000_000));

        System.out.println("Ranged sum done in: " +
                parallelStreamPractice.measureSumPerformance(ParallelStreamPractice::rangedSum, 10_000_000));

        System.out.println("Parallel range sum done in: " +
                parallelStreamPractice.measureSumPerformance(ParallelStreamPractice::parallelRangedSum, 10_000_000));
    }

    @Test
    public void fileReadToStream() throws IOException {
        String oneLine = processFile((BufferedReader b) -> b.readLine());
        String twoLine = processFile((BufferedReader b) -> b.readLine() + b.readLine());
        System.out.println(oneLine);
        System.out.println(twoLine);
    }

    private String processFile(BufferedReaderProcessor p) throws IOException {
        InputStream fileStream = this.getClass().getResourceAsStream("/revelator_eyes.log");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(fileStream))) {
            return p.process(br);
        }
    }

    public interface BufferedReaderProcessor {
        String process(BufferedReader b) throws IOException;
    }
}
