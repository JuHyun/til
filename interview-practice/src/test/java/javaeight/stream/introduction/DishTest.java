package javaeight.stream.introduction;

import static java.util.stream.Collectors.groupingBy;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
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

    @Test
    public void dishesByCaloricLevel() {
        // Step1. before refactoring
//        Map<Dish.CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(groupingBy(dish -> {
//            if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
//            else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
//            else return Dish.CaloricLevel.FAT;
//        }));

        // Step2. after refactoring
        Map<Dish.CaloricLevel, List<Dish>> dishesByCaloricLevel =
                menu.stream().collect(groupingBy(Dish::getCaloricLevel));

        String dietDishName = dishesByCaloricLevel.get(Dish.CaloricLevel.DIET)
                .stream()
                .map(Dish::getName)
                .collect(Collectors.joining(","));

        assertEquals("chicken,rice,season fruit,prawns", dietDishName);
    }

    @Test
    public void dishesByTypeCaloricLevel() {
        // Step1. before refactoring
//        Map<Dish.Type, Map<Dish.CaloricLevel, List<Dish>>> dishesByTypeCaloricLevle = menu.stream().collect(
//                groupingBy(Dish::getType,
//                        groupingBy(dish -> {
//                            if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
//                            else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
//                            else return Dish.CaloricLevel.FAT;
//                        })
//                ));

        // Step2. method parameterization
        Map<Dish.Type, Map<Dish.CaloricLevel, List<Dish>>> dishesByTypeCaloricLevle =
                menu.stream()
                        .collect(
                                groupingBy(Dish::getType, groupingBy(Dish::getCaloricLevel)));

        System.out.println(dishesByTypeCaloricLevle);
        Map<Dish.CaloricLevel, List<Dish>> caloricLevelOfMeat = dishesByTypeCaloricLevle.get(Dish.Type.MEAT);
        assertEquals("chicken", caloricLevelOfMeat.get(Dish.CaloricLevel.DIET).get(0).getName());
    }

    @Test
    public void filterAndDishes() {
        // Step1.
        List<String> dishNames = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() > 300) {
                dishNames.add(dish.getName());
            }
        }
        assertEquals(7, dishNames.size());

        // Step2.
        List<String> dishNames2 =
                menu.parallelStream()
                        .filter(dish -> dish.getCalories() > 300)
                        .map(Dish::getName)
                        .collect(Collectors.toList());
        assertEquals(7, dishNames2.size());
    }
}
