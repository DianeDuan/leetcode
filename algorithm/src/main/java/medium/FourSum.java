package algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem:
 * No: 18
 * Link: https://leetcode.com/problems/4sum/
 * <p/>
 * Analysis:
 * Similar to "3 Sum" problem.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<List<Integer>>();
        }

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {//avoid duplicates
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > (i + 1) && nums[j] == nums[j - 1]) {//avoid duplicates
                    continue;
                }
                for (int k = j + 1; k < nums.length - 1; k++) {
                    if (k > (j + 1) && nums[k] == nums[k - 1]) {//avoid duplicates
                        continue;
                    }
                    int rightIndex = Arrays.binarySearch(nums, k + 1, nums.length, target - nums[i] - nums[j] - nums[k]);
                    if (rightIndex >= 0) {
                        List<Integer> item = new ArrayList<Integer>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[k]);
                        item.add(nums[rightIndex]);
                        result.add(item);
                    }
                }
            }
        }
        return result;
    }
}
