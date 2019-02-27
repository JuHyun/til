package design.pattern.strategy;

public class Player {

    private String name;

    private Strategy strategy;

    private int winCount;

    private int loseCount;

    private int gameCount;

    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public Hand nextHand() {
        return this.strategy.nextHand();
    }

    public void win() {
        this.strategy.study(true);
        winCount++;
        gameCount++;
    }

    public void lose() {
        this.strategy.study(false);
        loseCount++;
        gameCount++;
    }

    public void even() {
        gameCount++;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[").append(name).append("] : ")
                .append(gameCount).append(" games, ")
                .append(winCount).append(" won, ")
                .append(loseCount).append(" lose.");
        return stringBuilder.toString();
    }
}
