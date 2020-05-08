package chap5;

import static java.util.stream.Collectors.toList;

import chap4.Dish;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExerciseTest {

    @Test
    public void quiz_5_2_1() {
        Integer[] integers = new Integer[]{1, 2, 3, 4, 5};

        List<Integer> squares = Arrays.stream(integers).map(i -> i * i).collect(toList());
        squares.stream().forEach(System.out::println);
    }

    @Test
    public void quiz_5_2_2() {
        Integer[] integers1 = new Integer[]{1, 2, 3};
        Integer[] integers2 = new Integer[]{3, 4};
        List<Integer[]> pairs = Arrays.stream(integers1)
                .flatMap(i -> Arrays.stream(integers2).map(j -> new Integer[]{i, j}))
                .collect(toList());

        pairs.stream().forEach(pair -> {
            Arrays.stream(pair).forEach(System.out::print);
            System.out.println();
        });
    }

    @Test
    public void quiz_5_2_3() {
        Integer[] integers1 = new Integer[]{1, 2, 3};
        Integer[] integers2 = new Integer[]{3, 4};
        List<Integer[]> pairs = Arrays.stream(integers1)
                .flatMap(i -> Arrays.stream(integers2)
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new Integer[]{i, j}))
                .collect(toList());
        pairs.stream().forEach(pair -> {
            Arrays.stream(pair).forEach(System.out::print);
            System.out.println();
        });
    }

    @Test
    public void quiz_5_3() {
        Integer countOfMenu = Dish.menu.stream().map(m -> 1).reduce(0, Integer::sum);
        System.out.println("count of menu is " + countOfMenu);

        long count = Dish.menu.stream().count();
        System.out.println("count of menu is " + count);
    }

    @Test
    public void totalCalories() {
        int total = Dish.menu.stream().mapToInt(menu -> menu.getCalories()).sum();
        System.out.println("total calories is " + total);

        OptionalInt maxCalories = Dish.menu.stream().mapToInt(Dish::getCalories).max();
        int max = maxCalories.orElse(1);
        System.out.println("max => " + max);
    }

    @Test
    public void range() {
        Stream<int[]> pythagoreanTriples = IntStream.range(1, 100)
                .boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .boxed()
                        .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));

        pythagoreanTriples.limit(5)
                .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
    }

    @Test
    public void stream() {
        Stream<String> stream = Stream.of("Java 8", "Lambdas", "In ", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        Stream<String> emptyStream = Stream.empty();
        emptyStream.forEach(System.out::println);

        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println("sum => " + sum);

        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get("/data.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("uniqueWords => " + uniqueWords);
    }

    @Test
    public void iterate() {
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
    }

    @Test
    public void fibonachi() {
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .mapToInt(t -> t[0])
                .forEach(System.out::println);
    }

    @Test
    public void generate() {
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        IntStream.generate(() -> 2).limit(5).forEach(System.out::println);
    }
}
