package algorithm;

/**
 * 10칸 짜리 계단이 있을 경우, 꼭대기까지 갈 수 있는 경우의 수를 구하시오.
 * 해결 방법: 그 전까지 계단의 경우의 수 합계 + 자기 자신만큼 한 걸음에 오를 수 있는 경우(1 가지)
 * <p>
 * f(0) = 0
 * f(1) = f(0) + 1
 * f(2) = f(1) + f(0) + 1
 * f(3) = f(2) + f(1) + f(0) + 1
 * f(4) = f(3) + f(2) + f(1) + f(0) + 1
 * f(n) = SUM(fun(n-1)) + 1
 */
public class StairReachCount {

    private static int[] result;

    public static int countWaysUntil(int count) {

        result = new int[count + 2];

        result[0] = 0;
        result[1] = 1;

        for (int i = 2; i <= count; i++) {
            result[i] = accumulate(i - 1) + 1;
        }

        return result[count];
    }

    private static int accumulate(int stair) {
        int sum = 0;
        for (int i = 0; i <= stair; i++) {
            sum += result[i];
        }
        return sum;
    }
}
