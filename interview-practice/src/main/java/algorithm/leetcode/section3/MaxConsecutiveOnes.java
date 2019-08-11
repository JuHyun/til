package algorithm.leetcode.section3;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * <p>
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 * Note:
 * <p>
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 */
public class MaxConsecutiveOnes {

    // O(N^2)
    public static int findMaxConsecutiveOnes1(int[] nums) {
        int maxLength = 0;
        int size = nums.length;

        for (int i = 0; i < size; i++) {
            if (nums[i] == 1) {
                int currentLength = 1;
                int right = i + 1;
                while (right < size && nums[right] == 1) {
                    currentLength++;
                    right++;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }

    // O(N)
    public static int findMaxConsecutiveOnes2(int[] nums) {
        int maxLength = 0;
        int size = nums.length;

        for (int i = 0; i < size; i++) {
            if (nums[i] == 1) {
                int currentLength = 1;
                int right = i + 1;
                while (right < size && nums[right] == 1) {
                    currentLength++;
                    right++;
                }
                maxLength = Math.max(maxLength, currentLength);
                i = right;
            }
        }

        return maxLength;
    }

    // O(N)
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxLength = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                ++count;
            } else {
                maxLength = Math.max(maxLength, count);
                count = 0;
            }
        }

        // 마지막 index의 원소가 1인 경우를 위해서.
        maxLength = Math.max(maxLength, count);

        return maxLength;
    }
}
