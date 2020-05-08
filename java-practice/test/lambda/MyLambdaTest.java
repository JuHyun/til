package lambda;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import domain.Apple;
import domain.Fruit;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class MyLambdaTest {

    @Test
    public void filter() {
        Predicate<String> nonEmptyStringPredicate = (String s) -> s != null && !s.isEmpty();
        List<String> listOfString = new ArrayList<String>(Arrays.asList("hello", "onyou", "hi", "eujean", "", null));
        List<String> result = MyLambda.filter(listOfString, nonEmptyStringPredicate);
        System.out.println(result.size());
        for (String a : result) {
            System.out.println(a);
        }
    }

    @Test
    public void accept() {
        MyLambda.accept(Arrays.asList(1, 2, 3, 4, 5), (Integer i) -> System.out.println(i));
    }

    @Test
    public void map() {
        List<Integer> results = MyLambda.map(Arrays.asList("lambdas", "in", "action"), (String s) -> s.length());
        for (Integer r : results) {
            System.out.println(r);
        }

        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<Apple> apples = MyLambda.map(weights, Apple::new);
        System.out.println(apples);

        BiFunction<String, Integer, Apple> apple = Apple::new;
        Apple greenApple = apple.apply("green", 110);
        System.out.println(greenApple);
    }

    @Test
    public void test() {
        IntPredicate evenNumbers = (int i) -> i % 2 == 0;
        assertTrue(evenNumbers.test(1000));

        Predicate<Integer> oddNumbers = (Integer i) -> i % 2 == 1;
        assertFalse(oddNumbers.test(1000));
    }

    @Test
    public void giveMeFruit() {
        Fruit apple10 = MyLambda.giveMeFruit("apple", 10);
        System.out.println(apple10.toString());
    }

    @Test
    public void tri() {
        
    }
}
