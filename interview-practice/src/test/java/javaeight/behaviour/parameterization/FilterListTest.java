package javaeight.behaviour.parameterization;

import static java.util.stream.Collectors.summingInt;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FilterListTest {

    private static final List<Apple> inventory = Arrays.asList(
            new Apple("red", 100),
            new Apple("red", 200),
            new Apple("orange", 510),
            new Apple("green", 250));

    @Test
    public void filter() {
        List<Apple> filteredRed = FilterList.filter(inventory, (Apple apple) -> "green".equals(apple.getColor()));
        assertEquals(1, filteredRed.size());

        List<Apple> filteredHeavies = FilterList.filter(inventory, (Apple apple) -> apple.getWeight() > 500);
        assertEquals(1, filteredHeavies.size());

        List<Spinichi> inventory2 = Arrays.asList(
                new Spinichi(10, "전남"),
                new Spinichi(15, "전북"),
                new Spinichi(12, "충청북도"),
                new Spinichi(13, "강원도"));
        assertEquals(new Spinichi(13, "강원도"),
                FilterList.filter(inventory2, (Spinichi spinichi) -> "강원도".equals(spinichi.getOrigin())).get(0));
    }

    @Test
    public void methodParameterization() {
        inventory.stream().forEach(System.out::println);
        // Step1.
//        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
        // Step2. method parameterization
        inventory.sort(Comparator.comparing(Apple::getWeight));

        inventory.stream().forEach(System.out::println);
    }

    @Test
    public void lowLevelSum() {
        // Step1.
//        Integer sum = inventory.stream()
//                .map(Apple::getWeight)
//                .reduce(0, (a1, a2) -> a1 + a2);
//        assertEquals(100 + 200 + 510 + 250, sum.longValue());

        int sum = inventory.stream().collect(summingInt(Apple::getWeight));
        assertEquals(100 + 200 + 510 + 250, sum);
    }
}
