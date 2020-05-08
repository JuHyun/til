package chap13;

import org.junit.Test;

import java.util.stream.IntStream;

public class LazyEvaluationExerciseTest {

    @Test
    public void test() {
        IntStream numbers = LazyEvaluationExercise.numbers();
        int head = LazyEvaluationExercise.head(numbers);
        IntStream filtered = LazyEvaluationExercise.tail(numbers).filter(n -> n % head != 0);

        IntStream primes = LazyEvaluationExercise.primes(numbers);
        primes.forEach(System.out::println);
    }

    @Test
    public void test2() {
        MyList<Integer> l = new MyLinkedList<>(5, new MyLinkedList<>(10, new Empty<>()));
    }

    @Test
    public void from() {
        LazyList<Integer> numbers = LazyEvaluationExercise.from(2);
        int two = numbers.head();
        int three = numbers.tail().head();
        int four = numbers.tail().tail().head();

        System.out.println(two + " " + three + " " + four);
    }

    @Test
    public void primes() {
        LazyList<Integer> numbers = LazyEvaluationExercise.from(2);
        int two = LazyEvaluationExercise.primes(numbers).head();
        int three = LazyEvaluationExercise.primes(numbers).tail().head();
        int five = LazyEvaluationExercise.primes(numbers).tail().tail().head();
        System.out.println(two + " " + three + " " + five);
    }
}
