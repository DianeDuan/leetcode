package algorithm.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * No: 1
 * Link: https://leetcode.com/problems/two-sum/
 * <p/>
 * Analysis:
 * Put numbers into a map, keys are for numbers, and values are for their indexes.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            if (numMap.containsKey(target - nums[i]) && numMap.get(target - nums[i]) != i) {
                result[0] = i;
                result[1] = numMap.get(target - nums[i]);
                break;
            }
        }
        return result;
    }
}
