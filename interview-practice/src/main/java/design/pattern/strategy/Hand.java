package design.pattern.strategy;

public class Hand {

    public static final int HANDVALUE_ROCK = 0;
    public static final int HANDVALUE_SCISSOR = 1;
    public static final int HANDVALUE_PAPER = 2;

    public static final Hand[] hand = {
            new Hand(HANDVALUE_ROCK), new Hand(HANDVALUE_SCISSOR), new Hand(HANDVALUE_PAPER)
    };

    public String[] name = {"Rock", "Scissor", "Paper"};

    private int handValue;

    public int getHandValue() {
        return handValue;
    }

    public Hand(int handvalue) {
        this.handValue = handvalue;
    }

    public static Hand getHand(int handValue) {
        return hand[handValue];
    }

    public boolean isStrongerThan(Hand otherHand) {
        return fight(otherHand) == 1;
    }

    public boolean isWeakerrThan(Hand otherHand) {
        return fight(otherHand) == -1;
    }

    public int fight(Hand otherHand) {
        if (this == otherHand) return 0;
        if ((this.handValue + 1) % 3 == otherHand.getHandValue()) return 1;
        return -1;
    }

    public String toString() {
        return name[handValue];
    }
}
