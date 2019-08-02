package algorithm;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/11727
 */
public class TwoxTiling2 {

    static int[] numbers = new int[1001];

    public static int solution(int n) {
        if (n == 1) return 1;
        if (n == 2) return 3;

        if (numbers[n] != 0) return numbers[n];

        numbers[n] = solution(n - 1) + 2 * solution(n - 2);


        return numbers[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(2) % 10007);
        System.out.println(solution(8) % 10007);
        System.out.println(solution(12) % 10007);
        Scanner sc = new Scanner(System.in);
        int a;
        a = sc.nextInt();
        System.out.println(solution(a) % 10007);
    }
}
