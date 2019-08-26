package javaeight.stream.introduction;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DishTest {

    private List<Dish> menu;

    @Before
    public void setUp() {
        menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER)
        );
    }

    @Test
    public void sumCalories() {
        int sum = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        assertEquals(800 + 700 + 400 + 530, sum);
    }

    @Test
    public void boxedFromIntStream() {
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> boxed = intStream.boxed();
    }


}
