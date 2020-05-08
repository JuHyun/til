package chap7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ParallelStreamExerciseTest {

    @Test
    public void sequentialSumTest() {
        long sum = ParallelStreamExercise.sequentialSum(10);
        assertEquals(55, sum);
    }

    @Test
    public void parallelSumTest() {
        long sum = ParallelStreamExercise.parallelSum(10);
        assertEquals(55, sum);

        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    @Test
    public void measureSumPerfWithIterativeSumTest() {
        long time = ParallelStreamExercise.measureSumPerf(ParallelStreamExercise::iterativeSum, 10_000_000);
        System.out.println("ParallelStreamExercise::iterativeSum : " + time + " msecs.");
    }

    @Test
    public void measureSumPerfWithSequentialSumTest() {
        long time = ParallelStreamExercise.measureSumPerf(ParallelStreamExercise::sequentialSum, 10_000_000);
        System.out.println("ParallelStreamExercise::sequentialSum : " + time + " msecs.");
    }

    @Test
    public void measureSumPerfWithParallelSumTest() {
        long time = ParallelStreamExercise.measureSumPerf(ParallelStreamExercise::parallelSum, 10_000_000);
        System.out.println("ParallelStreamExercise::parallelSum : " + time + " msecs.");
    }

    @Test
    public void measureSumPerfWithRangedSumTest() {
        long time = ParallelStreamExercise.measureSumPerf(ParallelStreamExercise::rangedSum, 10_000_000);
        System.out.println("ParallelStreamExercise::rangedSum : " + time + " msecs.");
    }

    @Test
    public void measureSumPerfWithParallelRangedSumTest() {
        long time = ParallelStreamExercise.measureSumPerf(ParallelStreamExercise::parallelRangedSum, 10_000_000);
        System.out.println("ParallelStreamExercise::parallelRangedSum : " + time + " msecs.");
    }

    @Test
    public void measureSumPerfWithSideEffectSumTest() {
        long time = ParallelStreamExercise.measureSumPerf(ParallelStreamExercise::sideEffectSum, 10_000_000);
        System.out.println("ParallelStreamExercise::sideEffectSum : " + time + " msecs.");
    }

    @Test
    public void measureSumPerfWithSideEffectParallelSumTest() {
        long time = ParallelStreamExercise.measureSumPerf(ParallelStreamExercise::sideEffectParallelSum, 10_000_000);
        System.out.println("ParallelStreamExercise::sideEffectParallelSum : " + time + " msecs.");
    }

    @Test
    public void measureSumPerfWithForKJoinSumTest() {
        long time = ParallelStreamExercise.measureSumPerf(ParallelStreamExercise::forKJoinSum, 10_000_000);
        System.out.println("ParallelStreamExercise::forKJoinSum : " + time + " msecs.");
    }
}
