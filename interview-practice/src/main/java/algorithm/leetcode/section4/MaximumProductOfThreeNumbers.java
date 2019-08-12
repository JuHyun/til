package algorithm.leetcode.section4;

import java.util.Arrays;

/**
 * 628. Maximum Product of Three Numbers
 * <p>
 * https://leetcode.com/problems/maximum-product-of-three-numbers/
 * <p>
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: 6
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: [1,2,3,4]
 * Output: 24
 * <p>
 * <p>
 * Note:
 * <p>
 * The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 * Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 */
public class MaximumProductOfThreeNumbers {

    // O(n^3)
    public static int maximumProduct1(int[] nums) {
        if (nums.length < 3) {
            throw new IllegalArgumentException("3개 이상 원소가 존재해야 합니다.");
        }

        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        // 1. 정렬 - O(n log n)
        Arrays.sort(nums);

        int length = nums.length;
        if (nums[0] < 0) {
            // 2. 큰 수 3개 곱하기. - O(n^3)
            int maxOfMultiply = 0;
            for (int i = 0; i < length - 2; i++) {
                for (int j = i + 1; j < length - 1; j++) {
                    for (int k = j + 1; k < length; k++) {
                        int multiply = nums[i] * nums[j] * nums[k];
                        if (maxOfMultiply < multiply) {
                            maxOfMultiply = multiply;
                        }
                    }
                }
            }
            return maxOfMultiply;
        }

        return nums[length - 1] * nums[length - 2] * nums[length - 3];
    }

    // O(n * log n)
    public static int maximumProduct2(int[] nums) {
        if (nums.length < 3) {
            throw new IllegalArgumentException("3개 이상 원소가 존재해야 합니다.");
        }

        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        // 1. 정렬 - O(n log n)
        Arrays.sort(nums);

        // 2. case1. 모두 양수인 경우, int multiply1 = numbers[n] * numbers[n-1] * numbers[n-2]
        //    case2. 첫 두개가 음수인 경우, int multiply2 = numbers[0] * numbers[1] * numbers[n]
        int length = nums.length;
        int multiply1 = nums[length - 1] * nums[length - 2] * nums[length - 3];
        int multiply2 = nums[0] * nums[1] * nums[length - 1];

        // 3. Max(case1, case2)
        return Math.max(multiply1, multiply2);
    }

    // O(n)
    // 위의 내용 main concept 그대로 갖고 오는데, 대신 정렬을 전체 다 하지 않는 걸로 함.
    // max값 3개, min값 2개만 알고 이들 숫자의 곱셈이 큰 값을 찾으면 되기 때문임.
    public static int maximumProduct3(int[] nums) {
        if (nums.length < 3) {
            throw new IllegalArgumentException("3개 이상 원소가 존재해야 합니다.");
        }

        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }

        // STEP1. 큰 숫자 3개, 작은 숫자 2개만 찾기.
        int length = nums.length;
        // max3 >= max2 >= max1
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        // min2 <= min1
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if (nums[i] >= max3) {
                max1 = max2;
                max2 = max3;
                max3 = nums[i];
            } else if (nums[i] >= max2) {
                max1 = max2;
                max2 = nums[i];
            } else if (nums[i] >= max1) {
                max1 = nums[i];
            }

            if (nums[i] <= min2) {
                min1 = min2;
                min2 = nums[i];
            } else if (nums[i] <= min1) {
                min1 = nums[i];
            }
        }


        // STEP 2.
        // case1. 모두 양수인 경우, int multiply1 = numbers[n] * numbers[n-1] * numbers[n-2]
        // case2. 첫 두개가 음수인 경우, int multiply2 = numbers[0] * numbers[1] * numbers[n]

        int multiply1 = max3 * max2 * max1;
        int multiply2 = min2 * min1 * max3;

        // 3. Max(case1, case2)
        return Math.max(multiply1, multiply2);
    }
}
