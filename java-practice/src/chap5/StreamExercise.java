package chap5;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.IntSupplier;

public class StreamExercise {

    public static void main(String[] args) {
        String[] arrayOfWords = {"Goodbye", "World"};
//        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);
//
//        List<Stream<String>> collect = streamOfWords.map(word -> word.split(""))
//                .map(Arrays::stream)
//                .distinct()
//                .collect(toList());
//
//        collect.stream().forEach(System.out::println);

        List<String> uniqueCharacters = Arrays.stream(arrayOfWords)
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());

        uniqueCharacters.stream().forEach(System.out::println);

        optional();

        reduce();

        min_max();
    }

    public static void optional() {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream().map(x -> x * x)
                .filter(x -> x % 3 == 0)
                .findFirst();

        firstSquareDivisibleByThree.ifPresent(a -> System.out.println(a));
    }

    public static void reduce() {
        int[] integers = new int[]{1, 2, 3, 4, 5};
        int sum = Arrays.stream(integers).reduce(0, (a, b) -> a + b);
        System.out.println("sum => " + sum);

        OptionalInt reduce = Arrays.stream(integers).reduce(Integer::sum);
        System.out.println("sum => " + reduce.orElse(0));
    }

    public static void min_max() {
        int[] integers = new int[]{1, 2, 3, 4, 5};
        int max = Arrays.stream(integers).reduce(Integer.MIN_VALUE, Integer::max);
        System.out.println("max => " + max);

        int min = Arrays.stream(integers).reduce(Integer.MAX_VALUE, Integer::min);
        System.out.println("min => " + min);
    }
}
