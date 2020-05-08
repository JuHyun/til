package chap13;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleUnaryOperator;

public class FunctionalExerciseTest {

    @Test
    public void subsets() {
        List<List<Integer>> subsets = FunctionalExercise.subsets(Arrays.asList(1, 4, 9));
        System.out.println(subsets);
    }

    @Test
    public void factorialIterative() {
        assertEquals(3628800, FunctionalExercise.factorialIterative(10));
    }

    @Test
    public void factorialRecursive() {
        assertEquals(3628800, FunctionalExercise.factorialRecursive(10));
    }

    @Test
    public void factorialStream() {
        assertEquals(3628800, FunctionalExercise.factorialStream(10));
    }

    @Test
    public void factorialTailRecursive() {
        assertEquals(3628800, FunctionalExercise.factorialTailRecursive(10));
    }

    @Test
    public void curriedConverter() {
        DoubleUnaryOperator convertCtoF = FunctionalExercise.curriedConverter(9.0 / 5, 32);
        assertEquals(50.0, convertCtoF.applyAsDouble(10), 0.0);
    }
}
