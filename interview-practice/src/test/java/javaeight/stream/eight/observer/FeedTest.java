package javaeight.stream.eight.observer;

import org.junit.Test;

public class FeedTest {

    @Test
    public void feed() {
        Feed f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());
        f.notifyObservers("The queen said her favourite book is Java 8 in Action!");
    }

    @Test
    public void feedWithLambda() {
        Feed f = new Feed();
        f.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("money")) {
                System.out.println("Breaking news in YN! " + tweet);
            }
        });

        f.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("queen")) {
                System.out.println("Yet another news in London ... " + tweet);
            }
        });

        f.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("wine")) {
                System.out.println("Today cheese, wine and news! " + tweet);
            }
        });

        f.notifyObservers("The queen said her favourite book is Java 8 in Action!");
    }
}
