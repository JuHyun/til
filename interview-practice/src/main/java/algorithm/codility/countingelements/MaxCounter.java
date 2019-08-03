package algorithm.codility.countingelements;

public class MaxCounter {

    public static int[] solution(int N, int[] A) {
        int[] result = new int[N];

        int max = 0;
        for (int i = 0; i < A.length; i++) {
            int position = A[i];
            if (position > N) {
                maximization(result, max);
            } else {
                result[position - 1] += 1;
                if (max < result[position - 1]) {
                    max = result[position - 1];
                }
            }
        }
        return result;
    }

    private static void maximization(int[] result, int max) {
        for (int j = 0; j < result.length; j++) {
            result[j] = max;
        }
    }


}
