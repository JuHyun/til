package algorithm.codility;

public class ArbitrayInteger {

    public static int solution(int N) {
        int random = N + (int)(Math.random() * ((1000000000 - N) + 1));
//        System.out.println(random);
        int remainder = random % 10;
        if (remainder != 0) {
            return random + (10 - remainder);
        }
        return random;
//        int randomNumber = ThreadLocalRandom.current().nextInt(N, 999999999 + 1);
//        int remainder = randomNumber % 10;
//        return randomNumber + remainder;
    }
}
