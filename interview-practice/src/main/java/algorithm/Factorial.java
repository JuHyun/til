package algorithm;

public class Factorial {
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalStateException("n은 0이상이어야 합니다.");
        }
        if (n <= 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }
}
