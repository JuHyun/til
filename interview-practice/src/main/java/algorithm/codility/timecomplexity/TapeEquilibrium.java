package algorithm.codility.timecomplexity;

public class TapeEquilibrium {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int[][] matrix = new int[A.length - 1][3];

        int sum = summarize(A);

        int minGap = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            if (i == 0) {
                matrix[i][0] = A[i];
            } else {
                matrix[i][0] = matrix[i - 1][0] + A[i];
            }
            matrix[i][1] = sum - matrix[i][0];
            matrix[i][2] = Math.abs(matrix[i][0] - matrix[i][1]);

            if (minGap > matrix[i][2]) {
                minGap = matrix[i][2];
            }
        }

        return minGap;
    }

    public static int solution2(int[] A) {
        // write your code in Java SE 8

        int sum = summarize(A);
        int left = 0;
        int right = sum;
        int minGap = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            left += A[i];
            right -= A[i];
            int gab = Math.abs(left - right);
            if (minGap > gab) {
                minGap = gab;
            }
        }

        return minGap;
    }

    private static int summarize(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        return sum;
    }
}
