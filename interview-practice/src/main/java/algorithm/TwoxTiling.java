package algorithm;

/**
 * https://www.acmicpc.net/problem/11726
 */
public class TwoxTiling {

    private int[] numbers;

    public TwoxTiling(int n) {
        numbers = new int[n + 1];
    }

    public int solution(int i) {
        if (i <= 0) return 0;
        if (i == 1) return 1;
        if (i == 2) return 2;
        if (numbers[i] != 0) return numbers[i];
        numbers[i] = solution(i - 2) + solution(i - 1);
        return numbers[i];
    }
}
