package algorithm;

import java.util.Arrays;

public class Fibonacci {

    private int[] f;

    public Fibonacci(int n) {
        f = new int[n + 1];
        Arrays.fill(f, 0);
    }

    public static int fibonacci(int n) {
        if (n <= 2) {
            return 1;
        }
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public static int dynamicFibonacci(int n) {
        final int result[] = new int[n + 2];
        result[0] = 0;
        result[1] = 1;

        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }


    public int memoizationFibonacci(int n) {
        if (n <= 2) {
            return 1;
        }
        if (f[n] != 0) {
            return f[n];
        }

        f[n] = memoizationFibonacci(n - 2) + memoizationFibonacci(n - 1);
        return f[n];
    }
}
