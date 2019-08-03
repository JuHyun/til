package algorithm;

/**
 * https://www.acmicpc.net/problem/14852
 * https://www.youtube.com/watch?v=kYoKLm8BZtI
 * D[n] = D[n-1] * 2 + D[n-2] * 3 + (D[n-3] * 2 + D[n-4] * 2 + D[n-5] * 2 + ... + D[0] * 2)
 */
public class FillTheTiles3 {

    private static int[] memoization = new int[1000000 + 1];

    // 시간이 많이 걸림...
    public static int solution(int x) {
        if (x == 0) return 1;
        if (x == 1) return 2;
        if (x == 2) return 7;
        if (memoization[x] != 0) return memoization[x];

        int result = 3 * solution(x - 2) + 2 * solution(x - 1);
        for (int i = 3; i <= x; i++) {
            result += (2 * solution(x - i)) % 1000000007;
        }

        memoization[x] = result % 1000000007;
        return memoization[x];
    }

    /**
     *  0  1  2                    3                      4
     *  -------------------------------------------------------------
     * [0, 2, 7, 3*2 + 7*2 + 2*1 = 22, 3*7 + 2*22 + 2*8 = 71, ...]
     * [ ,  , 1,             1+0 =  1,              1+7 =  8, ...]
     */
    private static long[][] memoization2 = new long[1000000 + 1][2];

    public static long solution2(int x) {
        memoization2[0][0] = 0;
        memoization2[1][0] = 2;
        memoization2[2][0] = 7;
        memoization2[2][1] = 1;

        for (int i = 3; i <= x; i++) {
            memoization2[i][1] = (memoization2[i - 1][1] + memoization2[i - 3][0]) % 1000000007;
            memoization2[i][0] = (3 * memoization2[i - 2][0] + 2 * memoization2[i - 1][0] + 2 * memoization2[i][1]) % 1000000007;
        }

        return memoization2[x][0];
    }
}
