package javaeight.stream.data.collect;

import static java.util.stream.Collectors.partitioningBy;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import javaeight.stream.introduction.Dish;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ToListCollectorTest {

    private final List<Dish> menus = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    );
    ;

    @Test
    public void test() {
        List<Dish> dishes = menus.stream().collect(new ToListCollector<>());
        assertEquals(9, dishes.size());
    }

    @Test
    public void test2() {
        List<Dish> dishes = menus.stream().collect(ArrayList::new, List::add, List::addAll);
        assertEquals(9, dishes.size());
    }

    @Test
    public void partitionPrimes() {
        Map<Boolean, List<Integer>> primes = partitionPrimes(10);
        List<Integer> integers = primes.get(true);
        assertArrayEquals(new Integer[]{2, 3, 5, 7}, integers.toArray());
    }

    // version 1.
    private Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(partitioningBy(candidate -> isPrime(candidate)));
    }

    private boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot).noneMatch(i -> candidate % i == 0);
    }

    // version2.
    private static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
        int i = 0;
        for (A item : list) {
            if (!p.test(item)) {
                return list.subList(0, i);
            }
            i++;
        }
        return list;
    }

    private boolean isPrime2(List<Integer> primes, int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return takeWhile(primes, i -> i <= candidateRoot).stream().noneMatch(p -> candidate % p == 0);
    }

    @Test
    public void isPrime2() {
        Map<Boolean, List<Integer>> primes = partitionPrimes(10);
        List<Integer> integers = primes.get(true);
        assertArrayEquals(new Integer[]{2, 3, 5, 7}, integers.toArray());
    }
}
