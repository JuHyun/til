package chap11;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

public class Java7AsyncExercise {

    private ExecutorService executor = Executors.newCachedThreadPool();

    private Future<Double> future = executor.submit(new Callable<Double>() {
        @Override
        public Double call() throws Exception {
            return doSomethingComputation();
        }
    });

    private Double doSomethingComputation() {
        try {
            Thread.sleep(1000L);
            Random random = new Random();
            return random.nextDouble();
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    public Double getData() {
        doSomethingElse();
        try {
            Double result = future.get(1, TimeUnit.SECONDS);
            return result;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void doSomethingElse() {
        IntStream.rangeClosed(1, 100).forEach(System.out::println);
    }
}
