package chap11;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class AsyncExerciseTest {

    private final AsyncExercise asyncExercise = new AsyncExercise();

    @Test
    public void findPrices() {
        long start = System.nanoTime();
        List<String> prices = asyncExercise.findPrices("my iphone 12");
        System.out.println("Done in " + (System.nanoTime() - start) / 1_000_000 + " msecs.");
        prices.stream().forEach(System.out::println);
    }

    @Test
    public void findPricesParallel() {
        long start = System.nanoTime();
        List<String> prices = asyncExercise.findPricesParallel("my iphone 12");
        System.out.println("Done in " + (System.nanoTime() - start) / 1_000_000 + " msecs.");
        prices.stream().forEach(System.out::println);
    }

    @Test
    public void findPricesFuture() {
        long start = System.nanoTime();
        List<String> prices = asyncExercise.findPricesFuture("my iphone 12");
        System.out.println("Done in " + (System.nanoTime() - start) / 1_000_000 + " msecs.");
        prices.stream().forEach(System.out::println);
    }

    @Test
    public void findPricesFutureExecutor() {
        long start = System.nanoTime();
        List<String> prices = asyncExercise.findPricesFutureExecutor("my iphone 12");
        System.out.println("Done in " + (System.nanoTime() - start) / 1_000_000 + " msecs.");
        prices.stream().forEach(System.out::println);
    }

    @Test
    public void findPriceInfos() {
        long start = System.nanoTime();
        List<String> prices = asyncExercise.findPriceInfos("my iphone 12");
        System.out.println("Done in " + (System.nanoTime() - start) / 1_000_000 + " msecs.");
        prices.stream().forEach(System.out::println);
    }

    @Test
    public void findPriceInfosParallel() {
        long start = System.nanoTime();
        List<String> prices = asyncExercise.findPriceInfosParallel("my iphone 12");
        System.out.println("Done in " + (System.nanoTime() - start) / 1_000_000 + " msecs.");
        prices.stream().forEach(System.out::println);
    }

    @Test
    public void findPriceInfosFuture() {
        long start = System.nanoTime();
        List<String> prices = asyncExercise.findPriceInfosFuture("my iphone 12");
        System.out.println("Done in " + (System.nanoTime() - start) / 1_000_000 + " msecs.");
        prices.stream().forEach(System.out::println);
    }

    @Test
    public void findPriceInfosUSDFuture() {
        long start = System.nanoTime();
        List<Double> prices = asyncExercise.findPriceInfosUSDFuture("my iphone 12");
        System.out.println("Done in " + (System.nanoTime() - start) / 1_000_000 + " msecs.");
        prices.stream().forEach(System.out::println);
    }

    @Test
    public void findPricesStream() {
        long start = System.nanoTime();
        Stream<CompletableFuture<Void>> futureStream = asyncExercise.findPricesStream("my iphone 12")
                .map(future -> future.thenAccept(System.out::println));
        System.out.println("Done in " + (System.nanoTime() - start) / 1_000_000 + " msecs.");
    }

    @Test
    public void test() {
        long start = System.nanoTime();
        CompletableFuture[] futures = asyncExercise.findPricesStream("my iphone 12")
                .map(f -> f.thenAccept(s ->
                        System.out.println(String.format("%s (done in %d) msec.", s,
                                (System.nanoTime() - start) / 1_000_000))))
                .toArray(size -> new CompletableFuture[size]);
        CompletableFuture.allOf(futures).join();
        System.out.println(String.format("All shops have now responded in %d msecs.",
                (System.nanoTime() - start) / 1_000_000));
    }
}
