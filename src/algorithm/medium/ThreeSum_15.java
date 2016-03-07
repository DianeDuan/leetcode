package algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem:
 * https://leetcode.com/problems/3sum/
 * <p/>
 * Analysis:
 * Traverse the array to get all pairs of the first number and the second number,
 * the use binary search to find if there is the third number.
 */
public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<List<Integer>>();
        }

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {//avoid duplicates
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > (i + 1) && nums[j] == nums[j - 1]) {//avoid duplicates
                    continue;
                }
                int rightIndex = Arrays.binarySearch(nums, j + 1, nums.length, -nums[i] - nums[j]);
                if (rightIndex >= 0) {
                    List<Integer> item = new ArrayList<Integer>();
                    item.add(nums[i]);
                    item.add(nums[j]);
                    item.add(nums[rightIndex]);
                    result.add(item);
                }
            }
        }
        return result;
    }
}
