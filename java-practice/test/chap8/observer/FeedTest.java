package chap8.observer;

import org.junit.Test;

public class FeedTest {

    @Test
    public void test() {
        Feed f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());
        f.notifyObservers("The queen said her favorite book is Java 8 in Action!");
    }

    @Test
    public void lambdaTest() {
        Feed f = new Feed();
        f.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("money")) {
                System.out.println("Lambda Breaking news in NY! " + tweet);
            }
        });

        f.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("queen")) {
                System.out.println("Lambda Yet another news in London " + tweet);
            }
        });

        f.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("wine")) {
                System.out.println("Lambda Today cheese, wine and news!  " + tweet);
            }
        });

        f.notifyObservers("The queen said her favorite book is Java 8 in Action!");
    }
}
