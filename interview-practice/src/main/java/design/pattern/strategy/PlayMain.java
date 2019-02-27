package design.pattern.strategy;

public class PlayMain {

    public static void main(String[] arg) {
        Player player1 = new Player("조코비치", new ProbStrategy(Integer.valueOf(1)));
        Player player2 = new Player("나달", new WinningStrategy(Integer.valueOf(10)));

        for (int i = 0; i < 10000; i++) {
            Hand nextHand1 = player1.nextHand();
            Hand nextHand2 = player2.nextHand();

            if (nextHand1.isStrongerThan(nextHand2)) {
                System.out.println("Winner:" + player1);
                player1.win();
                player2.lose();
            } else if (nextHand1.isWeakerrThan(nextHand2)) {
                System.out.println("Winner:" + player2);
                player1.lose();
                player2.win();
            } else {
                System.out.println("Even ...");
                player1.even();
                player2.even();
            }
        }

        System.out.println("Total Result is ...");
        System.out.println(player1.toString());
        System.out.println(player2.toString());
    }
}
