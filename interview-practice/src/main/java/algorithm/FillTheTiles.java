package algorithm;

/**
 * https://www.acmicpc.net/problem/2133
 * D[n] = 3 * D[n-2] + (2 * D[n-4] + 2 * D[n-6] + 2 * D[n-8] + .... + 2 * D[0])
 */
// TODO: 해결 못 하고 있음.
public class FillTheTiles {

    private static int[] memoization = new int[32];

    public static int solution(int n) {
        if (n == 0) return 1;
        if (n == 1) return 0;
        if (n == 2) return 3;
        if (memoization[n] != 0) return memoization[n];

        int result = solution(n - 2) * 3;
        for (int i = 3; i <= n; i++) {
            if (i % 2 == 0) {
                result += 2 * solution(n - i);
            }
        }

        memoization[n] = result;
        return memoization[n];
    }
}
