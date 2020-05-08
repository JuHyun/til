package chap5;

import static java.util.stream.Collectors.toList;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TraderExerciseTest {

    private static final Trader raoul = new Trader("Raoul", "Cambridge");
    private static final Trader mario = new Trader("Mario", "Milan");
    private static final Trader alan = new Trader("Alan", "Cambridge");
    private static final Trader brian = new Trader("Brian", "Cambridge");

    private static final List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    @Test
    public void 실전_연습_5_5_1() {
        List<Transaction> transactionsIn2011 = transactions.stream().filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(toList());

        transactionsIn2011.stream().forEach(System.out::println);
    }

    @Test
    public void 실전_연습_5_5_2() {
        List<String> uniqueCity = transactions.stream().map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(toList());

        uniqueCity.stream().forEach(System.out::println);
    }

    @Test
    public void 실전_연습_5_5_3() {
        List<Trader> tradersInCambridge = transactions.stream().map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(toList());

        tradersInCambridge.stream().forEach(System.out::println);
    }

    @Test
    public void 실전_연습_5_5_4() {
        String allTraders = transactions.stream().map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .reduce("", (a, b) -> a + b + ",");
        System.out.println(allTraders);
    }

    @Test
    public void 실전_연습_5_5_5() {
        Optional<Trader> isMilanTrader = transactions.stream().map(Transaction::getTrader)
                .filter(trader -> "Milan".equals(trader.getCity()))
                .findAny();
        isMilanTrader.ifPresent(System.out::println);
    }

    @Test
    public void 실전_연습_5_5_6() {
        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    @Test
    public void 실전_연습_5_5_7() {
        Integer max = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer.MIN_VALUE, Integer::max);

        System.out.println("max => " + max);
    }

    @Test
    public void 실전_연습_5_5_8() {
        Optional<Transaction> min = transactions.stream().min(Comparator.comparing(Transaction::getValue));
        min.ifPresent(System.out::println);
    }
}
