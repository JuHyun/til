package algorithm.codility;

/**
 * 연속된 1, 0, 1, 0 등으로 만들 수 있는 최소 변경 count 구하기.
 * ex) 1, 0, 1, 0, 1, 1 -> 1, 0, 1, 0, 1, 0 ==> 1
 *      0, 1, 1, 0 -> 1, 0, 1, 0 ==> 2
 *      0, 1, 0 -> 0, 1, 0 ==> 0
 *      1, 1, 0, 1, 1 -> 0, 1, 0, 1, 0 ==> 2
 */
public class MinimumConsecutiveReversing {

    // 1, 0, 1, 0, 1, 1
    public static int solution(int[] A) {
        if (A == null || A.length <= 1) {
            return 0;
        }

        int middleIndex = A.length / 2;

        int count = 0;
        count += leftSearching(A, 0, middleIndex - 1, A[middleIndex]);
        count += rightSearching(A, middleIndex + 1, A.length - 1, A[middleIndex]);
        return count;
    }

    public static int leftSearching(int[] A, int start, int finish, int value) {
        int countOfChanging = 0;

        for (int i = finish; i >= start; i--) {
            value ^= 1;
            if (A[i] != value) {
                countOfChanging++;
                A[i] = value;
            }
        }
        return countOfChanging;
    }

    public static int rightSearching(int[] A, int start, int finish, int value) {
        int countOfChanging = 0;

        for (int i = start; i <= finish; i++) {
            value ^= 1;
            if (A[i] != value) {
                countOfChanging++;
                A[i] = value;
            }
        }
        return countOfChanging;
    }
}
