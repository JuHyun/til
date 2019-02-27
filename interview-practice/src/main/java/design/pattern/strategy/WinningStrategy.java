package design.pattern.strategy;

import java.util.Random;

public class WinningStrategy implements Strategy {

    private boolean won = false;

    private Hand prevHand;

    private Random random;

    public WinningStrategy(int seed) {
        this.random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        if (!won) {
            prevHand = Hand.getHand(random.nextInt(3));
        }
        return prevHand;
    }

    @Override
    public void study(boolean win) {
        won = win;
    }
}
