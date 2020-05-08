package chap3;

import domain.Apple;
import lambda.MyLambda;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class AppleComparatorTest {

    private final List<Apple> inventory = new ArrayList<>(
            Arrays.asList(new Apple("red", 500), new Apple("red", 520),
                    new Apple("red", 490), new Apple("green", 505),
                    new Apple("green", 490)));

    @Test
    public void parameter_behavior() {
        inventory.sort(new AppleComparator());
        inventory.stream().forEach(System.out::println);
    }

    @Test
    public void anonymous_class() {
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        inventory.stream().forEach(System.out::println);
    }

    @Test
    public void lambda() {
        inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
        inventory.stream().forEach(System.out::println);
    }

    @Test
    public void comparing() {
        inventory.sort(Comparator.comparing((a) -> a.getWeight()));
        inventory.stream().forEach(System.out::println);
    }

    @Test
    public void method_reference() {
        inventory.sort(Comparator.comparing(Apple::getWeight));
        inventory.stream().forEach(System.out::println);
    }

    @Test
    public void reversed() {
        inventory.sort(Comparator.comparing(Apple::getWeight).reversed());
        inventory.stream().forEach(System.out::println);
    }

    @Test
    public void concatenate() {
        inventory.sort(Comparator.comparing(Apple::getWeight)
                .thenComparing(Apple::getColor));
        inventory.stream().forEach(System.out::println);
    }

    @Test
    public void predicate_combine() {
        Predicate<Apple> redApple = (Apple a) -> "red".equals(a.getColor());
        Predicate<Apple> notRedApple = redApple.negate();

        List<Apple> redApples = MyLambda.filter(inventory, redApple);
        redApples.stream().forEach(System.out::println);

        List<Apple> notRedApples = MyLambda.filter(inventory, notRedApple);
        notRedApples.stream().forEach(System.out::println);

        Predicate<Apple> redAndHeavyOrNotRed = redApple.and(a -> a.getWeight() > 510).or(notRedApple);
        List<Apple> redAndHeavyOrNotRedApples = MyLambda.filter(inventory, redAndHeavyOrNotRed);
        redAndHeavyOrNotRedApples.stream().forEach(System.out::println);
    }
}
