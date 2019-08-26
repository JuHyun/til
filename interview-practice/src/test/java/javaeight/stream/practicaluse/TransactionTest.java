package javaeight.stream.practicaluse;

import static java.util.Comparator.comparing;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TransactionTest {

    private List<Transaction> transactions = null;

    @Before
    public void setUp() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
                new Transaction(raoul, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(raoul, 2012, 700),
                new Transaction(raoul, 2012, 950)
        );
    }

    @Test
    public void filter2011year() {
        List<Transaction> filtered2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(Collectors.toList());

        assertEquals(2, filtered2011.size());
        assertEquals(300, filtered2011.get(0).getValue());
    }


    @Test
    public void distinctCity() {
        List<String> distinctCities = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());

        assertArrayEquals(new String[]{"Cambridge", "Milan"}, distinctCities.toArray());
    }

    @Test
    public void findAllTrandersWorksAtCambridgeOrderByName() {
        List<Trader> cambridgeTraders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(Collectors.toList());

        assertEquals(1, cambridgeTraders.size());
        assertEquals("Raoul", cambridgeTraders.get(0).getName());
    }

    @Test
    public void findAllTradersOrderByName() {
        String names = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(","));

        assertEquals("Mario,Raoul", names);
    }

    @Test
    public void presentMilanoTrader() {
//        boolean present = transactions.stream()
//                .filter(transaction -> "Milan".equals(transaction.getTrader().getCity()))
//                .findAny()
//                .isPresent();
        boolean present = transactions.stream()
                .anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity()));
        assertTrue(present);
    }

    @Test
    public void printAllTransactionsInCambridge() {
        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    @Test
    public void findMaxValue() {
        Integer max = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .orElse(0);

        assertEquals(Integer.valueOf(1000), max);
    }

    @Test
    public void findMinValue() {
//        Integer min = transactions.stream()
//                .map(Transaction::getValue)
//                .reduce((a, b) -> a < b ? a : b)
//                .orElse(0);

//        Integer min = transactions.stream()
//                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2)
//                .get()
//                .getValue();
        Integer min = transactions.stream().min(comparing(Transaction::getValue)).get().getValue();

        assertEquals(Integer.valueOf(300), min);
    }

    @Test
    public void primitiveStreamSpecialization() {
        IntStream intStream = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
        assertEquals(50, intStream.count());

        IntStream intStream1 = IntStream.range(1, 100).filter(n -> n % 2 == 0);
        assertEquals(49, intStream1.count());
    }

    @Test
    public void pythagorean() {
        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .boxed()
                        .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                );

        pythagoreanTriples.limit(5)
                .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

        Stream<double[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                        .filter(t -> t[2] % 1 == 0)
                );
        pythagoreanTriples2.limit(5)
                .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
    }
}
