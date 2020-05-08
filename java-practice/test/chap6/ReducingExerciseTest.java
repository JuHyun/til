package chap6;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.assertEquals;

import chap4.CaloricLeval;
import chap4.Dish;
import org.junit.Test;

import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReducingExerciseTest {

    @Test
    public void summarize() {
        assertEquals(9l, (long) Dish.menu.stream().collect(Collectors.counting()));
        assertEquals(9l, Dish.menu.stream().count());
    }

    @Test
    public void min_max() {
        Optional<Dish> mostCalorieDish = Dish.menu.stream().max(comparingInt(Dish::getCalories));
        assertEquals("pork", mostCalorieDish.get().getName());
    }

    @Test
    public void summing() {
        int totalCalories = Dish.menu.stream().collect(summingInt(Dish::getCalories));
        assertEquals(4300, totalCalories);
    }

    @Test
    public void average() {
        double avgCalories = Dish.menu.stream().collect(averagingInt(Dish::getCalories));
        assertEquals(477.77, avgCalories, 0.77);
    }

    @Test
    public void summarizing() {
        IntSummaryStatistics summaryStatistics = Dish.menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(summaryStatistics);
    }

    @Test
    public void joining() {
        String shortMenu = Dish.menu.stream().map(Dish::getName).collect(Collectors.joining(","));
//        assertEquals("pork,beef,chicken,french fries,rice,season fruit,pizza,prawns,salmon", shortMenu);
    }

    @Test
    public void reducing_total() {
        int totalCalories = Dish.menu.stream().map(Dish::getCalories).collect(reducing(0, (o1, o2) -> o1 + o2));
        assertEquals(4300, totalCalories);

        int totalOfCalories = Dish.menu.stream().collect(reducing(0, Dish::getCalories, (c1, c2) -> c1 + c2));
        assertEquals(4300, totalOfCalories);

        int totalCalories2 = Dish.menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
        assertEquals(4300, totalCalories2);
    }

    @Test
    public void reducing_max() {
        Optional<Dish> optionalMax = Dish.menu.stream().collect(reducing((c1, c2) -> c1.getCalories() > c2.getCalories() ? c1 : c2));
        assertEquals(800, optionalMax.get().getCalories());
    }

    @Test
    public void 퀴즈_6_1() {
        String shortMenu = Dish.menu.stream().map(Dish::getName).collect(Collectors.joining());
        System.out.println(shortMenu);

        String shortMenu1 = Dish.menu.stream().map(Dish::getName).collect(reducing((s1, s2) -> s1 + s2)).get();
        System.out.println(shortMenu1);

        // 같은 타입을 반환해야 하는데, Dish -> String 반환해서 에러 남.
//        Dish dish = Dish.menu.stream().collect(reducing((d1, d2) -> d1.getName() + d1.getName())).get();

        String shortMenu3 = Dish.menu.stream().collect(reducing("", Dish::getName, (s1, s2) -> s1 + s2));
        System.out.println(shortMenu3);
    }

    @Test
    public void grouping() {
        Map<Dish.Type, List<Dish>> dishesByType = Dish.menu.stream().collect(groupingBy(Dish::getType));
        assertEquals(3, dishesByType.size());

        Map<CaloricLeval, List<Dish>> dishesByCaloricLevel = Dish.menu.stream().collect(groupingBy(dish -> {
            if (dish.getCalories() <= 400) {
                return CaloricLeval.DIET;
            } else if (dish.getCalories() <= 700) {
                return CaloricLeval.NORMAL;
            } else {
                return CaloricLeval.FAT;
            }
        }));

        System.out.println(dishesByCaloricLevel);

        Map<Dish.Type, Integer> totalCaloriesByType = Dish.menu.stream()
                .collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
        System.out.println(totalCaloriesByType);
    }

    @Test
    public void subGrouping() {
        Map<Dish.Type, Long> typesCount = Dish.menu.stream().collect(groupingBy(Dish::getType, counting()));
        System.out.println(typesCount);

        Map<Dish.Type, Optional<Dish>> mostCaloricByType = Dish.menu.stream()
                .collect(groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));
        System.out.println(mostCaloricByType);
    }

    @Test
    public void groupingBy와_함께_사용하는_다른_컬렉터_예제() {
        Map<Dish.Type, Set<CaloricLeval>> caloricLevelByType = Dish.menu.stream().collect(
                groupingBy(Dish::getType, mapping(dish -> {
                    if (dish.getCalories() <= 400) {
                        return CaloricLeval.DIET;
                    } else if (dish.getCalories() <= 700) {
                        return CaloricLeval.NORMAL;
                    } else {
                        return CaloricLeval.FAT;
                    }
                }, toSet()))
        );

        System.out.println(caloricLevelByType);

        Map<Dish.Type, Set<CaloricLeval>> caloricLevelByType2 = Dish.menu.stream().collect(
                groupingBy(Dish::getType, mapping(dish -> {
                    if (dish.getCalories() <= 400) {
                        return CaloricLeval.DIET;
                    } else if (dish.getCalories() <= 700) {
                        return CaloricLeval.NORMAL;
                    } else {
                        return CaloricLeval.FAT;
                    }
                }, toCollection(HashSet::new)))
        );

        System.out.println(caloricLevelByType2);
    }

    @Test
    public void partitioning_function() {
        Map<Boolean, List<Dish>> partitionedMenu = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian));
        List<Dish> vegetarianDishes = partitionedMenu.get(true);
        assertEquals(4, vegetarianDishes.size());
    }

    @Test
    public void 분할의_장점() {
        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType = Dish.menu.stream()
                .collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
        System.out.println(vegetarianDishesByType);

        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian,
                collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(mostCaloricPartitionedByVegetarian);
    }

    @Test
    public void 퀴즈_6_2() {
        Map<Boolean, Map<Boolean, List<Dish>>> collect =
                Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian, partitioningBy(d -> d.getCalories() > 500)));
        System.out.println(collect);

        // error, partitioningBy는 boolean을 반환하는 함수임.
//        Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian, partitioningBy(Dish::getType)));

        Map<Boolean, Long> collect1 = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian, counting()));
        System.out.println(collect1);
    }

    @Test
    public void 숫자를_소수와_비소수로_뿐할하기() {
        Map<Boolean, List<Integer>> partitionPrimes = IntStream.rangeClosed(2, 100).boxed()
                .collect(partitioningBy(candidate -> isPrime(candidate)));
        System.out.println(partitionPrimes);
    }

    private boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }
}
