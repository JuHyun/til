package javaeight.stream.eight.observer;

public class NYTimes implements Observer {

    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("money")) {
            System.out.println("Breaking news in YN! " + tweet);
        }
    }
}
