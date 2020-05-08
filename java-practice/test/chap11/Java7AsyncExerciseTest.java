package chap11;

import org.junit.Test;

public class Java7AsyncExerciseTest {

    @Test
    public void test() {
        Java7AsyncExercise exercise = new Java7AsyncExercise();
        Double result = exercise.getData();
        System.out.println(result);
    }
}
