package algorithm.leetcode.section2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    // 시간 복잡도: O(N^2)
    public static int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("nums has to be a array.");
        }
        for (int index = 0; index < nums.length - 1; index++) {
            for (int j = index + 1; j < nums.length; j++) {
                if (nums[index] + nums[j] == target) {
                    return new int[]{index, j};
                }
            }
        }

        throw new RuntimeException("There is no solution.");
    }

    // 시간 복잡도: O(N)
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }

        throw new RuntimeException("There is no solution.");
    }

    // 시간 복잡도: O(1) or O(N)
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        throw new RuntimeException("There is no solution.");
    }

    // 시간 복잡도: O(N * logN)
    public static int[] twoSum4(int[] nums, int target) {
        // step1. sorted하기 위한 배열 생성
        // array [sorted value][원래 index]
        // ex) [5, 4, 1, 3]
        // array[0][0] = 5, array[0][1] = 0
        // array[1][0] = 4, array[1][1] = 1
        // array[2][0] = 1, array[2][1] = 2
        // array[3][0] = 3, array[3][1] = 3
        int[][] sorted = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            sorted[i][0] = nums[i];
            sorted[i][1] = i;
        }

        // step2. sorting nums based on sorted[i][0]
        // 일반적으로 sorting 시간 복잡도는 O(N * logN)
        Arrays.sort(sorted, Comparator.comparingInt(o -> o[0]));

        // step3.
        // if nums[left] + nums[right] == target ==> return (left, right)
        // if nums[left] + nums[right] > target ==> right-- until left < right
        // if nums[left] + nums[right] < target ==> left++  until left < right
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (sorted[left][0] + sorted[right][0] == target) {
                int[] result = new int[2];
                result[0] = Math.min(sorted[left][1], sorted[right][1]);
                result[1] = Math.max(sorted[left][1], sorted[right][1]);
                return result;
            }
            if (sorted[left][0] + sorted[right][0] > target) {
                right--;
            }
            if (sorted[left][0] + sorted[right][0] < target) {
                left++;
            }
        }

        throw new RuntimeException("There is no solution.");
    }
}
