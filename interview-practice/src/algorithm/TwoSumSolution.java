package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSumSolution {

    public int[] twoSum(int[] nums, int target) {
        final int[] indices = new int[2];

        for (int index = 0; index < nums.length - 1; index++) {
            for (int j = index + 1; j < nums.length; j++) {
                if (nums[index] + nums[j] == target) {
                    indices[0] = index;
                    indices[1] = j;
                    return indices;
                }
            }
        }

        return indices;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }


        throw new IllegalArgumentException("There is no two sum.");
    }
}
